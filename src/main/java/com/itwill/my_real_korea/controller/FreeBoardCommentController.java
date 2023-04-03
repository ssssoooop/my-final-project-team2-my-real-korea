package com.itwill.my_real_korea.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.my_real_korea.dto.City;
import com.itwill.my_real_korea.dto.freeboard.FreeBoard;
import com.itwill.my_real_korea.dto.freeboard.FreeBoardComment;
import com.itwill.my_real_korea.service.freeboard.FreeBoardCommentService;
import com.itwill.my_real_korea.service.user.UserService;

@Controller
public class FreeBoardCommentController{
@Autowired
private FreeBoardCommentService freeBoardCommentService;
//댓글 리스트보기
@RequestMapping(value = "/free-board-comment-list")
public String free_board_comment_list(@RequestParam Model model, HttpSession session) throws Exception{
	String sUserId=(String)session.getAttribute("sUserId");
	City sCity=(City)session.getAttribute("sCity");
	System.out.println("free-board-comment-list: sCity"+sCity);
	List<FreeBoardComment> freeBoardCommentList=freeBoardCommentService.selectAll();
	model.addAttribute("freeBoardCommentList"+freeBoardCommentList);
	return sUserId;
}
//답변 달기
@GetMapping(value = "free-board-comment-write-form")
public String free_board_comment_write_form(HttpSession session) throws Exception {
	String sUserId = (String)session.getAttribute("sUserId");
        String forward_path = "";
        if(sUserId==null) {
        	forward_path="user-login-form";
        }
        	if(sUserId!=null) {
        		forward_path="free-board-comment-write";
        	}
        	return forward_path;    
		}

//답변 게시
@RequestMapping(value = "/free-board-comment-write-action")
public String free_board_write_action(@RequestParam Map<String, Object> map, Model model, HttpSession session) throws Exception {
        String sUserId = (String)session.getAttribute("sUserId");
        String forwardPath = "";
      //비회원은 로그인화면으로
        if(sUserId == null) {
        forwardPath = "user-login-form";
        }
        //회원은 게시판리스트로
        if(sUserId != null) {
        City sCity=(City)session.getAttribute("sCity");
        forwardPath = "free-board-comment-list";
        }
        return forwardPath;
    }
////댓글 수정
//@RequestMapping("/free-board-comment-update-form")
//public String free_board_comment_update_form( @RequestParam Integer fCommentNo, Model model,HttpSession session) throws Exception{
//    String sUserId = (String)session.getAttribute("sUserId");
//    String userId = (String)session.getAttribute("userId");
//    String forwardPath = "";
//    //비회원은 로그인화면으로
//    if(sUserId == null) {
//    forwardPath = "user-login-form";
//    }
//    //비회원은 로그인화면으로
//    if(sUserId == userId) {
//        FreeBoardComment freeBoardComment = (FreeBoardComment) freeBoardCommentService.selectAll();
//        model.addAttribute("freeBoardComment",freeBoardComment);
//        forwardPath = "free-board-comment-update";
//    }
//    return forwardPath;
//}
//수정 후 게시
@RequestMapping("/free-board-update-action")
	public String free_board_comment_update_action(@ModelAttribute FreeBoardComment freeBoardComment, HttpSession session) throws Exception{
   	return "redirect:free-board-comment-list";
}
//댓글 삭제
@RequestMapping("/free-board-comment-delete-action")
	public String free_board_comment_delete_action(@ModelAttribute FreeBoardComment freeBoardComment, HttpSession session) throws Exception{
    	return "redirect:free-board-comment-list";
}
	
}
