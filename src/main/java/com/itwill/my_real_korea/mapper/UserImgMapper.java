package com.itwill.my_real_korea.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.my_real_korea.dto.user.UserImg;

@Mapper
public interface UserImgMapper {
	//1. 회원 이미지 등록
	public int createUserImg(UserImg userImg);
	//2. 회원 이미지 찾기
	public UserImg findUserImg(String userId);
	//3. 회원 이미지 수정
	public int updateUserImg(UserImg userImg);
	//4. 회원 이미지 삭제
	public int removeUserImg(int userImgNo);

}
