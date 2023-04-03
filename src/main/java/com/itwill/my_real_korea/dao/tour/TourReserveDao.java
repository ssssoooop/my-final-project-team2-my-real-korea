package com.itwill.my_real_korea.dao.tour;

import java.util.List;

import com.itwill.my_real_korea.dto.tour.TourReserve;

public interface TourReserveDao {
	//1. 투어예약 추가
	int insertTourReserve(TourReserve tourReserve) throws Exception;
	//2. 투어예약 변경
	int updateTourReserve(TourReserve tourReserve) throws Exception;
	//3. 투어예약 삭제
	int deleteTourReserve(int toRsNo) throws Exception;
	//4. 투어예약번호로 예약 상세보기
	TourReserve findTourReserveWithTourByToRsNo(int toRsNo) throws Exception;
	//5. 유저의 투어예약 리스트 전체 보여주기
	List<TourReserve> findAllTourReservewithTourByUserId(int pageStart,int pageEnd,String sortOrder,String userId) throws Exception;
	//6. 유저의 투어예약 전체 삭제
	int deleteAllTourReserveByUserId(String userId) throws Exception;
	//7. 특정 유저의 투어예약 총 개
	int findTourReserveCountByUserId(String userId) throws Exception;
}
