package com.itwill.my_real_korea.service.tour;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.my_real_korea.dao.tour.TourDao;
import com.itwill.my_real_korea.dao.tour.TourImgDao;
import com.itwill.my_real_korea.dao.tour.TourReserveDao;
import com.itwill.my_real_korea.dto.tour.Tour;
import com.itwill.my_real_korea.dto.tour.TourImg;
import com.itwill.my_real_korea.dto.tour.TourReserve;
import com.itwill.my_real_korea.util.PageMaker;
import com.itwill.my_real_korea.util.PageMakerDto;
@Service
public class TourReserveServiceImpl implements TourReserveService {
	@Autowired
	private TourReserveDao tourReserveDao;
	@Autowired
	private TourDao tourDao;
	@Autowired
	private TourImgDao tourImgDao;

	@Override
	public int insertTourReserve(TourReserve tourReserve) throws Exception {
		// 투어예약 추가
		return tourReserveDao.insertTourReserve(tourReserve);
	}

	@Override
	public int updateTourReserve(TourReserve tourReserve) throws Exception {
		// 투어예약 변경
		return tourReserveDao.updateTourReserve(tourReserve);
	}

	@Override
	public int deleteTourReserve(int toRsNo) throws Exception {
		// 투어예약 삭제
		return tourReserveDao.deleteTourReserve(toRsNo);
	}

	@Override
	public TourReserve findTourReserveWithTourByToRsNo(int toRsNo) throws Exception {
		// 투어예약번호로 예약 상세보기
		TourReserve tourReserve= tourReserveDao.findTourReserveWithTourByToRsNo(toRsNo);
		int toNo=tourReserve.getTour().getToNo();
		List<TourImg> tourImgList=tourImgDao.findTourImgList(toNo);
		tourReserve.getTour().setTourImgList(tourImgList);
		return tourReserve;
	}
	
	@Override
	public int deleteAllTourReserveByUserId(String userId) throws Exception {
		// 유저의 투어예약 전체 삭제
		return tourReserveDao.deleteAllTourReserveByUserId(userId);
	}

	@Override
	public PageMakerDto<TourReserve> findAll(int currenrPage, String sortOrder, String userId) throws Exception {
		//유저의 투어예약 리스트 전체 보여주기
		int totTourReserveCount=tourReserveDao.findTourReserveCountByUserId(userId);	//전체 글 개수 
		PageMaker pageMaker=new PageMaker(totTourReserveCount,currenrPage);		//page 계산(pageMaker)
		//예약내역 데이터 얻기
		List<TourReserve> tourReserveList=tourReserveDao.findAllTourReservewithTourByUserId(pageMaker.getPageBegin(), pageMaker.getPageEnd(), sortOrder, userId);
		PageMakerDto<TourReserve> pageMakerTourReserveList
				=new PageMakerDto<TourReserve>(tourReserveList,pageMaker,totTourReserveCount);
		return pageMakerTourReserveList;
	}



}

/*
	@Override
	public List<TourReserve> findAllTourReservewithTourByUserId(String userId) throws Exception {
		//유저의 투어예약 리스트 전체 보여주기
		List<TourReserve> tourReserveList=tourReserveDao.findAllTourReservewithTourByUserId(userId);
		for (TourReserve tourReserve : tourReserveList) {
			int toNo=tourReserve.getTour().getToNo();
			List<TourImg> tourImgList=tourImgDao.findTourImgList(toNo);
			tourReserve.getTour().setTourImgList(tourImgList);
		}
		return tourReserveList;
	}
 */