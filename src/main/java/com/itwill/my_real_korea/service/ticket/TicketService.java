package com.itwill.my_real_korea.service.ticket;

import com.itwill.my_real_korea.dto.ticket.Ticket;
import com.itwill.my_real_korea.util.PageMaker;
import com.itwill.my_real_korea.util.PageMakerDto;

import java.util.List;

public interface TicketService {

    // 티켓 생성
    int insertTicket(Ticket ticket) throws Exception;

    // 티켓 리스트
    PageMakerDto<Ticket> selectAllTicket(int currentPage, String sortOrder) throws Exception;

    //키워드, 지역, 가격 + 정렬 - 페이징 처리
    PageMakerDto<Ticket> selectByTicketAllSort(int currentPage, String keyword,
                                                 int cityNo, String sortOrder) throws Exception;

    //상품 상세보기 - 지역 + 사진
    List <Ticket> selectByTicketNoCityWithImg(int tiNo) throws Exception;

    // 상품 번호로 수정
    int updateTicket(Ticket ticket) throws Exception;

    // 티켓 삭제
    int deleteTicket(int tiNo) throws Exception;

    int selectTicketCount() throws Exception;

    
	Ticket selectTicketNo(int tiNo) throws Exception;
	

}
