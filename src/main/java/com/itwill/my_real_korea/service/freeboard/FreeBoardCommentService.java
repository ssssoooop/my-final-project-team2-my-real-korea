package com.itwill.my_real_korea.service.freeboard;

import com.itwill.my_real_korea.dto.freeboard.FreeBoard;
import com.itwill.my_real_korea.dto.freeboard.FreeBoardComment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FreeBoardCommentService {
    int insertComment(FreeBoardComment freeBoardComment) throws Exception;


    List<FreeBoardComment> selectAll() throws Exception;


    int deleteComment(int fCommentNo) throws Exception;

    int updateComment(FreeBoardComment freeBoardComment) throws Exception;

    int selectCommentCount(int fBoNo) throws Exception;
}
