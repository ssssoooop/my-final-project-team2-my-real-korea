package com.itwill.my_real_korea.service.chat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import com.itwill.my_real_korea.dao.chat.ChatRoomDao;
import com.itwill.my_real_korea.dto.chat.ChatMsg;
import com.itwill.my_real_korea.dto.chat.ChatRoom;

@SpringBootApplication
@SpringBootTest
@ComponentScan(basePackages = {"com.itwill.my_real_korea"})
class ChatServiceImplTest {

	@Autowired
	private ChatService chatService;
	
	@Disabled
	@Test
	void testSelectAll() {
		assertNotNull(chatService.selectAll("user1")); 
		System.out.println(chatService.selectAll("user1"));
	}

	@Disabled
	@Test
	void testSelectCheckByRoomNo() {
		assertNotNull(chatService.selectCheckByRoomNo(2)); 
		System.out.println(chatService.selectCheckByRoomNo(2));
	}

	@Disabled
	@Test
	void testChatRoomNoSearchById() {
		int roomNo = chatService.chatRoomNoSearchById("user1", "user2");
		System.out.println(roomNo);
	}

	@Disabled
	@Test
	void testDuplicateCheck() {
		boolean isDuplicate = chatService.duplicateCheck("user1", "user2");
		assertTrue(isDuplicate);
		System.out.println(isDuplicate);
	}

	
	@Test
	void testInsertChatRoom() {
		int rowCount = chatService.insertChatRoom(new ChatRoom(0, "챗이름추가2", "user2", "user1"));
		assertEquals(rowCount, 1);
	}

	@Disabled
	@Test
	void testDeleteChatRoom() {
		int rowCount = chatService.deleteChatRoom(5);
		assertEquals(rowCount, 1);
	}

	@Disabled
	@Test
	void testCountNotReadInChatRoom() {
		int rowCount = chatService.countNotReadInChatRoom(1, "user2");
		assertNotEquals(rowCount, 0);
		System.out.println(rowCount);
	}

	@Disabled
	@Test
	void testSelectByRoomNo() {
		assertNotNull(chatService.selectByRoomNo(1)); 
		System.out.println(chatService.selectByRoomNo(1));
	}

	@Disabled
	@Test
	void testSelectByMsgNo() {
		assertNotNull(chatService.selectByMsgNo(3));
		System.out.println(chatService.selectByMsgNo(3));
	}

	@Disabled
	@Test
	void testSelectNotReadMsg() {
		assertNotNull(chatService.selectNotReadMsg(1, "user2"));
		System.out.println(chatService.selectNotReadMsg(1, "user2"));
	}

	@Disabled
	@Test
	void testCountNotReadMsg() {
		int countNo = chatService.countNotReadMsg(1, "user2");
		assertNotEquals(countNo, 0);
		System.out.println(countNo);
	}

	@Disabled
	@Test
	void testSelectAllNotReadMsg() {
		assertNotNull(chatService.selectAllNotReadMsg("user2"));
		System.out.println(chatService.selectAllNotReadMsg("user2"));
	}

	@Disabled
	@Test
	void testCountAllNotReadMsg() {
		int countNo = chatService.countAllNotReadMsg("user2");
		assertNotEquals(countNo, 0);
		System.out.println(countNo);
	}

	@Disabled
	@Test
	void testUpdateReadMsg() {
		int rowCount = chatService.updateReadMsg(1, "user2");
		assertNotEquals(rowCount, 0);
		System.out.println(rowCount);
	}

	@Disabled
	@Test
	void testDeleteChatMsg() {
		int rowCount = chatService.deleteChatMsg(8);
		assertNotEquals(rowCount, 0);
		System.out.println(rowCount);
	}

	@Disabled
	@Test
	void testUpdateDeletedMsg() {
		int rowCount = chatService.updateDeletedMsg(7);
		assertNotEquals(rowCount, 0);
		System.out.println(rowCount);
	}

	@Disabled
	@Test
	void testInsertChatMsg() {
		int rowCount = chatService.insertChatMsg(new ChatMsg(0, "하이하이", null, 0, 1, "user1"));
		assertEquals(rowCount, 1);
	}

}
