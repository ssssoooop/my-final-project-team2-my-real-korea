package com.itwill.my_real_korea.service.freeboard;

import com.itwill.my_real_korea.dto.freeboard.FreeBoardComment;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
@SpringBootTest
class FreeBoardCommentServiceImplTest {
    @Autowired
    private FreeBoardCommentService freeBoardCommentService;
    @Test
    void insertComment() throws Exception {
        FreeBoardComment freeBoardComment =
                new FreeBoardComment(3,"답변드립니다",null,2  ,"user1");
        int insertComment = freeBoardCommentService.insertComment(freeBoardComment);
        assertThat(insertComment).isEqualTo(1);
    }

    @Test
    void selectAll() throws Exception {
        List<FreeBoardComment> freeBoardComments = freeBoardCommentService.selectAll();
        System.out.println(freeBoardComments);
    }

    @Test
    void delete() throws Exception {
        int deleteComment = freeBoardCommentService.deleteComment(3);
        assertThat(deleteComment).isEqualTo(1);
    }

    @Test
    void update() throws Exception {
        FreeBoardComment updateFreeBoardComment = new FreeBoardComment
                (2,"백암순대국을 추천합니다",null,2,"user1");
        int i = freeBoardCommentService.updateComment(updateFreeBoardComment);
        assertThat(i).isEqualTo(1);

    }

    @Test
    void commentCount() throws Exception {
        int commentCount = freeBoardCommentService.selectCommentCount(2);
        System.out.println(commentCount);

    }
}