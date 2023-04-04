package com.itwill.my_real_korea.service.user;

import java.util.List;

import com.itwill.my_real_korea.dto.user.User;

public interface UserService {

	//1. 회원 가입
	int create(User user) throws Exception;
	//2. 회원 정보 보기 (마이 페이지)
	User findUser(String userId) throws Exception;
	//3. 전체 회원 정보 보기 (관리자 페이지)
	List<User> findUserList() throws Exception;
	//4. 회원 정보 수정
	int update(User user) throws Exception;
	//5. 회원 탈퇴
	int remove(String userId) throws Exception;
	
	//11. 아이디 중복 체크 (회원 가입(회원 존재 여부 확인))
	boolean isDuplicateId(String userId) throws Exception;
	//12. 로그인 (비밀번호 일치 여부 확인)
	User login(String userId, String password) throws Exception;
	//13. 이메일, 이름으로 아이디 찾기
	String findIdByEmailName(User user) throws Exception;

	//21. 메일 인증여부 확인
	int mailAuth(String userId) throws Exception;
	//22. 메일 인증번호 업데이트
	int mailKeyUpdate(User user) throws Exception;
	//23. 메일 인증여부 업데이트
	int mailAuthUpdate(User user) throws Exception;
}