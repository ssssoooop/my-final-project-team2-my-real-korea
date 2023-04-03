package com.itwill.my_real_korea.dao.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.my_real_korea.dto.user.UserImg;
import com.itwill.my_real_korea.mapper.UserImgMapper;
@Repository
public class UserImgDaoImpl implements UserImgDao {
	
	@Autowired
	private UserImgMapper userImgMapper;
	
	public UserImgDaoImpl() {
	}
	
	//1. 회원 이미지 등록
	@Override
	public int createUserImg(UserImg userImg) {
		return userImgMapper.createUserImg(userImg);
	}
	
	//2. 회원 이미지 찾기
	@Override
	public UserImg findUserImg(String userId) {
		return userImgMapper.findUserImg(userId);
	}
	
	//3. 회원 이미지 수정
	@Override
	public int updateUserImg(UserImg userImg) {
		return userImgMapper.updateUserImg(userImg);
	}
	
	//4. 회원 이미지 삭제
	@Override
	public int removeUserImg(int userImgNo) {
		return userImgMapper.removeUserImg(userImgNo);
	}
	

}
