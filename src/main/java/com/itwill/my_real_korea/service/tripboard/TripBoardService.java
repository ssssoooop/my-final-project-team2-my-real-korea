package com.itwill.my_real_korea.service.tripboard;

import java.util.List;

import com.itwill.my_real_korea.dto.tripboard.TripBoard;

public interface TripBoardService {
	/*
	 * 게시글 추가
	 */
	int insertTripBoard(TripBoard tripBoard) throws Exception;
	
	/*
	 * 게시글 수정
	 */
	int updateTripBoard(TripBoard tripBoard) throws Exception;
	
	/*
	 * 게시글 삭제
	 */
	int deleteTripBoard(int tBoNo) throws Exception;
	
	/*
	 * 게시글 번호로 게시글 1개 보기
	 */
	TripBoard selectByTbNo(int tBoNo) throws Exception;
	
	/*
	 * 게시글 모집상태별로 보기
	 */
	List<TripBoard> selectByTbStatusList(int tBoStatus) throws Exception;
	
	/*
	 * 게시글 지역별로 보기
	 */
	List<TripBoard> selectByCityNoList(int cityNo) throws Exception;
	
	/*
	 * 게시글 해시태그별로 보기
	 */
	List<TripBoard> selectByHashtagList(String hashtag) throws Exception;
	
	/*
	 * 게시판 리스트 정렬(게시글 작성 날짜 기준 내림차순)
	 */
	List<TripBoard> selectAllOrderByDate() throws Exception;
	
	/*
	 * 게시판 리스트 정렬(조회수 기준 내림차순)
	 */
	List<TripBoard> selectAllOrderByReadCount() throws Exception;

	/*
	 * 게시판 리스트
	 */
	List<TripBoard> selectAllTb() throws Exception;
	
	/*
	 * 게시글  총 개수
	 */
	int selectAllTbCount() throws Exception;
	
	/*
	 * 모집상태별 게시글 개수
	 */
	int selectStatusCount(int tBoStatus) throws Exception;
	
	/*
	 * 지역별 게시글 개수
	 */
	int selectCityNoCount(int cityNo) throws Exception;
	
	/*
	 * 해시태그별 게시글 개수
	 */
	int selectHashtagCount(String hashtag) throws Exception;

	/*
	 * 게시글 조회수 1 증가
	 */
	int increaseTbReadCount(int tBoNo) throws Exception;
	
	/*
	 * 키워드로 검색된 동행게시판 리스트
	 */
	List<TripBoard> selectSearchTbList(String keyword) throws Exception;
	
	/*
	 * 검색된 게시글 총 개수
	 */
	int selectTbSearchCount(String keyword) throws Exception;
	
	/*
	 * 게시글 1개 조회 + City 정보
	 */
	TripBoard selectCityInfo(int tBoNo) throws Exception;
	
	/*
	 * 게시글리스트 조회 + City 정보
	 */
	List<TripBoard> selectAllByCityNo() throws Exception;
}
