package com.itwill.my_real_korea.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.itwill.my_real_korea.dto.City;
import com.itwill.my_real_korea.util.PageMakerDto;
import com.itwill.my_real_korea.dto.freeboard.FreeBoard;
import com.itwill.my_real_korea.dto.freeboard.FreeBoardComment;
import com.itwill.my_real_korea.service.freeboard.FreeBoardService;
import com.itwill.my_real_korea.service.freeboard.FreeBoardCommentService;

@Controller
public class FreeBoardController{
    @Autowired
    private FreeBoardService freeBoardService;
    private FreeBoardCommentService freeBoardCommentService;
        //게시판리스트(rest)
//        @RequestMapping(value = "/free-board-list-rest")
//        public Map<String, Object> freeBoard_list_rest(@RequestParam City city, Model model, @RequestParam int pageStart, int pageEnd, HttpSession session) throws Exception{
//        Map<String,Object> resultMap = new HashMap<>();
//        PageMakerDto<FreeBoard> freeBoardList = (PageMakerDto<FreeBoard>) 
//	    String sUserId = (String)session.getAttribute("sUserId");
//        City sCity=(City)session.getAttribute("sCity");
//        System.out.println("freeBord_list_rest 컨트롤러 map:"+resultMap);
//	    freeBoardService.selectAll(pageStart,pageEnd);
//            model.addAttribute("freeboardList",freeBoardList);
//            model.addAttribute("pageStart",pageStart);
//            model.addAttribute("pageEnd",pageEnd);
//			return sUserId;
//        }
        //게시판 상세보기
        @RequestMapping(value = "/free-board-view")
        public String freeBoard_view(@RequestParam int fBoNo,@RequestParam int pageStart, int pageEnd,Model model, HttpSession session, @ModelAttribute FreeBoardComment freeBoardComment ) throws Exception{
            String forwardPath = "";
            String sUserId = (String)session.getAttribute("sUserId");
            City sCity = (City)session.getAttribute("sCity");
            FreeBoard freeBoard = freeBoardService.selectByNo(fBoNo);
            model.addAttribute("freeBoard",freeBoard);
            model.addAttribute("pageStart",pageStart);
            model.addAttribute("pageEnd",pageEnd);
            List<FreeBoardComment> freeBoardCommentList = freeBoardCommentService.selectAll();
            model.addAttribute("freeBoardCommentList", freeBoardCommentList);
            System.out.println("freeBoardCommentList"+freeBoardCommentList);
			return sUserId;
        }
       
        //게시판에 등록
        @PostMapping("/free-board-write-action-json")
        public String free_board_write_action(@RequestParam Model model,HttpSession session, @ModelAttribute FreeBoard freeBoard) throws Exception {
            String sUserId=(String)session.getAttribute("sUserId");
            String forwardPath = "";
            //비회원은 로그인화면으로
            if(sUserId == null) {
            forwardPath = "user-login-form";
            }
            //회원은 게시판리스트로
            if(sUserId != null) {
            City sCity=(City)session.getAttribute("sCity");
            forwardPath = "free-board-list";
            }
            return forwardPath;
        }
        //게시판에 등록된 글 수정
        @RequestMapping("/free-board-update-form")
        public String free_board_update_form(@RequestParam Integer pageStart, Integer pageEnd, @RequestParam Integer fBoNo, Model model,HttpSession session) throws Exception{
            String sUserId = (String)session.getAttribute("sUserId");
            String userId = (String)session.getAttribute("userId");
            
            String forwardPath = "";
            //비회원은 로그인화면으로
            if(sUserId == null) {
            forwardPath = "user-login-form";
            }
            //회원
            if(sUserId == userId) {
                FreeBoard freeBoard = freeBoardService.selectByNo(fBoNo);
                model.addAttribute("freeBoard",freeBoard);
                forwardPath = "free-board-update";
            }
            return forwardPath;
        }
        //수정 후 게시
//        @RequestMapping("/free-board-update-action")
//        public String free_board_update_action(@ModelAttribute FreeBoard freeBoard, HttpSession session) throws Exception{
//            return "redirect:free-board-list";
//        }
        //게시물 삭제
        @RequestMapping("/free-board-delete-action")
        public String free_board_delete_action(@ModelAttribute FreeBoard freeBoard, HttpSession session) throws Exception{
            return "redirect:free-board-list";
        }
}









