package com.itwill.my_real_korea.dao.tour;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.my_real_korea.dto.tour.Tour;
import com.itwill.my_real_korea.mapper.TourMapper;

@Repository
public class TourDaoImpl implements TourDao{
	@Autowired
	private TourMapper tourMapper;
	
	public TourDaoImpl() {
		System.out.println("TourDaoImp 기본생성자 호출");
	}
	
	@Override
	public int insertTour(Tour tour) throws Exception {
		// 투어상품 추가
		return tourMapper.insertTour(tour);
	}

	@Override
	public int updateTour(Tour tour) throws Exception {
		// 투어상품 수정
		return tourMapper.updateTour(tour);
	}

	@Override
	public Tour findTourWithCityByToNo(int toNo) throws Exception {
		// 투어상품 상품번호로 상세보기
		return tourMapper.findTourWithCityByToNo(toNo);
	}

	@Override
	public int deleteTour(int toNo) throws Exception {
		// 투어상품 삭제 
		return tourMapper.deleteTour(toNo);
	}

	@Override
	public List<Tour> findTourWithTourImgWithCityAll(int pageStart, int pageEnd,String keyword, int cityNo, int toType, String sortOrder) throws Exception {
		// 투어상품 리스트 전체 출력 + 정렬 + 페이징
		Map<String, Object> tourPageMap=new HashMap<>();
		tourPageMap.put("pageStart",pageStart);
		tourPageMap.put("pageEnd",pageEnd);
		tourPageMap.put("keyword",keyword);
		tourPageMap.put("cityNo",cityNo);
		tourPageMap.put("toType",toType);
		tourPageMap.put("sortOrder", sortOrder);
		return tourMapper.findTourWithTourImgWithCityAll(tourPageMap);
	}

	@Override
	public List<Tour> findTourListByCity(int pageStart, int pageEnd, int cityNo, String sortOrder)
			throws Exception {
		// 상품 지역필터링 +정렬 + 페이징
		Map<String,Object> tourPageMap=new HashMap<>();
		tourPageMap.put("pageStart",pageStart);
		tourPageMap.put("pageEnd",pageEnd);
		tourPageMap.put("cityNo", cityNo);
		tourPageMap.put("sortOrder", sortOrder);
		return tourMapper.findTourListByFilter(tourPageMap);
	}

	@Override
	public int findTourCount() throws Exception {
		return tourMapper.findTourCount();
	}
}


/*
	@Override
	public List<Tour> findTourWithTourImgWithCityAll() throws Exception {
		// 투어상품 리스트 전체 출력
		return tourMapper.findTourWithTourImgWithCityAll();
	}
	
	@Override
	public List<Tour> findTourListByKeyword(String keyword) throws Exception {
		// 키워드로 투어상품 검색
		return tourMapper.findTourListByKeyword(keyword);
	}

	@Override
	public List<Tour> findTourListByCityNo(int cityNo) throws Exception {
		// 지역으로 투어상품 검색 
		return tourMapper.findTourListByCityNo(cityNo);
	}

	@Override
	public List<Tour> findTourListByToType(int toType) throws Exception {
		// 여행타입으로 투어상품 검색
		return tourMapper.findTourListByToType(toType);
	}
 */