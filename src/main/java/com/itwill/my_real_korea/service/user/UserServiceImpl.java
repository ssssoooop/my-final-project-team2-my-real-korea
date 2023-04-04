package com.itwill.my_real_korea.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.my_real_korea.dao.user.UserDao;
import com.itwill.my_real_korea.dto.user.User;
import com.itwill.my_real_korea.exception.ExistedUserException;
import com.itwill.my_real_korea.exception.PasswordMismatchException;
import com.itwill.my_real_korea.exception.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	@Autowired
	public EmailService emailService;
	
	public UserServiceImpl() throws Exception {
		
	}
	
	//1. 회원 가입
	@Override
	public int create(User user)throws ExistedUserException, Exception {
		//아이디 중복 체크
		if(userDao.isExistUser(user.getUserId())) {
			throw new ExistedUserException(user.getUserId() + " 는 이미 존재하는아이디입니다.");
		}
		//회원가입
		userDao.create(user);
		//mail_key 업데이트
		userDao.mailKeyUpdate(user);
		return 1;
	}
	
	//2. 회원 정보 보기 (마이 페이지)
	@Override
	public User findUser(String userId) throws Exception{
		return userDao.findUser(userId);
	}
	
	//3. 전체 회원 정보 보기 (관리자 페이지)
	@Override
	public List<User> findUserList()throws Exception{
		return userDao.findUserList();
	}
	
	//4. 회원 정보 수정
	@Override
	public int update(User user)throws Exception{
		return userDao.update(user);
	}
	
	//5. 회원 탈퇴
	@Override
	public int remove(String userId) throws Exception{
		return userDao.remove(userId);
	}
	
	
	//11. 아이디 중복 체크 (회원 가입(회원 존재 여부 확인))
	@Override
	public boolean isDuplicateId(String userId) throws Exception{
		boolean isExist = userDao.isExistUser(userId);
		if(isExist) {
			return true;
		}else {
			return false;
		}
	}
	
	//12. 로그인 (비밀번호 일치 여부 확인)
	//1: 로그인 성공
	@Override
	public User login(String userId, String password) throws Exception, UserNotFoundException, PasswordMismatchException {
	    User user = userDao.findUser(userId);
	    if (user == null) {
	        throw new UserNotFoundException(userId + " 는 존재하지 않는 아이디입니다.");
	    }
	    boolean isMatchPassword = userDao.isMatchPassword(userId,password);
	    if (!isMatchPassword) {
	        throw new PasswordMismatchException("패스워드가 일치하지 않습니다.");
	    }
	    return user;
	}
	
	//13. 이메일, 이름으로 아이디 찾기
	@Override
	public String findIdByEmailName(User user) throws Exception {
		return userDao.findIdByEmailName(user);
	}
	
	
	//21. 메일 인증여부 확인
	public int mailAuth(String userId) throws Exception {
		return userDao.mailAuth(userId);
	}
	
	//22. 메일 인증번호 업데이트
    public int mailKeyUpdate(User user) throws Exception {
        // 이메일 전송 및 인증번호 저장
        String authNum = emailService.sendEmail(user.getEmail());
        user.setMailKey(Integer.parseInt(authNum));
        return userDao.mailKeyUpdate(user);
    }
	
	//23. 메일 인증여부 업데이트
	public int mailAuthUpdate(User user) throws Exception {
		return userDao.mailAuthUpdate(user);
	}
	
}















