package com.itwill.my_real_korea.mapper;


import com.itwill.my_real_korea.dto.ticket.TicketImg;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TicketImgMapper {
    //이미지 생성
    int insertTicketImg (TicketImg ticketImg) throws Exception;
    //이미지 출력
    List<TicketImg> selectTicketImgList(int tiNo);
    //이미지 수정
    int updateTicketImg(TicketImg ticketImg);
    //이미지 삭제
    int deleteTicketImg(int tiImgNo);


}
