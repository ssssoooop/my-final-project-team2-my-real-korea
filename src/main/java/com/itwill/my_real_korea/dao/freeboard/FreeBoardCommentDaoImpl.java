package com.itwill.my_real_korea.dao.freeboard;

import com.itwill.my_real_korea.dto.freeboard.FreeBoardComment;
import com.itwill.my_real_korea.mapper.FreeBoardCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class FreeBoardCommentDaoImpl implements FreeBoardCommentDao{
    @Autowired
    private FreeBoardCommentMapper freeBoardCommentMapper;
    @Override
    public int insertComment(FreeBoardComment freeBoardComment) throws Exception {
        return freeBoardCommentMapper.insertComment(freeBoardComment);
    }


    @Override
    public List<FreeBoardComment> selectAll() throws Exception {
        return freeBoardCommentMapper.selectAll();
    }

    @Override
    public int deleteComment(int fCommentNo) throws Exception {
        return freeBoardCommentMapper.deleteComment(fCommentNo);
    }



    @Override
    public int updateComment(FreeBoardComment freeBoardComment) throws Exception {
        return freeBoardCommentMapper.updateComment(freeBoardComment);
    }

    @Override
    public int selectCommentCount(int fBoNo) throws Exception {
        return freeBoardCommentMapper.selectCommentCount(fBoNo);
    }


}
