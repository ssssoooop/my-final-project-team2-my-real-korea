package com.itwill.my_real_korea.service.tour;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.my_real_korea.dao.tour.TourImgDao;
import com.itwill.my_real_korea.dto.tour.TourImg;

public interface TourImgService {
	//1. 투어이미지 추가
	int insertTourImg(TourImg tourImg);
	//2. 투어이미지번호로 투어이미지 하나 삭제
	int deleteTourImg(int toImgNo);
	//3. 투어번호 해당 투어이미지 전체출력
	List<TourImg> findTourImgList(int to_no);
	//4. 투어번호로 해당 투어이미지 전체 삭제
	int deleteTourAllImg(int toNo);
}
