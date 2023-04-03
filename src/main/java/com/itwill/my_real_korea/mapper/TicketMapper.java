package com.itwill.my_real_korea.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.my_real_korea.dto.ticket.Ticket;

@Mapper
public interface TicketMapper {

	//티켓 추가
    int insertTicket (Ticket ticket);

    /**read**/
    // 전체 목록 + 정렬 - 페이징
    List<Ticket> selectAllTicket(Map<String,Object> ticketPageMap);
    // 키워드, 지역, 가격 + 전체 LIST - 페이징 처리
    List<Ticket> selectByTicketAllSort(Map<String, Object> selectMap);
  //상품 상세보기 - 지역 + 사진
    List<Ticket> selectByTicketNoCityWithImg(int tiNo);
    
    /**update**/   
    //티켓 수정
    int updateTicket(Ticket ticket);
    
    /**delete**/
    //티켓 삭제
    int deleteTicket(int tiNo);

    //게시글 수 조회
    int selectAllTicketCount();
    
    //번호로 찾기
	Ticket selectTicketNo(int tiNo);
}


/*
//상품 키워드로 검색
    List<Ticket> selectByKeywordTicket(Map<String, Object> ticketKeywordPageMap);
    //가격 순
    List<Ticket> selectByTicketPrice(Map<String,Object> ticketPriceSortMap );
    //상품 상세보기 - 지역
    List<Ticket> selectByTicketNoCityWithImg(int tiNo);

    //상품 지역별 검색
    List<Ticket> selectByTicketCity(int cityNo);

 */
