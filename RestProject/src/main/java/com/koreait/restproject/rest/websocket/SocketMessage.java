package com.koreait.restproject.rest.websocket;

import lombok.Data;

@Data
public class SocketMessage {
	private String requestCode;
	private int resultCode;
	private String msg;
	private String data;

}
