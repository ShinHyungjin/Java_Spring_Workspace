package com.koreait.mylegacy.exception;

public class RuntimeExceptionApp {
	public static void main(String[] args) {
		int [] arr = new int[3];
		
		try {
			arr[0] = 11;
			arr[1] = 12;
			arr[2] = 13;
			arr[3] = 1;
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 범위 넘어섰음!");
		}
	}
}
