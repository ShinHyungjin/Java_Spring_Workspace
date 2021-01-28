package com.koreait.restproject.android;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ChatThread extends Thread {
	Socket socket;
	BufferedReader br;
	BufferedWriter bw;
	boolean flag = true; // 쓰레드 가동 여부 결정 논리값
	ChatServer chatServer;

	public ChatThread(Socket socket, ChatServer chatServer) {
		this.socket = socket;
		this.chatServer = chatServer;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void listen() {
		String msg = null;
		try {
			msg = br.readLine();
			chatServer.area.append(msg + "\n");
			for(ChatThread chatThread : chatServer.vec) {
				chatThread.send(msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void send(String msg) {
		try {
			bw.write(msg + "\n");
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		while (flag) {
			listen();
		}
	}
}
