package com.itwill.my_real_korea.service.freeboard;

import com.itwill.my_real_korea.dto.City;
import com.itwill.my_real_korea.dto.freeboard.FreeBoard;
import com.itwill.my_real_korea.util.PageMakerDto;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@MapperScan(basePackages = "com.itwill.my_real_korea.mapper")
class FreeBoardServiceImplTest {

    @Autowired
    private FreeBoardService freeBoardService;

    @Disabled
    @Test
    void insert() throws Exception {
        FreeBoard freeBoard = new FreeBoard(
                2, "질문있습니다"
                , "어디로가야하나요", null
                , 0
                , new City(3, "강원", 3, 3)
                , "user1");
        int insert = freeBoardService.insertBoard(freeBoard);
        assertThat(insert).isEqualTo(1);
    }

    @Disabled
    @Test
    void update() throws Exception {
        FreeBoard updateFreeBoard = new FreeBoard(
                2, "3수정테스트"
                , "유럽여행 어디로 갈까요", null
                , 0, new City(1, "서울", 10, 10), "user2");
        freeBoardService.updateFreeBoard(updateFreeBoard);
    }

    @Disabled
    @Test
    void delete() throws Exception {
        int deleteFreeBoard = freeBoardService.deleteFreeBoard(6);
        assertThat(deleteFreeBoard).isEqualTo(1);
    }
    @Disabled
    @Test
    void selectByNo() throws Exception {
        FreeBoard freeBoard = freeBoardService.selectByNo(3);
        System.out.println(freeBoard);
    }
    @Disabled
    @Test
    void increaseReadCount() throws Exception {
        int increaseReadCount = freeBoardService.increaseReadCount(2);
        assertThat(increaseReadCount).isEqualTo(1);
    }
    @Disabled
    @Test
    void selectFreeBoardCount() throws Exception {
        int count = freeBoardService.selectFreeBoardCount();
        System.out.println("count = " + count);
    }
    @Disabled
    @Test
    void selectSearchCount() throws Exception {
        int searchCount = freeBoardService.selectSearchCount("맛집");
        System.out.println("searchCount = " + searchCount);
    }
    @Disabled
    @Test
    void getTitleString() throws Exception {
        FreeBoard freeBoard = new FreeBoard(
                2, "12345678901234567"
                , "유럽여행 어디로 갈까요", null
                , 0, new City(1, "seoul", 13, 13), "id2");
        String titleString = freeBoardService.getTitleString(freeBoard);
        System.out.println("titleString = " + titleString);
    }


    @Test
    void selectSearchFreeBoardList() throws Exception {
        PageMakerDto<FreeBoard> freeBoardPageMakerDto =
                freeBoardService.selectSearchFreeBoardList(1, "맛집");
        System.out.println("PageMakerDto = " + freeBoardPageMakerDto);
    }
    @Disabled
    @Test
    void selectAllOrderByFBoNoDesc() throws Exception {
        PageMakerDto<FreeBoard> freeBoardListPageMakerDto = freeBoardService.selectAllOrderByFBoNoDesc(1);
        System.out.println("freeBoardListPageMakerDto = " + freeBoardListPageMakerDto);
    }
    @Disabled
    @Test
    void selectAllOrderByFBoNoAsc() throws Exception {
       PageMakerDto<FreeBoard> freeBoardListPageMakerDto = freeBoardService.selectAllOrderByFBoNoAsc(1);
        System.out.println("freeBoardListPageMakerDto = " + freeBoardListPageMakerDto);
    }

    @Disabled
    @Test
    void selectAllOrderByReadCountDesc() throws Exception {
        PageMakerDto<FreeBoard> freeBoardListPageMakerDto = freeBoardService.selectAllOrderByReadCountDesc(1);
        System.out.println("freeBoardListPageMakerDto = " + freeBoardListPageMakerDto);
    }


}