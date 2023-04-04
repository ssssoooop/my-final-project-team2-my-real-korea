package com.itwill.my_real_korea.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import io.swagger.annotations.ApiOperation;

import com.itwill.my_real_korea.dto.freeboard.FreeBoard;
import com.itwill.my_real_korea.dto.freeboard.FreeBoardComment;
import com.itwill.my_real_korea.service.freeboard.FreeBoardService;
import com.itwill.my_real_korea.service.freeboard.FreeBoardCommentService;

@Controller
public class FreeBoardController{
    @Autowired
    private FreeBoardService freeBoardService;
    private FreeBoardCommentService freeBoardCommentService;
        //게시판리스트1-조회수많은순
    	@ApiOperation("게시판리스트")
        @GetMapping(value = "/free-board-read-count")
        public Map<String, Object> freeBoard_list(@RequestParam(required = false, defaultValue = "0") int cityNo, @RequestParam(required = false, defaultValue = "1") int currentPage, Model model, HttpSession session, @RequestParam Map<String, Object> resultMap) throws Exception{
        String sUserId = (String)session.getAttribute("sUserId");
        int sCityNo=(Integer)session.getAttribute("sCityNo");
        resultMap=new HashMap<>();
        int code =1;
        String msg="성공";
        System.out.println("sCityNo:"+sCityNo);
        
		//지역있는 질문 리스트일때
	     if(sCityNo !=0) {
            resultMap.put("userId", sUserId);
		  	resultMap.put("city",sCityNo);
	     }else {}
	     PageMakerDto<FreeBoard> fList = null;
	     try {
	    	 //조회수많은순으로 나열
	    	 fList=(PageMakerDto<FreeBoard>) freeBoardService.selectAllOrderByReadCountDesc(currentPage);
	    	 code=1;
	    	 msg="성공";
	     }catch(Exception e) {
	    	 e.printStackTrace();
	    	 code=2;
	    	 msg="관리자에 문의하세요.";
	     }
            model.addAttribute("freeboardList",fList);
            model.addAttribute("currentPage",currentPage);
        
		return resultMap;
    	}
    	//게시판리스트2-최신순
    	@ApiOperation("게시판리스트")
        @GetMapping(value = "/free-board-date-asc")
        public Map<String, Object> freeBoard_list_New(@RequestParam(required = false, defaultValue = "0") int cityNo, @RequestParam(required = false, defaultValue = "1") int currentPage, Model model, HttpSession session, @RequestParam Map<String, Object> resultMap) throws Exception{
        String sUserId = (String)session.getAttribute("sUserId");
        int sCityNo=(Integer)session.getAttribute("sCityNo");
        resultMap=new HashMap<>();
        int code =1;
        String msg="성공";
        System.out.println("sCityNo:"+sCityNo);
        
		//지역있는 질문 리스트일때
	     if(sCityNo !=0) {
            resultMap.put("userId", sUserId);
		  	resultMap.put("city",sCityNo);
	     }else {}
	     PageMakerDto<FreeBoard> fList = null;
	     try {
	    	 //조회수많은순으로 나열
	    	 fList=(PageMakerDto<FreeBoard>) freeBoardService.selectAllOrderByReadCountDesc(currentPage);
	    	 code=1;
	    	 msg="성공";
	     }catch(Exception e) {
	    	 e.printStackTrace();
	    	 code=2;
	    	 msg="관리자에 문의하세요.";
	     }
            model.addAttribute("freeboardList",fList);
            model.addAttribute("currentPage",currentPage);
        
		return resultMap;
    	}
        //게시판 상세보기
    	@ApiOperation("게시판 상세보기")
        @RequestMapping(value = "/free-board-view")
        public String freeBoard_view(@RequestParam int fBoNo,@RequestParam int pageStart, int pageEnd,Model model, HttpSession session, @ModelAttribute FreeBoardComment freeBoardComment) throws Exception{
            String sUserId = (String)session.getAttribute("sUserId");
            session.getAttribute("sCityNo");
            
            FreeBoard freeBoard = freeBoardService.selectByNo(fBoNo);
            int code = 1;
            String msg = "성공";
            model.addAttribute("freeBoard",freeBoard);
            model.addAttribute("pageStart",pageStart);
            model.addAttribute("pageEnd",pageEnd);
            List<FreeBoardComment> freeboardCommentList = new ArrayList<>();
            try {
            freeboardCommentList=freeBoardCommentService.selectAll();
            code=1;
            msg="성공";
            }catch(Exception e) {
            	e.printStackTrace();
            	code=2;
            	msg="관리자에 문의하세요.";
            }
            model.addAttribute("freeBoardCommentList", freeboardCommentList);
            System.out.println("freeBoardCommentList"+freeboardCommentList);
			return sUserId;
        }
        //게시판 글쓰기
    	@ApiOperation("게시판 글쓰기")
        @GetMapping(value = "/free-board-write-form")
        public String free_board_write_form(HttpSession session) throws Exception {
            String sUserId = (String)session.getAttribute("sUserId");
            String forwardPath="";
            String msg="로그인하세요.";
                //비회원은 로그인화면으로
                if(sUserId == null) {
                	msg="로그인하세요.";
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
            session.getAttribute("sCity");
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









