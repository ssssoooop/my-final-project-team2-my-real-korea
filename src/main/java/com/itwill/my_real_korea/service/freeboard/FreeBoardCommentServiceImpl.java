package com.itwill.my_real_korea.service.freeboard;

import com.itwill.my_real_korea.dao.freeboard.FreeBoardCommentDao;
import com.itwill.my_real_korea.dto.freeboard.FreeBoard;
import com.itwill.my_real_korea.dto.freeboard.FreeBoardComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FreeBoardCommentServiceImpl implements FreeBoardCommentService{
    @Autowired
    private FreeBoardCommentDao freeBoardCommentDao;
    @Override
    public int insertComment(FreeBoardComment freeBoardComment) throws Exception {
        return freeBoardCommentDao.insertComment(freeBoardComment);
    }

    @Override
    public List<FreeBoardComment> selectAll() throws Exception {
        return freeBoardCommentDao.selectAll();
    }

    @Override
    public int deleteComment(int fCommentNo) throws Exception {
        return freeBoardCommentDao.deleteComment(fCommentNo);
    }

    @Override
    public int updateComment(FreeBoardComment freeBoardComment) throws Exception {
        return freeBoardCommentDao.updateComment(freeBoardComment);
    }

    @Override
    public int selectCommentCount(int fCommentNo) throws Exception {
        return freeBoardCommentDao.selectCommentCount(fCommentNo);
    }

}
