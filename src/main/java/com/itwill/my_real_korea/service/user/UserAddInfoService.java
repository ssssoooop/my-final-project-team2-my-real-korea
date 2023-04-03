package com.itwill.my_real_korea.service.user;

import com.itwill.my_real_korea.dto.user.UserAddInfo;

public interface UserAddInfoService {

	//1. 회원 추가 정보 등록
	int createUserAddInfo(UserAddInfo userAddInfo) throws Exception;
	//2. 회원 추가 정보 보기
	UserAddInfo findUserAddInfo(String userId) throws Exception;
	//3. 회원 추가 정보 수정
	int updateUserAddInfo(UserAddInfo userAddInfo) throws Exception;
	//4. 회원 추가 정보 삭제
	int removeUserAddInfo(String userId) throws Exception;
	
}