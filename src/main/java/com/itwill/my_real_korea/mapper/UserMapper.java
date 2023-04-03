package com.itwill.my_real_korea.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.my_real_korea.dto.user.User;

@Mapper
public interface UserMapper {

	//1. 회원 가입
	public int create(User user);
	//2. 회원 정보 보기
	public User findUser(String userId);
	//3. 전체 회원 정보 보기
	public List<User> findUserList();
	//4. 회원 정보 수정
	public int update(User user);
	//5. 회원 탈퇴
	public int remove(String userId);
	
	//11. 회원 존재 여부 확인
	public int isExistUser(String userId);
	//12. 비밀번호 일치 여부 확인
	public int isMatchPassword(Map<String,Object> map);
	//13. 이메일, 이름으로 아이디 찾기
	public String findIdByEmailName(User user);
	
	//21. 메일 인증여부 확인
	public int mailAuth(String userId);
	//22. 메일 인증번호 업데이트
	public int mailKeyUpdate(User user);
	//23. 메일 인증여부 업데이트
	public int mailAuthUpdate(User user);
	

	
}