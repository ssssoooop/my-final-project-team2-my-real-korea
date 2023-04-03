package com.itwill.my_real_korea.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.itwill.my_real_korea.service.user.UserService;

public class AuthLoginAnnotationInterceptor implements HandlerInterceptor {
	public AuthLoginAnnotationInterceptor() {
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
		
		// HandlerMethod 객체에 @LoginCheck 이 없는 경우, 인증이 필요 없는 요청
		LoginCheck loginCheck = handlerMethod.getMethodAnnotation(LoginCheck.class);
		if (loginCheck == null) {
			return true;
		}
		
		// HandlerMethod 객체에 @LoginCheck 이 있는 경우, 세션이 있는지 체크
		HttpSession session = request.getSession();
		String sUserId = (String) session.getAttribute("sUserId");
		if (sUserId == null) {
			// 로그인이 안되어 있는 상태, 로그인 폼으로 다시 돌려보냄
		    String requestUrl = request.getRequestURL().toString();
		    session.setAttribute("requestUrl", requestUrl);
		    response.sendRedirect("user_login_form");
		    return false;
		} else {
		    String requestUrl = (String) session.getAttribute("requestUrl");
		    if (requestUrl != null) {
		        session.removeAttribute("requestUrl");
		        response.sendRedirect(requestUrl);
		        return false;
		    }
		}

		return true;
	}

   
}
	



