package com.itwill.my_real_korea.service.user;

import com.itwill.my_real_korea.dto.user.UserImg;

public interface UserImgService {
	
	//1. 회원 이미지 등록
	int createUserImg(UserImg userImg) throws Exception;
	//2. 회원 이미지 찾기
	UserImg findUserImg(String userId) throws Exception;
	//3. 회원 이미지 수정
	int updateUserImg(UserImg userImg) throws Exception;
	//4. 회원 이미지 삭제
	int removeUserImg(int userImgNo) throws Exception;
	

}
