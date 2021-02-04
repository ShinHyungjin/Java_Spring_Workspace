package com.koreait.restproject.rest.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyWebSocketHandler extends TextWebSocketHandler {
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();

	// 클라이언트가 접속하면....
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		super.afterConnectionEstablished(session);
		log.debug("클라이언트 접속함 : {}", session.getId());
		sessionList.add(session);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		super.afterConnectionClosed(session, status);
		log.debug("접속 종료! {}, {}", session.getId(), status.getCode());
	}

	public void broadCast(String data) {
		try {
			for (WebSocketSession session : sessionList) {
				session.sendMessage(new TextMessage(data));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
