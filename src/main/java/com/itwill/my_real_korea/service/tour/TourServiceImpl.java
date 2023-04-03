
package com.itwill.my_real_korea.service.tour;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.my_real_korea.dao.city.CityDao;
import com.itwill.my_real_korea.dao.tour.TourDao;
import com.itwill.my_real_korea.dao.tour.TourImgDao;
import com.itwill.my_real_korea.dto.City;
import com.itwill.my_real_korea.dto.tour.Tour;
import com.itwill.my_real_korea.dto.tour.TourImg;
import com.itwill.my_real_korea.util.PageMaker;
import com.itwill.my_real_korea.util.PageMakerDto;
@Service
public class TourServiceImpl implements TourService {
	@Autowired
	private TourDao tourDao;
	@Autowired
	private TourImgDao tourImgDao;
	@Override
	public int insertTour(Tour tour) throws Exception {
		//투어상품 추가
		return tourDao.insertTour(tour);
	}

	@Override
	public int updateTour(Tour tour) throws Exception {
		//투어상품 변경
		return tourDao.updateTour(tour);
	}

	@Override
	public int deleteTour(int toNo) throws Exception {
		//투어상품 삭제
		return tourDao.deleteTour(toNo);
	}

	@Override
	public Tour findTourWithCityByToNo(int toNo) throws Exception {
		//투어 상세보기
		List<TourImg> tourImgList=tourImgDao.findTourImgList(toNo);
		Tour findTour=tourDao.findTourWithCityByToNo(toNo);
		findTour.setTourImgList(tourImgList);
		return findTour;
	}

	@Override
	public PageMakerDto<Tour> findAll(int currentPage,String keyword, int cityNo, int toType, String sortOrder) throws Exception {
		// 투어 전체 리스트 보기 + 정렬 + 페이징
		int totTourCount=tourDao.findTourCount();	//전체 글 
		PageMaker pageMaker= new PageMaker(totTourCount,currentPage);	//page 계산 (PageMaker)
		//게시글 데이터 얻기
		List<Tour> tourList=tourDao.findTourWithTourImgWithCityAll(pageMaker.getPageBegin(), pageMaker.getPageEnd(), keyword, cityNo, toType, sortOrder);
		PageMakerDto<Tour> pageMakerTourList=new PageMakerDto<Tour>(tourList,pageMaker,totTourCount);
		return pageMakerTourList;
	}

	@Override
	public PageMakerDto<Tour> findAllByFilter(int currentPage, int cityNo, String sortOrder)
			throws Exception {
		int totTourCount=tourDao.findTourCount();	//전체 글 개수 
		PageMaker pageMaker= new PageMaker(totTourCount,currentPage);	//page 계산 (PageMaker)
		//게시글 데이터 얻기
		List<Tour> tourList=tourDao.findTourListByCity(pageMaker.getPageBegin(), pageMaker.getPageEnd(), cityNo, sortOrder);
		PageMakerDto<Tour> pageMakerTourList=new PageMakerDto<Tour>(tourList,pageMaker,totTourCount);
		return null;
	}
}

/*
	@Override
	public List<Tour> findTourWithTourImgWithCityAll() throws Exception {
		//투어 전체 리스트 보기
		return tourDao.findTourWithTourImgWithCityAll();
	}

	@Override
	public List<Tour> findTourListByKeyword(String keyword) throws Exception {
		//키워드로 검색 한 투어상품리스트
		return tourDao.findTourListByKeyword(keyword);
	}

	@Override
	public List<Tour> findTourListByCityNo(int cityNo) throws Exception {
		//지역으로 투어상품 검색
		return tourDao.findTourListByCityNo(cityNo);
	}

	@Override
	public List<Tour> findTourListByToType(int toType) throws Exception {
		//여행타입으로 투어상품 검색
		return tourDao.findTourListByToType(toType);
	}
 */	