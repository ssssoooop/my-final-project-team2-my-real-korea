package com.itwill.my_real_korea.dao.tour;

import java.util.List;

import com.itwill.my_real_korea.dto.tour.Tour;

public interface TourDao {
	//1. 투어상품 추가
	int insertTour(Tour tour) throws Exception;
	//2. 투어상품 수정
	public int updateTour(Tour tour) throws Exception;
	//3. 투어상품 리스트 전체 출력 + 페이징 + 정렬 + 페이징
	//List<Tour> findTourWithTourImgWithCityAll() throws Exception;
	List<Tour> findTourWithTourImgWithCityAll(int PageStart, int PageEnd, String keyword, int cityNo, int toType, String sortOrder) throws Exception;
	//4. 투어상품 상품번호로 상세보기
	Tour findTourWithCityByToNo(int toNo) throws Exception;
	//5. 상품 지역필터링 + 정렬 + 페이징
	List<Tour> findTourListByCity(int pageStart, int pageEnd, int cityNo, String sortOrder) throws Exception;
	//8. 투어상품 삭제
	int deleteTour(int toNo) throws Exception;
	//9. 상품 총 개수
	int findTourCount() throws Exception;
}
/*
	//5. 키워드로 투어상품 검색
	List<Tour> findTourListByKeyword(String keyword) throws Exception;
	//6. 지역으로 투어상품 검색
	List<Tour> findTourListByCityNo(int cityNo) throws Exception;
	//7. 여행타입으로 투어상품 검색
	List<Tour> findTourListByToType(int toType) throws Exception;
 */
