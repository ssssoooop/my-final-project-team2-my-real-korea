package com.itwill.my_real_korea.service.tour;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.my_real_korea.dao.tour.TourImgDao;
import com.itwill.my_real_korea.dto.tour.TourImg;
@Service
public class TourImgServiceImpl implements TourImgService {
	@Autowired
	private TourImgDao tourImgDao;
	
	@Override
	public int insertTourImg(TourImg tourImg) {
		//투어이미지 추가
		return tourImgDao.insertTourImg(tourImg);
	}

	@Override
	public int deleteTourImg(int toImgNo) {
		//투어이미지번호로 투어이미지 하나 삭제
		return tourImgDao.deleteTourImg(toImgNo);
	}

	@Override
	public List<TourImg> findTourImgList(int to_no) {
		// 투어번호 해당 투어이미지 전체출력
		return tourImgDao.findTourImgList(to_no);
	}

	@Override
	public int deleteTourAllImg(int toNo) {
		// 투어번호로 해당 투어이미지 전체 삭제
		return tourImgDao.deleteTourAllImg(toNo);
	}

}
