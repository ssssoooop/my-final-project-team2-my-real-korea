package com.itwill.my_real_korea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.my_real_korea.dto.chat.ChatRoom;
import com.itwill.my_real_korea.service.chat.ChatService;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2  //log 변수를 사용하여 로그 기록 가능
public class ChatController {

	@Autowired
	private ChatService chatService;
	
	/*
	"/chat" 경로로 GET 요청이 들어오면 "chat" 뷰를 반환하며, 이 과정에서 로그를 출력
	 */
	@GetMapping("/chat")
	public String chatGET() {
		
		log.info("@ChatController, chat GET()");
		return "chat";
	}
	
	// 채팅방 목록 보기 - 페이지로 할 지 rest 로 할 지 ...?
	@LoginCheck
	@GetMapping("/chatroom")
	public String chatroom_list(@RequestParam(required = true) String userId,
									Model model) {
		try {
			List<ChatRoom> chatRoomList = chatService.selectAll(userId);
			model.addAttribute("chatRoomList", chatRoomList);
			model.addAttribute("chatUserId", userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "chat-write-form";
	}
	
	// 채팅방 생성, 메세지 보낼 화면  - 채팅 첫 화면
	@LoginCheck
	@GetMapping("/chat-write-form")
	public String chat_write_form(@RequestParam(required = true) String userId,
									Model model) {
		model.addAttribute("chatUserId", userId);
		
		return "chat-write-form";
	}
	
	
	
	
}
