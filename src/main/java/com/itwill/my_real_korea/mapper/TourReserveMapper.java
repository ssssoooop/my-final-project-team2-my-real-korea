package com.itwill.my_real_korea.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.my_real_korea.dto.tour.TourReserve;

@Mapper
public interface TourReserveMapper {
	//1. 투어예약 추가
	public int insertTourReserve(TourReserve tourReserve) throws Exception;
	//2. 투어예약 변경
	public int updateTourReserve(TourReserve tourReserve) throws Exception;
	//3. 투어예약 삭제
	public int deleteTourReserve(int toRsNo) throws Exception;
	//4. 투어예약번호로 예약 상세보기
	public TourReserve findTourReserveWithTourByToRsNo(int toRsNo) throws Exception;
	//5. 유저의 투어예약 리스트 전체 보여주기
	//public List<TourReserve> findAllTourReservewithTourByUserId(String userId) throws Exception;
	public List<TourReserve> findAllTourReservewithTourByUserId(Map<String,Object> tourReserveMap) throws Exception;
	//6. 유저의 투어예약 전체 삭제
	public int deleteAllTourReserveByUserId(String userId) throws Exception;
	//7. 특정 유저의 투어예약 총 개수
	int findTourReserveCountByUserId(String userId) throws Exception;
}
