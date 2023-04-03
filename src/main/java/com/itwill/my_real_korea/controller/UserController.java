package com.itwill.my_real_korea.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.my_real_korea.dto.user.User;
import com.itwill.my_real_korea.exception.ExistedUserException;
import com.itwill.my_real_korea.exception.PasswordMismatchException;
import com.itwill.my_real_korea.exception.UserNotFoundException;
import com.itwill.my_real_korea.service.user.UserService;

import io.swagger.annotations.ApiOperation;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@ApiOperation(value = "메인페이지")
	@RequestMapping(value = "/user_main", produces = "application/json;charset=UTF-8")
	public String user_main() {
		return "user_main";
	}
	
	@ApiOperation(value = "회원가입 폼")
	@GetMapping(value = "/user_write_form", produces = "application/json;charset=UTF-8")
	public String user_write_form() {
		String forward_path = "user_write_form";
		return forward_path;
	}
	
	@ApiOperation(value = "회원가입 액션")
	@PostMapping(value = "user_write_action", produces = "application/json;charset=UTF-8")
	public String user_write_action(@ModelAttribute("fuser") User user,Model model) throws Exception {
		String forward_path = "";
		try {
			userService.create(user);
			userService.mailKeyUpdate(user);
			forward_path="redirect:user_login_form";
		}catch (ExistedUserException e) {
			model.addAttribute("msg", e.getMessage());
			forward_path="user_write_form";
		}
		return forward_path;
	}
	
	@ApiOperation(value = "로그인 폼")
	@GetMapping(value = "/user_login_form", produces = "application/json;charset=UTF-8")
	public String user_login_form() {
		String forward_path = "user_login_form";
		return forward_path;
	}
	
	@ApiOperation(value = "로그인 액션")
	@PostMapping(value = "user_login_action", produces = "application/json;charset=UTF-8")
	public String user_login_action(@ModelAttribute("fuser") User user,Model model,HttpSession session) throws Exception {
		String forwardPath = "";
		try {
			userService.login(user.getUserId(), user.getPassword());
			session.setAttribute("sUserId", user.getUserId());
			forwardPath="redirect:user_main";
		}catch (UserNotFoundException e) {
			e.printStackTrace();
			model.addAttribute("msg1",e.getMessage());
			forwardPath="user_login_form";
		}catch (PasswordMismatchException e) {
			e.printStackTrace();
			model.addAttribute("msg2",e.getMessage());
			forwardPath="user_login_form";
		}
		return forwardPath;
	}
	
	@GetMapping(value = "/user_auth_form")
	public String user_auth_form() {
		String forward_path = "usr_auth_form";
		return forward_path;
		
	}
	
	
	@LoginCheck
	@ApiOperation(value = "회원 정보 보기")
	@GetMapping(value = "/user_view", produces = "application/json;charset=UTF-8")
	public String user_view(HttpServletRequest request) throws Exception {
	    String forwardPath = "";
	    HttpSession session = request.getSession();
	    String sUserId = (String) session.getAttribute("sUserId");
	    if (sUserId == null) {
	        session.setAttribute("requestUrl", request.getRequestURL().toString());
	        return "redirect:user_login_form";
	    }
	    User loginUser = userService.findUser(sUserId);
	    request.setAttribute("loginUser", loginUser);
	    forwardPath = "user_view";
	    
	    return forwardPath;
	}
	
	
	@LoginCheck
	@PostMapping("/user_modify_form")
	public String user_modify_form(HttpServletRequest request) throws Exception {
		String forwardPath = "";
		String sUserId=(String)request.getSession().getAttribute("sUserId");
		User loginUser=userService.findUser(sUserId);
		request.setAttribute("loginUser", loginUser);
		forwardPath="user_modify_form";
		
		return forwardPath;
	}
	
	
	@LoginCheck
	@PostMapping("user_modify_action")
	public String user_modify_action(@ModelAttribute User user,HttpServletRequest request) throws Exception {
		String forwardPath = "";
		userService.update(user);
		forwardPath="redirect:user_view";
		
		return forwardPath;
	}
	
	
	@LoginCheck
	@PostMapping("user_remove_action")
	public String user_remove_action(HttpServletRequest request) throws Exception {
		String forwardPath = "";
		String sUserId=(String)request.getSession().getAttribute("sUserId");
		userService.remove(sUserId);
		request.getSession().invalidate();
		//forwardPath="forward:user_logout_action";
		forwardPath="redirect:user_main";
		
		return forwardPath;
	}
	
	
	@LoginCheck
	@RequestMapping("user_logout_action")
	public String user_logout_action(HttpServletRequest request) {
		String forwardPath = "";
		request.getSession(false).invalidate();
		forwardPath="redirect:user_main";
		return forwardPath;
	}
	
	
	/***********GET방식요청시 guest_main redirection*********/
	@GetMapping({
				"user_write_action",
				"user_login_action",
				"user_modify_form",
				"user_modify_action",
				"user_remove_action"
				})
	public String user_get() {
		String forwardPath = "redirect:user_main";
		return forwardPath;
	}
	
	
	/****************Local Exception Handler***********/
	@ExceptionHandler(Exception.class)
	public String user_exception_handler(Exception e) {
		return "user_error";
	}

}





