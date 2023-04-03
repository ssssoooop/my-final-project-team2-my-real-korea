package com.itwill.my_real_korea.dao.chat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.my_real_korea.dto.chat.ChatRoom;
import com.itwill.my_real_korea.mapper.ChatRoomMapper;

//@SpringBootApplication
@SpringBootTest
//@MapperScan(basePackages = "com.itwill.my_real_korea.mapper")
@MapperScan(basePackageClasses = ChatRoomMapper.class)
class ChatRoomDaoImplTest {

	@Autowired
	private ChatRoomDao chatRoomDao;
	
	
	@Test
	void testSelectAll() {
		assertNotNull(chatRoomDao.selectAll("user1"));
		System.out.println(chatRoomDao.selectAll("user1"));
	}

	@Disabled
	@Test
	void testSelectCheckByRoomNo() {
		assertNotNull(chatRoomDao.selectCheckByRoomNo(2));
		System.out.println(chatRoomDao.selectCheckByRoomNo(2));
	}

	@Disabled
	@Test
	void testSelectById() {
		assertNotNull(chatRoomDao.selectById("user1", "user2"));
		System.out.println(chatRoomDao.selectById("user1", "user2"));
	}

	@Disabled
	@Test
	void testSelectExist() {
		assertNotNull(chatRoomDao.selectExist("user1", "user2"));
		System.out.println(chatRoomDao.selectExist("user1", "user2"));
	}

	
	@Test
	void testInsertChatRoom() {
		int rowCount = chatRoomDao.insertChatRoom(new ChatRoom(0, "챗이름추가1","user2", "user1"));
		assertEquals(rowCount, 1);
	}

	@Disabled
	@Test
	void testDeleteChatRoom() {
		int rowCount = chatRoomDao.deleteChatRoom(4);
		assertEquals(rowCount, 1);
	}

	@Disabled
	@Test
	void testCountNotReadInChatRoom() {
		int rowCount = chatRoomDao.countNotReadInChatRoom(1, "user2");
		assertNotEquals(rowCount, 0);
		System.out.println(rowCount);
	}

}
