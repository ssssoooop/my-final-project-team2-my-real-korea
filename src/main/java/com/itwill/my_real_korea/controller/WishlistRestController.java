package com.itwill.my_real_korea.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.my_real_korea.dto.notice.Notice;
import com.itwill.my_real_korea.dto.ticket.Ticket;
import com.itwill.my_real_korea.dto.wishlist.Wishlist;
import com.itwill.my_real_korea.service.wishlist.WishlistService;
import com.itwill.my_real_korea.util.PageMakerDto;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
public class WishlistRestController {

	@Autowired
	private WishlistService wishlistService;
	/*
	 * 위시리스트 리스트 전체 보기 (user_id)
	 */
	@LoginCheck
	@ApiOperation(value = "위시리스트 리스트")
	@GetMapping(value = "/wishlist", produces = "application/json;charset=UTF-8")
	public Map<String, Object> wishlist_list(@RequestParam(required = true) String userId) {

		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		List<Wishlist> data = new ArrayList<>();
		try {
			// userId로 위시리스트 리스트 찾기, 성공시 code 1
			data = wishlistService.selectAll(userId);
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
		resultMap.put("data", data);
		return resultMap;
	}
	/*
	 * 위시리스트 리스트 보기 + 티켓상품 + 투어상품  (user_id)
	 */
	@LoginCheck
	@ApiOperation(value = "위시리스트(티켓+투어) 리스트")
	@GetMapping(value = "/wishlist-with", produces = "application/json;charset=UTF-8")
	public Map<String, Object> wishlist_list_with_ticket_tour(@RequestParam(required = true) String userId) {

		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		List<Wishlist> data = new ArrayList<>();
		try {
			// userId로 위시리스트(티켓+투어) 리스트 찾기, 성공시 code 1
			data = wishlistService.selectAllWithTicketAndTour(userId);
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
		resultMap.put("data", data);
		return resultMap;
	}
	
	/*
	 * 티켓 상품 위시리스트에 추가
	 */
	@LoginCheck
	@ApiOperation(value = "위시리스트에 티켓 상품 추가")
	@PostMapping(value = "/wishlist-ticket", produces = "application/json;charset=UTF-8")
	public Map<String, Object> wishlist_ticket_add_action(@RequestBody Wishlist wishlist) {

		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		List<Wishlist> data = new ArrayList<>();
		try {
			// 위시리스트에 티켓 상품추가, 성공시 code 1
			wishlistService.insertTicketToWishlist(wishlist);
			code = 1;
			msg = "성공";
			// 위시리스트에 티켓 상품추가 후 그 위시리스트 데이터에 붙여줌
			wishlist = wishlistService.selectByWishNo(wishlist.getWishNo());
			data.add(wishlist);
		} catch (Exception e) {
			// 실패 시 code 2
			e.printStackTrace();
			code = 2;
			msg = "위시리스트 티켓추가 실패";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		return resultMap;
	}
	/*
	 * 투어 상품 위시리스트에 추가
	 */
	@LoginCheck
	@ApiOperation(value = "위시리스트에 투어 상품 추가")
	@PostMapping(value = "/wishlist-tour", produces = "application/json;charset=UTF-8")
	public Map<String, Object> wishlist_tour_add_action(@RequestBody Wishlist wishlist) {

		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		List<Wishlist> data = new ArrayList<>();
		try {
			// 위시리스트에 투어 상품추가, 성공시 code 1
			wishlistService.insertTourToWishlist(wishlist);
			code = 1;
			msg = "성공";
			// 위시리스트에 투어 상품추가 후 그 위시리스트 데이터에 붙여줌
			wishlist = wishlistService.selectByWishNo(wishlist.getWishNo());
			data.add(wishlist);
		} catch (Exception e) {
			// 실패 시 code 2
			e.printStackTrace();
			code = 2;
			msg = "위시리스트 투어추가 실패";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		return resultMap;
	}
	/*
	 * 위시리스트 전체 삭제 
	 */
	@LoginCheck
	@ApiOperation(value = "위시리스트 전체 삭제")
	@ApiImplicitParam(name = "userId", value = "회원아이디")
	@DeleteMapping(value = "/wishlist/{userId}", produces = "application/json;charset=UTF-8")
	public Map<String, Object> wishlist_delete_all_action(@PathVariable(value = "userId") String userId) {

		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		List<Wishlist> data = new ArrayList<>();
		try {
			// userId로 위시리스트 전체 삭제, 성공시 code 1
			int rowCount = wishlistService.deleteWishlist(userId);
			if (rowCount != 0) {
				code = 1;
				msg = "성공";
			} else {
				// 실패 시 code 2
				code = 2;
				msg = "위시리스트 전체 삭제 실패";
				// 삭제 실패한 리스트 전체 데이터에 붙여줌
				List<Wishlist> failWishlist = wishlistService.selectAllWithTicketAndTour(userId);
				data = failWishlist;
			}
		} catch (Exception e) {
			// 에러 시 code 3
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
	 * 위시리스트 한 개 삭제
	 */
	@LoginCheck
	@ApiOperation(value = "위시리스트 한개 삭제")
	@DeleteMapping(value = "/wishlist/{wishNo}/{userId}", produces = "application/json;charset=UTF-8")
	public Map<String, Object> wishlist_delete_action(@PathVariable(value = "wishNo") int wishNo,
														@PathVariable(value = "userId") String userId) {

		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		List<Wishlist> data = new ArrayList<>();
		try {
			// withNo, userId로 위시리스트 1개 삭제, 성공시 code 1
			int rowCount = wishlistService.deleteWishlistByNoAndId(wishNo, userId);
			if (rowCount != 0) {
				code = 1;
				msg = "성공";
			} else {
				// 실패 시 code 2
				code = 2;
				msg = "위시리스트 삭제 실패";
				// 삭제 실패한 위시리스트 데이터에 붙여줌
				Wishlist failWishlist = wishlistService.selectByWishNo(wishNo);
				data.add(failWishlist);
			}
		} catch (Exception e) {
			// 에러 시 code 3
			e.printStackTrace();
			code = 3;
			msg = "관리자에게 문의바랍니다.";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		return resultMap;
	}
	
	
}
