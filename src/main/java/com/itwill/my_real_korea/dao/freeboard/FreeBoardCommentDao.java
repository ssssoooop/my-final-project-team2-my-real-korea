package com.itwill.my_real_korea.dao.freeboard;

import java.util.List;

import com.itwill.my_real_korea.dto.freeboard.FreeBoardComment;
import com.itwill.my_real_korea.dto.freeboard.FreeBoardCommentListPageMakerDto;

public interface FreeBoardCommentDao {


	int insertComment(FreeBoardComment freeBoardComment) throws Exception;


	List<FreeBoardComment> selectAll() throws Exception;


	int deleteComment(int fCommentNo) throws Exception;

	int updateComment(FreeBoardComment freeBoardComment) throws Exception;

	int selectCommentCount(int fBoNo) throws Exception;


	

	
}

