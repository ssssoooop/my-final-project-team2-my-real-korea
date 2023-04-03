package com.itwill.my_real_korea.dao.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.my_real_korea.dto.user.User;
import com.itwill.my_real_korea.mapper.UserMapper;
@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private UserMapper userMapper;

	public UserDaoImpl() {
	}
	
	//1. 회원 가입
	@Override
	public int create(User user) throws Exception {
		return userMapper.create(user);
	}

	//2. 회원 정보 보기 (마이페이지)
	@Override
	public User findUser(String userId) throws Exception {
		return userMapper.findUser(userId);
	}

	//3. 전체 회원 정보 보기 (관리자 페이지)
	@Override
	public List<User> findUserList() throws Exception {
		return userMapper.findUserList();
	}
	
	//4. 회원 정보 수정
	@Override
	public int update(User user) throws Exception {
		return userMapper.update(user);
	}

	//5. 회원 탈퇴
	@Override
	public int remove(String userId) throws Exception {
		return userMapper.remove(userId);
	}

	//11. 회원 존재 여부 확인
	@Override
	public boolean isExistUser(String userId) throws Exception {
		boolean isExist = false;
		int existCount = userMapper.isExistUser(userId);
		if(existCount == 1) {
			isExist = true;
		}
		return isExist;
	}
	
	//12. 비밀번호 일치 여부 확인
	@Override
	public boolean isMatchPassword(String userId, String password){
		Map<String,Object> map = new HashMap();
		map.put("userId", userId);
		map.put("password", password);
		int matchPassword = userMapper.isMatchPassword(map);
		//패스워드 일치함 => 로그인
		if(matchPassword == 1){
			return true;
		}
		//패스워드 일치 안함
		return false;
	}
	
	//13. 이메일, 이름으로 아이디 찾기
	@Override
	public String findIdByEmailName(User user) throws Exception {
		return userMapper.findIdByEmailName(user);
	}

	
	//21. 메일 인증여부 확인
	public int mailAuth(String userId) throws Exception {
		return userMapper.mailAuth(userId);
	}
	
	//22. 메일 인증번호 업데이트
	public int mailKeyUpdate(User user) throws Exception {
		return userMapper.mailKeyUpdate(user);
	}
	
	//23. 메일 인증여부 업데이트
	public int mailAuthUpdate(User user) throws Exception {
		return userMapper.mailAuthUpdate(user);
		
	}

}