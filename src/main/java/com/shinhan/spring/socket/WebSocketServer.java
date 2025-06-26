package com.shinhan.spring.socket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

 
@ServerEndpoint(value = "/chatserver", configurator = HttpSessionConfigurator.class)
public class WebSocketServer {
	 
	private static List<Session> list = new ArrayList<Session>();
	private static final ObjectMapper objectMapper = new ObjectMapper();

	@OnOpen  
	public void handleOpen(Session session, EndpointConfig config) {
		list.add(session);  
		HttpSession httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
		
		if (httpSession != null) {
			session.getUserProperties().put("httpSession", httpSession);
			System.out.println("WebSocket   HttpSession ID: " + httpSession.getId());
			
			ServletContext application = httpSession.getServletContext();
			application.setAttribute("totalUsers", 123);  
			
		}

	}

	@OnClose 
	public void handleClose(Session session) {
		list.remove(session);
	}

	@OnError 
	public void handleError(Throwable t) {
	}

	@OnMessage
	public void handleMessage(String message, Session session) {
		HttpSession httpSession = (HttpSession) session.getUserProperties().get("httpSession");
	
		if (httpSession != null) {
			httpSession.setAttribute("lastMessage", message);
		}

		try {
		
			ObjectNode received = (ObjectNode) objectMapper.readTree(message);

			String type = received.get("type").asText(); // "join" or "chat"
			String user = received.get("user").asText();
			String msgText = received.get("message").asText();
			for (Session s : list) {
				if (!s.equals(session)) {
					ObjectNode sendMsg = objectMapper.createObjectNode();
					if ("join".equals(type)) {
						sendMsg.put("type", "notice");
						sendMsg.put("message", user + "join.");

					} else if ("chat".equals(type)) {
						sendMsg.put("type", "chat");
						sendMsg.put("user", user);
						sendMsg.put("message", msgText);
					} else if ("leave".equals(type)) {
						sendMsg.put("type", "notice");
						sendMsg.put("message", user + "leave.");
					}
					s.getBasicRemote().sendText(sendMsg.toString());
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
