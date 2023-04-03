package com.itwill.my_real_korea.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.my_real_korea.dto.user.UserAddInfo;

@Mapper
public interface UserAddInfoMapper {

	//1. 회원 추가 정보 등록
	public int createUserAddInfo(UserAddInfo userAddInfo);
	//2. 회원 추가 정보 보기
	public UserAddInfo findUserAddInfo(String userId);
	//3. 회원 추가 정보 수정
	public int updateUserAddInfo(UserAddInfo userAddInfo);
	//4. 회원 추가 정보 삭제
	public int removeUserAddInfo(String userId);
	
	
	
}
