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
        //게시판리스트
//        @RequestMapping(value = "/free-board-list")
//        public String freeBoard_list(@RequestParam City city, Model model, @RequestParam int pageStart, int pageEnd, HttpSession session) throws Exception{
//        String sUserId = (String)session.getAttribute("sUserId");
//        City sCity=(City)session.getAttribute("sCity");
//        System.out.println("freeBord_list: sCity"+sCity);
//            PageMakerDto<FreeBoard> freeBoardList = (PageMakerDto<FreeBoard>) freeBoardService.selectAll(pageStart,pageEnd);
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
        //게시판 글쓰기
        @GetMapping(value = "/free-board-write-form")
        public String free_board_write_form(HttpSession session) throws Exception {
            String sUserId = (String)session.getAttribute("sUserId");
            String forwardPath="";
                //비회원은 로그인화면으로
                if(sUserId == null) {
                    forwardPath = "user-login-form";
                }
                //회원은 쓰기 폼으로
                if(sUserId != null) {
                    forwardPath = "free-board-write";
                }
                return forwardPath;
        }
        //게시판에 등록
        @PostMapping("/free-board-write-action")
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









