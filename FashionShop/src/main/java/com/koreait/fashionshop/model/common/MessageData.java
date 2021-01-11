package com.koreait.fashionshop.model.common;

import lombok.Data;

@Data
public class MessageData {
		private int resultCode;	//성공or실패
		private String msg;	//클라이언트가 보게 될 메시지
		private String url;	//새롭게 요청할 페이지가 있다면 url
}
