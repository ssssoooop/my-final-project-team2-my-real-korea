package com.itwill.my_real_korea.dao.user;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.my_real_korea.dto.user.User;

@Transactional
@SpringBootTest
//@MapperScan(basePackages = "com.itwill.my_real_korea.mapper")
class UserDaoImplTest {
	
	@Autowired
	private UserDao userDao;
	
	@Test
	void init() {
		System.out.println(userDao);
	}
	
	//1. 회원 가입
	@Test
	void testCreate() throws Exception {
		User user = new User("daoTest1", "test1111", "테스트", "테스트", "011-1111-1111", "test1@gmail.com", new Date(), "테스트", 0, 0, 1, 0, 0);
		System.out.println(">> created : "+userDao.create(user));
	}
	
	//2. 회원 정보 보기 (마이페이지)
	@Test
	void testFindUser() throws Exception {
		System.out.println(">> findUser : "+userDao.findUser("user1"));
	}
	
	//3. 전체 회원 정보 보기 (관리자 페이지)
	@Test
	void testFindUserList() throws Exception {
		System.out.println(">> findUserList : "+userDao.findUserList());
	}
	
	//4. 회원 정보 수정
	@Test
	void testUpdate() throws Exception {
		User user = userDao.findUser("user1");
		user.setPassword("user1112");
		user.setNickname("유저1");
		user.setPhone("011-1111-1112");
		user.setEmail("test1@naver.com");
		System.out.println(">> updated : "+userDao.update(user));
	}
	
	//5. 회원 탈퇴
	@Test
	void testRemove() throws Exception {
		int removeRowCount = userDao.remove("user3");
		System.out.println(">> removed rowCount : "+removeRowCount);
	}

	//11. 회원 존재 여부 확인
	@Test
	void testExistedUser() throws Exception {
		System.out.println(">> isExist : "+userDao.isExistUser("user1"));
	}
	
	//12. 비밀번호 일치 여부 확인
	@Test
	void isMatchPassword() throws Exception {
		System.out.println(">> isMatchPassword : "+userDao.isMatchPassword("admin","admin0000"));
	}
	
	//13. 이메일, 이름으로 아이디 찾기
	@Test
	void findId() throws Exception {
		User user = new User();
		user.setEmail("user1@gmail.com");
		user.setName("회원1");
		System.out.println(">> ID : "+userDao.findIdByEmailName(user));
	}




}
