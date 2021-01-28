package com.koreait.restproject.android;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame{
	JPanel p_north;
	JTextField t_port;
	JTextField t_ip;
	JButton bt_con;
	JTextArea area;
	JScrollPane scroll;
	JTextField t_input;
	Socket socket;
	ClientThread clientThread;
	
	public ChatClient() {
		p_north = new JPanel();
		t_ip = new JTextField("192.168.35.161",10);
		t_port = new JTextField("9999", 5);
		bt_con = new JButton("접속");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		t_input = new JTextField(20);
		
		p_north.add(t_ip);
		p_north.add(t_port);
		p_north.add(bt_con);
		
		add(p_north, BorderLayout.NORTH);
		add(scroll);
		add(t_input, BorderLayout.SOUTH);
		
		t_input.addKeyListener(new  KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					clientThread.send(t_input.getText());
					t_input.setText("");
				}
			}
		});
		
		bt_con.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				connectServer();
			}
		});
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				stopClient();
			}
		});
		
		setSize(300,400);
		setVisible(true);
	
	}

	public static void main(String[] args) {
		new ChatClient();
	}
	
	public void stopClient() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void connectServer() {
		try {
			socket = new Socket(t_ip.getText(),Integer.parseInt(t_port.getText()));
			clientThread = new ClientThread(socket, ChatClient.this);
			clientThread.start();
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
