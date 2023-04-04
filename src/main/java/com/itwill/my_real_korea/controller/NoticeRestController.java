package com.itwill.my_real_korea.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.my_real_korea.dto.notice.Notice;
import com.itwill.my_real_korea.exception.IsNotAdminException;
import com.itwill.my_real_korea.service.notice.NoticeService;
import com.itwill.my_real_korea.util.PageMaker;
import com.itwill.my_real_korea.util.PageMakerDto;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
public class NoticeRestController {

	@Autowired
	private NoticeService noticeService;
	
	/*
	 * 최신순 정렬 : 공지사항 리스트 보기 (게시글 시작번호, 게시글 끝번호) - 페이징 처리
	 */
	@ApiOperation(value = "공지사항 리스트 최신순")
	@GetMapping(value = "/notice-date-desc", produces = "application/json;charset=UTF-8")
	public Map<String, Object> notice_list_date_desc(@RequestParam(required = false, defaultValue = "1") int pageNo) {

		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		PageMakerDto<Notice> noticeList = null;
		try {
			// 페이지 번호(default 값 1)로 공지사항 리스트 최신순 찾기, 성공시 code 1
			noticeList = noticeService.selectAllOrderByDateDesc(pageNo);
			code = 1;
			msg = "성공";
		} catch (Exception e) {
			// 에러 발생시 code 2
			e.printStackTrace();
			code = 2;
			msg = "관리자에게 문의하세요.";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", noticeList);
		return resultMap;
	}
	/*
	 * 오래된순 정렬 : 공지사항 리스트 보기 (게시글 시작번호, 게시글 끝번호) - 페이징 처리
	 */
	@ApiOperation(value = "공지사항 리스트 오래된순")
	@GetMapping(value = "/notice-date-asc", produces = "application/json;charset=UTF-8")
	public Map<String, Object> notice_list_date_asc(@RequestParam(required = false, defaultValue = "1") int pageNo) {

		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		PageMakerDto<Notice> noticeList = null;
		try {
			// 페이지 번호(default 값 1)로 공지사항 리스트 오래된순 찾기, 성공시 code 1
			noticeList = noticeService.selectAllOrderByDateAsc(pageNo);
			code = 1;
			msg = "성공";
		} catch (Exception e) {
			// 에러 발생시 code 2
			e.printStackTrace();
			code = 2;
			msg = "관리자에게 문의하세요.";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", noticeList);
		return resultMap;
	}
	/*
	 * 조회수 높은순 정렬 : 공지사항 리스트 보기 (게시글 시작번호, 게시글 끝번호) - 페이징 처리
	 */
	@ApiOperation(value = "공지사항 리스트 조회순")
	@GetMapping(value = "/notice-readcount", produces = "application/json;charset=UTF-8")
	public Map<String, Object> notice_list_readcount(@RequestParam(required = false, defaultValue = "1") int pageNo) {

		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		PageMakerDto<Notice> noticeList = null;
		try {
			// 페이지 번호(default 값 1)로 공지사항 리스트 조회순 찾기, 성공시 code 1
			noticeList = noticeService.selectAllOrderByReadcount(pageNo);
			code = 1;
			msg = "성공";
		} catch (Exception e) {
			// 에러 발생시 code 2
			e.printStackTrace();
			code = 2;
			msg = "관리자에게 문의하세요.";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", noticeList);
		return resultMap;
	}
	/*
	 * 공지사항 게시판 title 키워드로 검색
	 */
	@ApiOperation(value = "공지사항 검색결과 리스트")
	@GetMapping(value = "/notice-search", produces = "application/json;charset=UTF-8")
	public Map<String, Object> notice_search_list(@RequestParam(required = false, defaultValue = "1") int pageNo,
												@RequestParam(required = true) String keyword) {

		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		PageMakerDto<Notice> noticeList = null;
		try {
			// 페이지 번호(default 값 1)와 검색 keyword로 공지사항 검색결과 리스트 찾기, 성공시 code 1
			noticeList = noticeService.selectSearchNoticeList(pageNo,keyword);
			if (noticeList.getTotRecordCount() != 0 && noticeList != null) {
				code = 1;
				msg = "성공";
			} else {
				// 검색 결과 없을시 code 2
				code = 2;
				msg = "해당 키워드에 해당하는 공지사항이 없습니다.";
			}
		} catch (Exception e) {
			// 에러 발생시 code 3
			e.printStackTrace();
			code = 3;
			msg = "관리자에게 문의하세요.";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", noticeList);
		return resultMap;
	}
	/*
	 * 공지사항 게시글 번호(boardno)로 해당 게시글 보기
	 */
	@ApiOperation(value = "공지사항 상세보기")
	@ApiImplicitParam(name = "nNo", value = "공지사항 번호")
	@GetMapping(value = "/notice/{nNo}", produces = "application/json;charset=UTF-8")
	public Map<String, Object> notice_detail(@PathVariable(value = "nNo") int nNo) {

		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		List<Notice> data = new ArrayList<Notice>();

		try {
			// nNo로 공지사항 1개 찾기, 성공시 code 1
			Notice notice = noticeService.selectByNo(nNo);
			if (notice != null) {
				// 공지사항 게시글 조회수 1 증가
				noticeService.increaseReadCount(nNo);
				code = 1;
				data.add(notice);
			} else {
				// 실패 시 code 2
				code = 2;
				msg = "해당 공지사항이 존재하지 않습니다.";
			}
		} catch (Exception e) {
			e.printStackTrace();
			// 에러 발생 시 code 3
			code = 3;
			msg = "관리자에게 문의하세요.";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);

		return resultMap;
	}
	


	/*
	 * 공지사항 게시글 추가
	 */
	@AdminCheck
	@LoginCheck
	@ApiOperation(value = "공지사항 글쓰기")
	@PostMapping(value = "/notice", produces = "application/json;charset=UTF-8")
	public Map<String, Object> notice_write_action(@RequestBody Notice notice){
		
		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		List<Notice> data = new ArrayList<Notice>();
		
		try {
			// 공지사항 글쓰기, 성공시 code 1
			noticeService.insertNotice(notice);
			code = 1;
			msg = "성공";
			// 공지사항 글쓰기 후 그 공지사항을 찾아서 데이터에 붙여줌
			notice = noticeService.selectByNo(notice.getNNo());
			data.add(notice);
		} catch (Exception e) {
			// 실패 시 code 2
			e.printStackTrace();
			code = 2;
			msg = "공지사항 글쓰기 실패";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		
		return resultMap;
	}
	
	
	//공지사항 게시글 삭제 
	@AdminCheck
	@LoginCheck
	@ApiOperation(value = "공지사항 삭제")
	@ApiImplicitParam(name = "nNo", value = "공지사항 번호")
	@DeleteMapping(value = "/notice/{nNo}", produces = "application/json;charset=UTF-8")
	public Map<String, Object> notice_delete_action(@PathVariable(value="nNo") int nNo,
													HttpServletRequest request) {
		
		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		List<Notice> data = new ArrayList<Notice>();
		try {
			// nNo로 공지사항 삭제, 성공시 code 1
			int rowCount = noticeService.deleteNotice(nNo);
			if (rowCount != 0) {
				code = 1;
				msg = "성공";
			} else {
				// 실패시 code 2
				code = 2;
				msg = "공지사항 삭제 실패";
				// 삭제 실패한 nNo 데이터에 붙여줌
				Notice failNotice = noticeService.selectByNo(nNo);
				data.add(failNotice);
			}
		} catch (Exception e) {
			// 에러시 code 3
			e.printStackTrace();
			code = 3;
			msg = "관리자에게 문의바랍니다.";
			
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		return resultMap;
	}

	/*
	 * 공지사항 게시글 내용 수정
	 */
	@AdminCheck
	@LoginCheck
	@ApiOperation(value = "공지사항 수정")
	@ApiImplicitParam(name = "nNo", value = "공지사항 번호")
	@PutMapping(value = "/notice/{nNo}", produces = "application/json;charset=UTF-8")
	public Map<String, Object> notice_modify_action(@PathVariable(value="nNo") int nNo,
													@RequestBody Notice notice) {

		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		List<Notice> data = new ArrayList<Notice>();
		try {
			// nNo로 공지사항 1개 찾기, 수정 성공시 code 1
			Notice findNotice = noticeService.selectByNo(nNo);
			if (findNotice != null) {
				notice.setNNo(nNo);
				noticeService.updateNotice(notice);
				code = 1;
				msg = "성공";
				// 수정 성공한 공지사항 객체 데이터에 붙여줌
				data.add(notice);
			} else {
				// 실패시 code 2
				code = 2;
				msg = "공지사항 수정 실패";
			}
		} catch (Exception e) {
			// 에러 발생 시 code 3
			e.printStackTrace();
			code = 3;
			msg = "관리자에게 문의하세요.";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		return resultMap;
	}
	
	/*
	 * 공지사항 리스트 보기 (게시글 시작번호, 게시글 끝번호) - 페이징 처리
	 * => 공지사항 첫 화면은 Controller 로 처리 (페이지기반)
	
	@ApiOperation(value = "공지사항 리스트")
	@GetMapping(value = "/notice", produces = "application/json;charset=UTF-8")
	public Map<String, Object> notice_list(@RequestParam(required = false, defaultValue = "1") int pageNo) {

		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		PageMakerDto<Notice> noticeList = null;
		try {
			// 페이지 번호(default 값 1)로 공지사항 리스트 찾기, 성공시 code 1
			noticeList = noticeService.selectAll(pageNo);
			code = 1;
			msg = "성공";
		} catch (Exception e) {
			// 에러 발생시 code 2
			e.printStackTrace();
			code = 2;
			msg = "관리자에게 문의하세요.";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", noticeList);
		return resultMap;
	}
	 */
	
	/*
	 * 관리자인지 확인, 아닐 경우 에러 처리
	
	@ApiOperation(value = "관리자 에러 처리")
	@GetMapping("/admin")
    public Map<String, Object> error(HttpServletRequest request) throws IsNotAdminException {
		
		Map<String, Object> resultMap = new HashMap<>();
		String message = (String) request.getAttribute("message");
        String exception = (String) request.getAttribute("exception");

        // IsNotAdminException 예외 발생 시 Exception 처리
        if (exception.equals("IsNotAdminException")) {
            throw new IsNotAdminException(message);
        }
        
        resultMap.put("code", 5);
		resultMap.put("msg", "관리자가 아닙니다.");
		resultMap.put("data", null);
        return resultMap;
        
        // 원래 void 로 처리 (resultMap 생략)
        
    }
     */
}
