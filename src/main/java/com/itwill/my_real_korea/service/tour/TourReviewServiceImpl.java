package com.itwill.my_real_korea.service.tour;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.my_real_korea.dao.tour.TourReviewDao;
import com.itwill.my_real_korea.dto.tour.TourReview;
import com.itwill.my_real_korea.util.PageMaker;
import com.itwill.my_real_korea.util.PageMakerDto;
@Service
public class TourReviewServiceImpl implements TourReviewService {
	@Autowired
	private TourReviewDao tourReviewDao;
	
	@Override
	public int insertTourReview(TourReview tourRiview) throws Exception {
		// 투어상품 후기 추가 
		return tourReviewDao.insertTourReview(tourRiview);
	}

	@Override
	public int updateTourReview(TourReview tourReview) throws Exception {
		// 투어 후기 수정
		return tourReviewDao.updateTourReview(tourReview);
	}

	@Override
	public int deleteTourReview(int toReviewNo) throws Exception {
		//투어 후기 번호로 후기 삭제
		return tourReviewDao.deleteTourReview(toReviewNo);
	}

	@Override
	public PageMakerDto<TourReview> findByUserId(int currentPage, String sortOrder, String userId) throws Exception {
		//사용자가 작성한 후기 전체 보기
		int totTourReviewCount=tourReviewDao.findCountByUserId(userId);	//전체 글 갯수
		PageMaker pageMaker=new PageMaker(totTourReviewCount, currentPage);	//page 계산(PageMaker)
		//게시글 데이터 얻기
		List<TourReview> tourReviewList=tourReviewDao.selectByUserId(pageMaker.getPageBegin(), pageMaker.getPageEnd(), userId, sortOrder);
		PageMakerDto<TourReview> pageMakerTourReviewList=new PageMakerDto<TourReview>(tourReviewList, pageMaker, totTourReviewCount);
		return pageMakerTourReviewList;
	}

	@Override
	public PageMakerDto<TourReview> findByToNo(int currentPage, String sortOrder, int toNo) throws Exception {
		// 투어 상품번호로 후기 전체 보기
		int totTourReviewCount=tourReviewDao.findCountByToNo(toNo);	//전체 글 갯수
		PageMaker pageMaker=new PageMaker(totTourReviewCount, currentPage);	//page 계산(PageMaker)
		//게시글 데이터 얻기
		List<TourReview> tourReviewList=tourReviewDao.selectByToNo(pageMaker.getPageBegin(), pageMaker.getPageEnd(), toNo, sortOrder);
		PageMakerDto<TourReview> pageMakerTourReviewList=new PageMakerDto<TourReview>(tourReviewList, pageMaker, totTourReviewCount);
		return pageMakerTourReviewList;
	}

}
