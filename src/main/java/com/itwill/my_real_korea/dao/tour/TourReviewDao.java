package com.itwill.my_real_korea.dao.tour;

import java.util.List;

import com.itwill.my_real_korea.dto.tour.TourReview;

public interface TourReviewDao {
	//1. 투어상품 후기 추가
	int insertTourReview(TourReview tourRiview) throws Exception;
	//2. 투어상품번호로 후기 전체 보기 + 페이징 
	List<TourReview> selectByToNo(int pageStart, int pageEnd,int toNo, String sortOrder) throws Exception;
	//3. 투어후기 후기 수정
	int updateTourReview(TourReview tourReview) throws Exception;
	//4. 투어후기번호로 후기 삭제
	int deleteTourReview(int toReviewNo) throws Exception;
	//5. 사용자가 작성한 후기 전체 보기
	List<TourReview> selectByUserId(int pageStart, int pageEnd,String userId,String sortOrder) throws Exception;
	//6. 투어상품번호로 찾은 투어 후기 갯수
	public int findCountByToNo(int toNo) throws Exception;
	//7. 사용자가 작성한 후기 갯수 
	public int findCountByUserId(String userId) throws Exception;
}
