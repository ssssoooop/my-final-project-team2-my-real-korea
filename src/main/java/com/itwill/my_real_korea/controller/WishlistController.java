package com.itwill.my_real_korea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.my_real_korea.dto.wishlist.Wishlist;
import com.itwill.my_real_korea.service.wishlist.WishlistService;

@Controller
public class WishlistController {

	@Autowired
	private WishlistService wishlistService;
	
	// 위시리스트 리스트 + 티켓상품 + 투어상품 전체 보기 (위시리스트 첫화면) - 페이지로 할 지 rest로 할 지 user와 상의
	@GetMapping(value = "/wishlist")
	public String wishlist(@RequestParam(required = true) String userId,
							Model model) {
		
		List<Wishlist> wishlistList = wishlistService.selectAllWithTicketAndTour(userId);
		model.addAttribute("wishlistList", wishlistList);
		model.addAttribute("userId", userId);
		
		return "wishlist";
	}
	
}
