package com.itwill.my_real_korea.service.wishlist;

import java.util.List;

import com.itwill.my_real_korea.dto.wishlist.Wishlist;

public interface WishlistService {
	
	/*
	 * 위시리스트 리스트 전체 보기 (user_id)
	 */
	List<Wishlist> selectAll(String userId);
	/*
	 * 위시리스트 리스트 보기 + 티켓상품 + 투어상품  (user_id)
	 */
	List<Wishlist> selectAllWithTicketAndTour(String userId);
	/*
	 * 위시리스트 1개 보기(wish_no)
	 */
	Wishlist selectByWishNo(int wishNo);
	/*
	 * 위시리스트 담겨있는 티켓/투어 상품의 수 
	 */
	int selectWishlistCount(String userId);
	/*
	 * 티켓 상품 위시리스트에 추가
	 */
	int insertTicketToWishlist(Wishlist wishlist);
	/*
	 * 투어 상품 위시리스트에 추가
	 */
	int insertTourToWishlist(Wishlist wishlist);
	
	/*
	 * 위시리스트 전체 삭제 
	 */
	int deleteWishlist(String userId);

	/*
	 * 위시리스트 한 개 삭제
	 */
	int deleteWishlistByNoAndId(int wishNo, String userId);

	

}
