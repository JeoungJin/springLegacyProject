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

//웹소켓을 통한 실시간 양방향 통신을 가능하게 하는 서버 사이드의 연결점
@ServerEndpoint(value = "/chatserver", configurator = HttpSessionConfigurator.class)
public class WebSocketServer {
	// 현재 채팅 서버에 접속한 클라이언트(WebSocket Session) 목록
	private static List<Session> list = new ArrayList<Session>();
	private static final ObjectMapper objectMapper = new ObjectMapper();

	@OnOpen // 웹 소켓이 연결되면 호출되는 이벤트
	public void handleOpen(Session session, EndpointConfig config) {
		list.add(session); // 접속자 관리
		HttpSession httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
		
		if (httpSession != null) {
			session.getUserProperties().put("httpSession", httpSession);
			System.out.println("WebSocket 연결됨. HttpSession ID: " + httpSession.getId());
			
			ServletContext application = httpSession.getServletContext();
			application.setAttribute("totalUsers", 123); // 예시 저장
			
		}

	}

	@OnClose // 웹 소켓이 닫히면 호출되는 이벤트
	public void handleClose(Session session) {
		list.remove(session);
	}

	@OnError // 웹 소켓 에러가 나면 발생하는 이벤트
	public void handleError(Throwable t) {
	}

	@OnMessage
	public void handleMessage(String message, Session session) {
		HttpSession httpSession = (HttpSession) session.getUserProperties().get("httpSession");
		// HttpSession에 메시지 저장test
		if (httpSession != null) {
			httpSession.setAttribute("lastMessage", message);
		}

		try {
			// 수신 JSON 문자열 → JsonNode로 파싱
			ObjectNode received = (ObjectNode) objectMapper.readTree(message);

			String type = received.get("type").asText(); // "join" or "chat"
			String user = received.get("user").asText();
			String msgText = received.get("message").asText();
			for (Session s : list) {
				if (!s.equals(session)) {
					ObjectNode sendMsg = objectMapper.createObjectNode();
					if ("join".equals(type)) {
						sendMsg.put("type", "notice");
						sendMsg.put("message", user + "님이 입장하셨습니다.");

					} else if ("chat".equals(type)) {
						sendMsg.put("type", "chat");
						sendMsg.put("user", user);
						sendMsg.put("message", msgText);
					} else if ("leave".equals(type)) {
						sendMsg.put("type", "notice");
						sendMsg.put("message", user + "님이 퇴장하셨습니다.");
					}
					s.getBasicRemote().sendText(sendMsg.toString());
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
