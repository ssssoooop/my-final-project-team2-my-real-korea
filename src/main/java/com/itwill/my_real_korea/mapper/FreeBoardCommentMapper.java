package com.itwill.my_real_korea.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.my_real_korea.dto.freeboard.FreeBoardComment;
import com.itwill.my_real_korea.util.PageMakerDto;

@Mapper
public interface FreeBoardCommentMapper {

int insertComment(FreeBoardComment freeBoardComment) throws Exception;


List<FreeBoardComment> selectAll() throws Exception;


int deleteComment(int fCommentNo) throws Exception;

int updateComment(FreeBoardComment freeBoardComment) throws Exception;

int selectCommentCount(int fCommentNo) throws Exception;

}

