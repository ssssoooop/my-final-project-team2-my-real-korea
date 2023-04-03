package com.itwill.my_real_korea.dao.tour;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.my_real_korea.dto.tour.TourImg;
import com.itwill.my_real_korea.mapper.TourImgMapper;
@Repository
public class TourImgDaoImpl implements TourImgDao {
	@Autowired
	private TourImgMapper tourImgMapper;
	
	public TourImgDaoImpl() {
		System.out.println("TourImgDaoImp 기본생성자 호출");
	}
	
	
	@Override
	public int insertTourImg(TourImg tourImg) {
		// 투어이미지 추가
		return tourImgMapper.insertTourImg(tourImg);
	}

	@Override
	public int deleteTourImg(int toImgNo) {
		// 투어이미지번호로 투어 이미지 하나 삭제
		return tourImgMapper.deleteTourImg(toImgNo);
	}

	@Override
	public List<TourImg> findTourImgList(int to_no) {
		// 투어번호로 해당 투어이미지 전체출력
		return tourImgMapper.findTourImgList(to_no);
	}

	@Override
	public int deleteTourAllImg(int toNo) {
		//투어번호로 해당 투어이미지 전체 삭제
		return tourImgMapper.deleteTourAllImg(toNo);
	}

}
