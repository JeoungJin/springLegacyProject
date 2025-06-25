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

//�������� ���� �ǽð� ����� ����� �����ϰ� �ϴ� ���� ���̵��� ������
@ServerEndpoint(value = "/chatserver", configurator = HttpSessionConfigurator.class)
public class WebSocketServer {
	// ���� ä�� ������ ������ Ŭ���̾�Ʈ(WebSocket Session) ���
	private static List<Session> list = new ArrayList<Session>();
	private static final ObjectMapper objectMapper = new ObjectMapper();

	@OnOpen // �� ������ ����Ǹ� ȣ��Ǵ� �̺�Ʈ
	public void handleOpen(Session session, EndpointConfig config) {
		list.add(session); // ������ ����
		HttpSession httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
		
		if (httpSession != null) {
			session.getUserProperties().put("httpSession", httpSession);
			System.out.println("WebSocket �����. HttpSession ID: " + httpSession.getId());
			
			ServletContext application = httpSession.getServletContext();
			application.setAttribute("totalUsers", 123); // ���� ����
			
		}

	}

	@OnClose // �� ������ ������ ȣ��Ǵ� �̺�Ʈ
	public void handleClose(Session session) {
		list.remove(session);
	}

	@OnError // �� ���� ������ ���� �߻��ϴ� �̺�Ʈ
	public void handleError(Throwable t) {
	}

	@OnMessage
	public void handleMessage(String message, Session session) {
		HttpSession httpSession = (HttpSession) session.getUserProperties().get("httpSession");
		// HttpSession�� �޽��� ����test
		if (httpSession != null) {
			httpSession.setAttribute("lastMessage", message);
		}

		try {
			// ���� JSON ���ڿ� �� JsonNode�� �Ľ�
			ObjectNode received = (ObjectNode) objectMapper.readTree(message);

			String type = received.get("type").asText(); // "join" or "chat"
			String user = received.get("user").asText();
			String msgText = received.get("message").asText();
			for (Session s : list) {
				if (!s.equals(session)) {
					ObjectNode sendMsg = objectMapper.createObjectNode();
					if ("join".equals(type)) {
						sendMsg.put("type", "notice");
						sendMsg.put("message", user + "���� �����ϼ̽��ϴ�.");

					} else if ("chat".equals(type)) {
						sendMsg.put("type", "chat");
						sendMsg.put("user", user);
						sendMsg.put("message", msgText);
					} else if ("leave".equals(type)) {
						sendMsg.put("type", "notice");
						sendMsg.put("message", user + "���� �����ϼ̽��ϴ�.");
					}
					s.getBasicRemote().sendText(sendMsg.toString());
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
