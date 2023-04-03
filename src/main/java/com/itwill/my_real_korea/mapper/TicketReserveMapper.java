package com.itwill.my_real_korea.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.my_real_korea.dto.ticket.TicketReserve;

@Mapper
public interface TicketReserveMapper {

    //예약 생성
    int insertTicketReserve(TicketReserve ticketReserve);
    // 내 예약 조회
    List<TicketReserve> selectByTicketReserveUser(String userId);
    //예약 상세보기
    List<TicketReserve> selectByTicketReserveNo(int tiRsNo);
    //예약 삭제
    int deleteTicketReserve(int tiRsNo);
}
