package com.itwill.my_real_korea.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.itwill.my_real_korea.handler.ChatHandler;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor  // 생성자 파라미터 자동 생성
@EnableWebSocket // WebSocket 활성화
public class WebSocketConfig implements WebSocketConfigurer{

	private final ChatHandler chatHandler;
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		/* 
		 WebSocket에 접속하기 위한 Endpoint : /chat 으로 설정
		 	(Endpoint : API가 서버에서 자원(resource)에 접근할 수 있도록 하는 URL),
		 해당 서버 모든 다른 도메인에서 들어오는 요청 허용 
		 => localhost/chat 으로 커넥션 연결, 메세지 통신할 준비 
		 */
		registry.addHandler(chatHandler, "ws/chat").setAllowedOrigins("*");
	}

}
