package com.itwill.my_real_korea.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.itwill.my_real_korea.dto.City;
import com.itwill.my_real_korea.util.PageMakerDto;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import com.itwill.my_real_korea.dto.freeboard.FreeBoard;
import com.itwill.my_real_korea.dto.freeboard.FreeBoardComment;
import com.itwill.my_real_korea.service.freeboard.FreeBoardService;
import com.itwill.my_real_korea.service.freeboard.FreeBoardCommentService;

@Controller
public class FreeBoardRestController{
    @Autowired
    private FreeBoardService freeBoardService;
    private FreeBoardCommentService freeBoardCommentService;
        //게시판리스트1-조회수많은순
    	@ApiOperation("게시판리스트")
        @GetMapping(value = "/free-board-read-count",produces="application/json;charset=UTF-8")
        public Map<String, Object> freeBoard_list(@RequestParam(required = false, defaultValue = "1")FreeBoard freeBoard, @RequestParam(required = false, defaultValue = "2")int currentPage, @RequestParam Map<String, Object> resultMap) throws Exception{
        resultMap=new HashMap<>();
        int code =1;
        String msg="성공";
	    PageMakerDto<FreeBoard> freeBoardList = null;
	     try {
	    	 //조회수많은순으로 나열
	    	 freeBoardList=(PageMakerDto<FreeBoard>) freeBoardService.selectAllOrderByReadCountDesc(currentPage);
	    	 code=1;
	    	 msg="성공";
	     }catch(Exception e) {
	    	 e.printStackTrace();
	    	 code=2;
	    	 msg="관리자에게 문의하세요.";
	     }
            resultMap.put("freeboardList",freeBoardList);
            resultMap.put("code",code);
            resultMap.put("msg",msg);
        
		return resultMap;
    	}
    	//게시판리스트2-최신순
    	@ApiOperation("게시판리스트")
        @GetMapping(value = "/free-board-date-desc",produces="application/json;charset=UTF-8")
        public Map<String, Object> freeBoard_list_New(@RequestParam(required = false, defaultValue = "0") FreeBoard freeboard, @RequestParam(required = false, defaultValue = "1") int currentPage, @RequestParam Map<String, Object> resultMap) throws Exception{
        resultMap=new HashMap<>();
        int code =1;
        String msg="성공";
        
	     PageMakerDto<FreeBoard> freeBoardList = null;
	     try {
	    	 freeBoardList=(PageMakerDto<FreeBoard>) freeBoardService.selectAllOrderByFBoNoDesc(currentPage);
	    	 code=1;
	    	 msg="성공";
	     }catch(Exception e) {
	    	 e.printStackTrace();
	    	 code=2;
	    	 msg="관리자에게 문의하세요.";
	     }
	     	resultMap.put("freeBoardList",freeBoardList);
	     	resultMap.put("code", code);
	     	resultMap.put("msg", msg);
		return resultMap;
    	}
    	//게시판리스트3-오래된순
    	@ApiOperation("게시판리스트")
        @GetMapping(value = "/free-board-date-asc",produces="application/json;charset=UTF-8")
        public Map<String, Object> freeBoard_list_Old(@RequestParam(required = false, defaultValue = "1") FreeBoard freeboard, @RequestParam(required = false, defaultValue = "2") int currentPage, @RequestParam Map<String, Object> resultMap) throws Exception{
        resultMap=new HashMap<>();
        int code =1;
        String msg="성공";
        
	     PageMakerDto<FreeBoard> freeBoardList = null;
	     try {
	    	 freeBoardList=(PageMakerDto<FreeBoard>) freeBoardService.selectAllOrderByFBoNoAsc(currentPage);
	    	 code=1;
	    	 msg="성공";
	     }catch(Exception e) {
	    	 e.printStackTrace();
	    	 code=2;
	    	 msg="관리자에게 문의하세요.";
	     }
        resultMap.put("code", code);
        resultMap.put("msg", msg);
        resultMap.put("freeBoardList", freeBoardList);
		return resultMap;
    	}
    	//타이틀 키워드로 검색
    	@ApiOperation(value = "게시판 검색")
    	@ApiImplicitParam(name="keyword", value="키워드")
    	@GetMapping(value = "/free-board-keyword-search-{keyword}", produces = "application/json;charset=UTF-8")
    	public Map<String, Object> freeboard_search_list(@RequestParam(required = false, defaultValue = "1") int currentPage, @RequestParam(required = true) String keyword) {
	    	Map<String, Object> resultMap=new HashMap<>();
	    	int code = 1;
	    	String msg = "성공";
	    	PageMakerDto<FreeBoard> freeboardList = null;
	    	//리스트에 리스트가 있을때, 페이지값이 있을 때만 성공
	    	try {
	    		freeboardList = freeBoardService.selectSearchFreeBoardList(currentPage, keyword);
	    		if(freeboardList.getTotRecordCount() != 0 && freeboardList != null) {
	    			code = 1;
	    			msg = "성공";
	    		}else {
	    			//리스트와 페이지값이 없을때 실패
	    			code = 2;
	    			msg = "해당 키워드에 해당하는 게시물이 없습니다.";
	    		}
	    	}catch (Exception e) {
	    		// 에러 발생시 code 3
	    		e.printStackTrace();
	    		code = 3;
	    		msg = "관리자에게 문의하세요.";
			}
	    	resultMap.put("code", code);
	    	resultMap.put("msg", msg);
	    	resultMap.put("freeboardList", freeboardList);
    		return resultMap;
    	}
        //게시판 상세보기
    	@ApiOperation("게시판 상세보기")
        @RequestMapping(value = "/free-board-detail", produces = "application/json;charset=UTF-8")
        public Map<String, Object> freeBoard_detail(@RequestParam int fBoNo,@RequestParam Map<String,Object> resultMap) throws Exception{
            FreeBoard freeBoard = freeBoardService.selectByNo(fBoNo);
            resultMap=new HashMap<>();
            int code = 1;
            String msg = "성공";
            List<FreeBoardComment> freeboardCommentList = new ArrayList<FreeBoardComment>();
            try {
            freeboardCommentList=freeBoardCommentService.selectAll();
            code=1;
            msg="성공";
            }catch(Exception e) {
            	e.printStackTrace();
            	code=2;
            	msg="관리자에게 문의하세요.";
            }
            resultMap.put("freeBoard",freeBoard);
            resultMap.put("freeBoardCommentList",freeboardCommentList);
            resultMap.put("code",code);
            resultMap.put("msg",msg);
			return resultMap;
        }
        //게시판 글쓰기
    	@LoginCheck
    	@ApiOperation("게시판 글쓰기")
        @PostMapping(value = "/free-board-write-form", produces = "application/json;charset=UTF-8")
        public Map<String, Object> free_board_write_form(@RequestBody FreeBoard freeBoard) throws Exception {
            Map<String, Object> resultMap = new HashMap<>();
            int code = 1;
            String msg = "성공";
            List<FreeBoard> freeBoardList = new ArrayList<FreeBoard>();
            try {
            	//성공
            	freeBoardService.insertBoard(freeBoard);
            	code = 1;
            	msg = "성공";
            	freeBoard = freeBoardService.selectByNo(freeBoard.getFBoNo());
            	freeBoardList.add(freeBoard);
            } catch (Exception e) {
            	//실패
            	e.printStackTrace();
            	code = 2;
            	msg = "글쓰기 실패";
            }
            resultMap.put("code", code);
            resultMap.put("msg", msg);
            resultMap.put("freeBoardList", freeBoardList);
            return resultMap;
        }
        //게시판에 등록
//        @PostMapping("/free-board-write-action", produces = "application/json;charset=UTF-8")
//        public Map<String, Object> free_board_write_action(@RequestParam int fBoNo, @RequestParam Map<String,Object> resultMap) throws Exception {
//            resultMap=new HashMap<>();
//            int code = 1;
//            String msg="성공";
//            List<FreeBoard> freeBoardList = new ArrayList<FreeBoard>();
//            try {
//            	code = 1;
//            	msg = "성공";
//            }catch(Exception e) {
//            	e.printStackTrace();
//            	code=2;
//            	msg="error";
//            }
//            resultMap.put("code", code);
//            resultMap.put("msg", msg);
//            resultMap.put("Data", freeBoardList);
//            
//            return resultMap;
//        }
//        //게시판에 등록된 글 수정
//        @LoginCheck
//        @RequestMapping("/free-board-update-form", produces = "application/json;charset=UTF-8")
//        public Map<String, Object> free_board_modify_action(@RequestParam Integer pageStart, Integer pageEnd, @RequestParam Integer fBoNo, @RequestBody FreeBoard freeBoard) throws Exception{
//            Map<String, Object> resultMap=new HashMap<>();
//            int code = 1;
//            String msg = "성공";
//            List<FreeBoard> freeBoardList = new ArrayList<FreeBoard>();
//            try {
//            	FreeBoard findFreeBoard = freeBoardService.selectByNo(fBoNo);
//            	if(findFreeBoard!=null) {
//            		freeBoard.setFBoNo(fBoNo);
//            		freeBoardService.updateFreeBoard(freeBoard);
//            		code = 1;
//            		msg = "성공";
//            		freeBoardList.add(freeBoard);
//            	}else {
//            		code = 2;
//            		msg = "수정 실패";
//            	}
//            }catch(Exception e) {
//            	e.printStackTrace();
//            	code = 3;
//            	msg = "관리자에게 문의하세요.";
//            }
//            resultMap.put("code", code);
//            resultMap.put("msg", msg);
//            resultMap.put("Data", freeBoardList);
//            return resultMap;
//        }

        //게시물 삭제
        @LoginCheck
        @ApiOperation(value = "보드 게시물 삭제")
        @ApiImplicitParam(name="fBoNo", value = "게시물 번호")
        @DeleteMapping(value = "/free-board-list/{fBoNo}", produces = "application/json;charset=UTF-8")
        public Map<String,Object> free_board_delete_action(@PathVariable("fBoNo") int fBoNo){
            Map<String,Object> resultMap = new HashMap<>();
            int code = 1;
            String msg = "성공";
            List<FreeBoard> freeBoardList = new ArrayList<FreeBoard>();
            try {
            	int rowCount = freeBoardService.deleteFreeBoard(fBoNo);
            	if(rowCount!=0) { 
            		code =1;
            		msg = "성공";
            	}else {
            			code = 2;
            			msg = "보드 게시물 삭제 실패";
            			FreeBoard failFreeBoard = freeBoardService.selectByNo(fBoNo);
            			freeBoardList.add(failFreeBoard);
            		}
            }catch(Exception e) {
            	e.printStackTrace();
            	code = 3;
            	msg = "관리자에게 문의바랍니다.";
            }
            resultMap.put("code", code);
            resultMap.put("msg", msg);
            resultMap.put("freeBoardList", freeBoardList);
        	return resultMap;
        }
}









