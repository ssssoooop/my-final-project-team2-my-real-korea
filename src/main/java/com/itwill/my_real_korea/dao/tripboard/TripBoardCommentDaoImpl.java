package com.itwill.my_real_korea.dao.tripboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.my_real_korea.dto.tripboard.TripBoardComment;
import com.itwill.my_real_korea.mapper.TripBoardCommentMapper;

@Repository
public class TripBoardCommentDaoImpl implements TripBoardCommentDao {
	
	@Autowired
	public TripBoardCommentMapper tripBoardCommentMapper;
	
	public TripBoardCommentDaoImpl() {
		System.out.println("TripBoardCommentDaoImpl 기본 생성자 호출");
	}
	
	
	/*
	 * 댓글 추가
	 */
	@Override
	public int insertTripBoardComment(TripBoardComment tripBoardComment) throws Exception {
		return tripBoardCommentMapper.insertTripBoardComment(tripBoardComment);
	}
	
	/*
	 * 댓글 수정
	 */
	@Override
	public int updateTripBoardComment(TripBoardComment tripBoardComment) throws Exception {
		return tripBoardCommentMapper.updateTripBoardComment(tripBoardComment);
	}
	
	/*
	 * 댓글 삭제
	 */
	@Override
	public int deleteTripBoardComment(int tCoNo) throws Exception {
		return tripBoardCommentMapper.deleteTripBoardComment(tCoNo);
	}
	
	/*
	 * 댓글 1개 보기
	 */
	@Override
	public TripBoardComment selectByNo(int tCoNo) throws Exception {
		return tripBoardCommentMapper.selectByNo(tCoNo);
	}
	
	/*
	 * 댓글 리스트
	 */
	@Override
	public List<TripBoardComment> selectAll() throws Exception {
		return tripBoardCommentMapper.selectAll();
	}
	
	/*
	 * 댓글 총 개수
	 */
	@Override
	public int selectAllCount() throws Exception {
		return tripBoardCommentMapper.selectAllCount();
	}
}
