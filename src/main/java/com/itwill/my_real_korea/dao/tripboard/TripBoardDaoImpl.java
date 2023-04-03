package com.itwill.my_real_korea.dao.tripboard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.my_real_korea.dto.tripboard.TripBoard;
import com.itwill.my_real_korea.mapper.TripBoardMapper;

@Repository
public class TripBoardDaoImpl implements TripBoardDao{
	
	@Autowired
	private TripBoardMapper tripBoardMapper;
	
	public TripBoardDaoImpl() {
		System.out.println("TripBoardDaoImpl 기본 생성자 호출");
	}
	
	/*
	 * 게시글 추가
	 */
	@Override
	public int insertTripBoard(TripBoard tripBoard) throws Exception {
		return tripBoardMapper.insertTripBoard(tripBoard);
	}
	
	/*
	 * 게시글 수정
	 */
	@Override
	public int updateTripBoard(TripBoard tripBoard) throws Exception {
		return tripBoardMapper.updateTripBoard(tripBoard);
	}
	
	/*
	 * 게시글 삭제
	 */
	@Override
	public int deleteTripBoard(int tBoNo) throws Exception {
		return tripBoardMapper.deleteTripBoard(tBoNo);
	}
	
	/*
	 * 게시글 번호로 게시글 1개 보기
	 */
	@Override
	public TripBoard selectByTbNo(int tBoNo) throws Exception {
		return tripBoardMapper.selectByTbNo(tBoNo);
	}
	
	/*
	 * 게시글 모집상태별로 보기
	 */
	@Override
	public List<TripBoard> selectByTbStatusList(int tBoStatus) throws Exception {
		
		return tripBoardMapper.selectByTbStatusList(tBoStatus);
	}
	
	/*
	 * 게시글 지역별로 보기
	 */
	@Override
	public List<TripBoard> selectByCityNoList(int cityNo) throws Exception {
		
		return tripBoardMapper.selectByCityNoList(cityNo);
	}
	
	/*
	 * 게시글 해시태크별로 보기
	 */
	@Override
	public List<TripBoard> selectByHashtagList(String hashtag) throws Exception {
		
		return tripBoardMapper.selectByHashtagList(hashtag);
	}
	
	/*
	 * 게시판 리스트 정렬(게시글 작성 날짜 기준 내림차순)
	 */
	@Override
	public List<TripBoard> selectAllOrderByDate() throws Exception {
		
		return tripBoardMapper.selectAllOrderByDate();
	}
	
	/*
	 * 게시판 리스트 정렬(조회수 기준 내림차순)
	 */
	@Override
	public List<TripBoard> selectAllOrderByReadCount() throws Exception {
		
		return tripBoardMapper.selectAllOrderByReadCount();
	}
	
	/*
	 * 게시판 리스트
	 */
	@Override
	public List<TripBoard> selectAllTb() throws Exception {
		
		return tripBoardMapper.selectAllTb();
	}
	
	/*
	 * 게시글  총 개수
	 */
	@Override
	public int selectAllTbCount() throws Exception {
		return tripBoardMapper.selectAllTbCount();
	}
	
	/*
	 * 모집상태별 게시글 개수
	 */
	@Override
	public int selectStatusCount(int tBoStatus) throws Exception {
		return tripBoardMapper.selectStatusCount(tBoStatus);
	}
	
	/*
	 * 지역별 게시글 개수
	 */
	@Override
	public int selectCityNoCount(int cityNo) throws Exception {
		return tripBoardMapper.selectCityNoCount(cityNo);
	}
	
	/*
	 * 해시태그별 게시글 개수
	 */
	@Override
	public int selectHashtagCount(String hashtag) throws Exception {
		return tripBoardMapper.selectHashtagCount(hashtag);
	}
	
	/*
	 * 게시글 조회수 1 증가
	 */
	@Override
	public int increaseTbReadCount(int tBoNo) throws Exception {
		return tripBoardMapper.increaseTbReadCount(tBoNo);
	}
	
	/*
	 * 키워드로 검색된 동행게시판 리스트
	 */
	@Override
	public List<TripBoard> selectSearchTbList(String keyword) throws Exception {
		
		return tripBoardMapper.selectSearchTbList(keyword);
	}
	
	/*
	 * 검색된 게시글 총 개수
	 */
	@Override
	public int selectTbSearchCount(String keyword) throws Exception {
		return tripBoardMapper.selectTbSearchCount(keyword);
	}
	
	/*
	 * 게시글 1개 조회 + City 정보
	 */
	@Override
	public TripBoard selectCityInfo(int tBoNo) throws Exception {
		return tripBoardMapper.selectCityInfo(tBoNo);
	}
	
	/*
	 * 게시글리스트 조회 + City 정보
	 */
	@Override
	public List<TripBoard> selectAllByCityNo() throws Exception {
		return tripBoardMapper.selectAllByCityNo();
	}
	
}
