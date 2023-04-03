package com.itwill.my_real_korea.dao.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.my_real_korea.dto.user.UserAddInfo;
import com.itwill.my_real_korea.mapper.UserAddInfoMapper;
@Repository
public class UserAddInfoDaoImpl implements UserAddInfoDao {
	
	@Autowired
	private UserAddInfoMapper userAddInfoMapper;

	public UserAddInfoDaoImpl() {
	}
	
	//1. 회원 추가 정보 등록
	@Override
	public int createUserAddInfo(UserAddInfo userAddInfo) throws Exception {
		return userAddInfoMapper.createUserAddInfo(userAddInfo);
	}

	//2. 회원 추가 정보 보기
	@Override
	public UserAddInfo findUserAddInfo(String userId) throws Exception {
		return userAddInfoMapper.findUserAddInfo(userId);
	}

	//3. 회원 추가 정보 수정
	@Override
	public int updateUserAddInfo(UserAddInfo userAddInfo) throws Exception {
		return userAddInfoMapper.updateUserAddInfo(userAddInfo);
	}

	//4. 회원 추가 정보 삭제
	@Override
	public int removeUserAddInfo(String userId) throws Exception {
		return userAddInfoMapper.removeUserAddInfo(userId);
	}


}