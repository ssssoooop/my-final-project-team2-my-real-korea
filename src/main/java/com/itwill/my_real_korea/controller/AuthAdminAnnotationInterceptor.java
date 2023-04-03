package com.itwill.my_real_korea.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.itwill.my_real_korea.exception.IsNotAdminException;
import com.itwill.my_real_korea.service.user.UserService;

import ch.qos.logback.core.joran.conditional.IfAction;

public class AuthAdminAnnotationInterceptor implements HandlerInterceptor {
	public AuthAdminAnnotationInterceptor() {
	}

	@Override
	public boolean preHandle(	HttpServletRequest request, 
								HttpServletResponse response, 
								Object handler) throws Exception {
		
		// HandlerMethod : @Controller 객체에 @RequestMapping이 붙은 메소드
		if (handler instanceof HandlerMethod == false) {
			return true;
		}
		
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		
		// HandlerMethod 객체에 @AdminCheck 이 없는 경우, 인증이 필요 없는 요청
		AdminCheck adminCheck = handlerMethod.getMethodAnnotation(AdminCheck.class);
		if (adminCheck == null) {
			return true;
		}
		
		// HandlerMethod 객체에 @AdminCheck 이 있는 경우, 세션이 있는지 체크
		HttpSession session = request.getSession();
		String sUserId = (String) session.getAttribute("sUserId");
		
		// sUserId 가 admin 이 아닌 경우 예외처리
		if (!sUserId.equals("admin")) {
			 request.setAttribute("message", "관리자만 가능합니다.");
             request.setAttribute("exception", "IsNotAdminException");
             request.getRequestDispatcher("/admin").forward(request, response);
             System.out.println("@AdminCheck 예외처리");
             return false;
		}

		// true : 컨트롤러의 uri로 이동
		return true;
	}

}
	



