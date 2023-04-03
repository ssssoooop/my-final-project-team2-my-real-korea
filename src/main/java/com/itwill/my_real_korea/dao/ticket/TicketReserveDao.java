package com.itwill.my_real_korea.dao.ticket;

import java.util.List;

import com.itwill.my_real_korea.dto.ticket.TicketReserve;

public interface TicketReserveDao {

    //예약 생성
    int insertTicketReserve (TicketReserve ticketReserve) throws Exception;

    //내 예약 조회
    List<TicketReserve> selectByTicketReserveUser (String userId) throws Exception;
    //예약 상세보기
    List<TicketReserve> selectByTicketReserveNo (int tiRsNo) throws Exception;

    //예약 삭제
    int deleteTicketReserve(int tiRsNo) throws Exception;

    //티켓예약 상세보기 - 번호 + 아이디
    TicketReserve selectTicketReserveTest(int tiRsNo) throws Exception;





}
