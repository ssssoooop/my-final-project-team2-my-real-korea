package com.itwill.my_real_korea.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.my_real_korea.dto.tour.TourImg;

@Mapper
public interface TourImgMapper {
	//1. 투어이미지 추가
	public int insertTourImg(TourImg tourImg);
	//2. 투어이미지번호로 투어 이미지 하나 삭제
	public int deleteTourImg(int toImgNo);
	//3. 투어번호로 투어이미지 전체출력
	public List<TourImg> findTourImgList(int toNo);
	//4. 투어번호로 해당 투어이미지 전체 삭제
	public int deleteTourAllImg(int toNo);
}
