package com.itwill.my_real_korea.service.tour;

import java.util.List;

import com.itwill.my_real_korea.dto.City;
import com.itwill.my_real_korea.dto.tour.Tour;
import com.itwill.my_real_korea.dto.tour.TourImg;
import com.itwill.my_real_korea.util.PageMakerDto;

public interface TourService {
	//1. 투어 상품 추가
	int insertTour(Tour tour) throws Exception;
	//2. 투어 상품 변경
	int updateTour(Tour tour) throws Exception;
	//3. 투어 상품 삭제
	int deleteTour(int toNo) throws Exception;
	//4. 투어 상세보기
	Tour findTourWithCityByToNo(int toNo) throws Exception;

	//페이지메이커 사용
	//5. 투어 전체 리스트 보기 + 필터 + 정렬 + 페이징
	PageMakerDto<Tour> findAll(int currentPage,String keyword, int cityNo, int toType, String sortOrder) throws Exception;
	//6. 상품 지역필터 + 정렬 + 페이징
	PageMakerDto<Tour> findAllByFilter(int currentPage, int cityNo, String sortOrder) throws Exception;

}

/*
	//5. 투어 전체 리스트 보기 + 정렬 + 페이징
	List<Tour> findTourWithTourImgWithCityAll(int pageStart,int pageEnd,String sortOrder) throws Exception;
	//6~8. 상품필터링(키워드,지역,가격) + 정렬 + 페이징
	List<Tour> findTourListByFilter(int pageStart, int pageEnd, String keyword,int cityNo, String sortOrder) throws Exception;
	//6. 키워드로 검색 한 투어상품리스트
	List<Tour> findTourListByKeyword(String keyword) throws Exception;
	//7. 지역으로 투어상품 검색
	List<Tour> findTourListByCityNo(int cityNo) throws Exception;
	//8. 여행타입으로 투어상품 검색
	List<Tour> findTourListByToType(int toType) throws Exception;
 */	