package com.itwill.my_real_korea.service.tour;

import java.util.List;
import java.util.Map;

import com.itwill.my_real_korea.dto.tour.TourReview;
import com.itwill.my_real_korea.util.PageMakerDto;

public interface TourReviewService {

	//1. 투어상품 후기 추가
	public int insertTourReview(TourReview tourRiview) throws Exception;
	//2. 투어후기 수정
	public int updateTourReview(TourReview tourReview) throws Exception;
	//3. 투어후기번호로 후기 삭제
	public int deleteTourReview(int toReviewNo) throws Exception;

	//페이지 메이커 사용
	//4. 사용자가 작성한 후기 전체 보기
	public PageMakerDto<TourReview> findByUserId(int currentPage,String sortOrder,String userId) throws Exception;
	//5. 투어상품번호로 후기 전체 보기
	public PageMakerDto<TourReview> findByToNo(int currentPage,String sortOrder,int toNo) throws Exception;
}
