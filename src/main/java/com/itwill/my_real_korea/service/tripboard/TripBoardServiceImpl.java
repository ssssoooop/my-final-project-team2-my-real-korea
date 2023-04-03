package com.itwill.my_real_korea.service.tripboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.my_real_korea.dao.tripboard.TripBoardDao;
import com.itwill.my_real_korea.dto.tripboard.TripBoard;

@Service
public class TripBoardServiceImpl implements TripBoardService {
	@Autowired
	private TripBoardDao tripBoardDao;
	
	public TripBoardServiceImpl() {
		System.out.println(">>> TripBoardServiceImpl 기본 생성자 호출");
	}
	
	/*
	 * 게시글 추가
	 */
	@Override
	public int insertTripBoard(TripBoard tripBoard) throws Exception {
		return tripBoardDao.insertTripBoard(tripBoard);
	}
	/*
	 * 게시글 수정
	 */
	@Override
	public int updateTripBoard(TripBoard tripBoard) throws Exception {
		return tripBoardDao.updateTripBoard(tripBoard);
	}
	/*
	 * 게시글 삭제
	 */
	@Override
	public int deleteTripBoard(int tBoNo) throws Exception {
		return tripBoardDao.deleteTripBoard(tBoNo);
	}
	/*
	 * 게시글 번호로 게시글 1개 보기
	 */
	@Override
	public TripBoard selectByTbNo(int tBoNo) throws Exception {
		return tripBoardDao.selectByTbNo(tBoNo);
	}
	
	/*
	 * 게시글 모집상태별로 보기
	 */
	@Override
	public List<TripBoard> selectByTbStatusList(int tBoStatus) throws Exception {
		return tripBoardDao.selectByTbStatusList(tBoStatus);
	}
	
	/*
	 * 게시글 지역별로 보기
	 */
	@Override
	public List<TripBoard> selectByCityNoList(int cityNo) throws Exception {
		return tripBoardDao.selectByCityNoList(cityNo);
	}
	
	/*
	 * 게시글 해시태그별로 보기
	 */
	@Override
	public List<TripBoard> selectByHashtagList(String hashtag) throws Exception {
		return tripBoardDao.selectByHashtagList(hashtag);
	}
	
	/*
	 * 게시판 리스트 정렬(게시글 작성 날짜 기준 내림차순)
	 */
	@Override
	public List<TripBoard> selectAllOrderByDate() throws Exception {
		return tripBoardDao.selectAllOrderByDate();
	}
	
	/*
	 * 게시판 리스트 정렬(조회수 기준 내림차순)
	 */
	@Override
	public List<TripBoard> selectAllOrderByReadCount() throws Exception {
		return tripBoardDao.selectAllOrderByReadCount();
	}
	
	/*
	 * 게시판 리스트
	 */
	@Override
	public List<TripBoard> selectAllTb() throws Exception {
		return tripBoardDao.selectAllTb();
	}
	
	/*
	 * 게시글  총 개수
	 */
	@Override
	public int selectAllTbCount() throws Exception {
		return tripBoardDao.selectAllTbCount();
	}
	/*
	 * 모집상태별 게시글 개수
	 */
	@Override
	public int selectStatusCount(int tbStatus) throws Exception {
		return tripBoardDao.selectStatusCount(tbStatus);
	}
	/*
	 * 지역별 게시글 개수
	 */
	@Override
	public int selectCityNoCount(int cityNo) throws Exception {
		return tripBoardDao.selectCityNoCount(cityNo);
	}
	/*
	 * 해시태그별 게시글 개수
	 */
	@Override
	public int selectHashtagCount(String tbHashtag) throws Exception {
		return tripBoardDao.selectHashtagCount(tbHashtag);
	}
	
	/*
	 * 게시글 조회수 1 증가
	 */
	@Override
	public int increaseTbReadCount(int tBoNo) throws Exception {
		return tripBoardDao.increaseTbReadCount(tBoNo);
	}
	/*
	 * 키워드로 검색된 동행게시판 리스트
	 */
	@Override
	public List<TripBoard> selectSearchTbList(String keyword) throws Exception {
		return tripBoardDao.selectSearchTbList(keyword);
	}
	
	/*
	 * 검색된 게시글 총 개수
	 */
	@Override
	public int selectTbSearchCount(String tbKeyword) throws Exception {
		return tripBoardDao.selectTbSearchCount(tbKeyword);
	}
	
	/*
	 * 게시글 1개 조회 + City 정보
	 */
	@Override
	public TripBoard selectCityInfo(int tBoNo) throws Exception {
		return tripBoardDao.selectCityInfo(tBoNo);
	}
	
	/*
	 * 게시글리스트 조회 + City 정보
	 */
	@Override
	public List<TripBoard> selectAllByCityNo() throws Exception {
		return tripBoardDao.selectAllByCityNo();
	}
	
}
