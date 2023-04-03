
package com.itwill.my_real_korea.dao.freeboard;

import com.itwill.my_real_korea.dto.freeboard.FreeBoard;
import com.itwill.my_real_korea.mapper.FreeBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FreeBoardDaoImpl implements FreeBoardDao{

	private FreeBoardMapper freeBoardMapper;

	@Autowired
	public FreeBoardDaoImpl(FreeBoardMapper freeBoardMapper) {
		this.freeBoardMapper = freeBoardMapper;
	}

	@Override
	public int insertBoard(FreeBoard freeBoard) {
		return freeBoardMapper.insertBoard(freeBoard);
	}

	@Override
	public FreeBoard selectByNo(int fBoNo) {
		return freeBoardMapper.selectByNo(fBoNo);
	}

	@Override
	public List<FreeBoard> selectAllOrderByFBoNoDesc(int pageStart, int pageEnd) throws Exception {
		Map<String, Object> pageMap = new HashMap<>();
		pageMap.put("pageStart", pageStart);
		pageMap.put("pageEnd", pageEnd);
		return freeBoardMapper.selectAllOrderByFBoNoDesc(pageMap);
	}

	@Override
	public List<FreeBoard> selectAllOrderByFBoNoAsc(int pageStart, int pageEnd) throws Exception {
		Map<String, Object> pageMap = new HashMap<>();
		pageMap.put("pageStart", pageStart);
		pageMap.put("pageEnd", pageEnd);
		return freeBoardMapper.selectAllOrderByFBoNoAsc(pageMap);
	}

	@Override
	public List<FreeBoard> selectAllOrderByReadCountDesc(int pageStart, int pageEnd) {
		Map<String, Object> pageMap = new HashMap<>();
		pageMap.put("pageStart", pageStart);
		pageMap.put("pageEnd", pageEnd);
		return freeBoardMapper.selectAllOrderByReadCountDesc(pageMap);
	}


//	@Override
//	public List<FreeBoard> selectAllReadCountDesc(int pageStart, int pageEnd) throws Exception {
//		Map<String, Object> pageMap = new HashMap<>();
//		pageMap.put("pageStart", pageStart);
//		pageMap.put("pageEnd", pageEnd);
//		return freeBoardMapper.selectAllReadCountDesc(pageMap);
//	}


	@Override
	public int updateBoard(FreeBoard freeBoard) {
		return freeBoardMapper.updateBoard(freeBoard);
	}

	@Override
	public int deleteBoard(int no) {
		return freeBoardMapper.deleteBoard(no);
	}

	@Override
	public int increaseReadCount(int no) throws Exception {
		return freeBoardMapper.increaseReadCount(no);
	}

	@Override
	public int selectFreeBoardCount() throws Exception {
		return freeBoardMapper.selectFreeBoardCount();
	}

	@Override
	public int selectSearchCount(String keyword) throws Exception {
		return freeBoardMapper.selectSearchCount(keyword);
	}

	@Override
	public List<FreeBoard> selectSearchFreeBoardList(int pageStart, int pageEnd, String keyword) throws Exception {
		Map<String, Object> pageMap = new HashMap<>();
		pageMap.put("pageStart", pageStart);
		pageMap.put("pageEnd", pageEnd);
		pageMap.put("keyword", keyword);
		return freeBoardMapper.selectSearchFreeBoardList(pageMap);
	}

}
