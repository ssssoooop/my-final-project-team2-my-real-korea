package com.itwill.my_real_korea.dao.freeboard;

//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

//import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.my_real_korea.dao.freeboard.FreeBoardDao;
import com.itwill.my_real_korea.dto.freeboard.FreeBoard;

@SpringBootTest
public class FreeBoardDaoImplTest {
	@Autowired
	private FreeBoardDao freeBoardDao;
//	
//	@Disabled
//	@Test
//	void testInsertBoard() {
//		int rowCount = freeBoardDao.insertBoard(new FreeBoard(0,"자유1","자유내용1",sysdate,0,1,"user1"));
//		assertEquals(rowCount, 1);
//	}
	
	@Disabled
	void testSelectAll() {
		fail("Not yet implemented");
	}
	
	@Disabled
	void testDeleteBoard() {
		fail("Not yet implemented");
	}
	
	@Disabled
	void testUpdateBoard() {
		fail("Not yet implemented");
	}
	@Disabled
	void testIncreaseReadCount() {
		fail("Not yet implemented");
	}
	@Disabled
	void testSelectFreeBoardCount() {
		fail("Not yet implemented");
	}
	@Disabled
	void testSelectSearch() {
		fail("Not yet implemented");
	}
	@Disabled
	void testSelectSearchList() {
		fail("Not yet implemented");
	}
	
}
