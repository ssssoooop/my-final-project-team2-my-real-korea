package com.itwill.my_real_korea.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.my_real_korea.dao.user.UserAddInfoDao;
import com.itwill.my_real_korea.dto.user.UserAddInfo;

@Service
public class UserAddInfoServiceImpl implements UserAddInfoService {
	
	@Autowired
	private UserAddInfoDao userAddInfoDao;
	
	public UserAddInfoServiceImpl() throws Exception {
	}
	
	//1. 회원 추가 정보 등록
	@Override
	public int createUserAddInfo(UserAddInfo userAddInfo) throws Exception {
		return userAddInfoDao.createUserAddInfo(userAddInfo);
	}
	
	//2. 회원 추가 정보 보기
	@Override
	public UserAddInfo findUserAddInfo(String userId) throws Exception {
		return userAddInfoDao.findUserAddInfo(userId);
	}
	
	//3. 회원 추가 정보 수정
	@Override
	public int updateUserAddInfo(UserAddInfo userAddInfo) throws Exception {
		return userAddInfoDao.updateUserAddInfo(userAddInfo);
	}
	
	//4. 회원 추가 정보 삭제
	@Override
	public int removeUserAddInfo(String userId) throws Exception {
		return userAddInfoDao.removeUserAddInfo(userId);
	}
	

	
}

