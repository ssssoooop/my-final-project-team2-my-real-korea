package com.itwill.my_real_korea.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.my_real_korea.dto.notice.Notice;
import com.itwill.my_real_korea.service.notice.NoticeService;
import com.itwill.my_real_korea.util.PageMakerDto;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;


@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	// 공지사항 리스트 보기 (공지사항 첫 화면)
	@GetMapping(value = "/notice")
	public String notice_list(@RequestParam(required = false, defaultValue = "1") int pageNo,
								Model model) {
		
		try {
			PageMakerDto<Notice> noticeList = noticeService.selectAll(pageNo);
			model.addAttribute("noticeList", noticeList);
			model.addAttribute("pageNo", pageNo);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "notice";
	}
	
	// 공지사항 작성 폼
	@AdminCheck 
	@LoginCheck
	@GetMapping("/notice-write-form")
	public String notice_write_form(HttpServletRequest request) {
		/*
		 * Referer : HTTP 요청 헤더의 일종으로, 
		 * 			요청 보낸 페이지의 URL 의미
		 */
		String requestUrl = request.getHeader("Referer");
		// session 에 요청 보낸 페이지의 URL 저장(관리자 아닐 경우 이전 페이지로 돌려보내기 위해)
		request.getSession().setAttribute("requestUrl", requestUrl);
		
		return "notice_write_form";
	}
	
	// 공지사항 수정 폼
	@AdminCheck 
	@LoginCheck
	@GetMapping("/notice-modify-form")
	public String notice_modify_form(HttpServletRequest request) {
		/*
		 * Referer : HTTP 요청 헤더의 일종으로, 
		 * 			요청 보낸 페이지의 URL 의미
		 */
		String requestUrl = request.getHeader("Referer");
		// session 에 요청 보낸 페이지의 URL 저장(관리자 아닐 경우 이전 페이지로 돌려보내기 위해)
		request.getSession().setAttribute("requestUrl", requestUrl);
		
		return "notice_modify_form";
	}
	
}
