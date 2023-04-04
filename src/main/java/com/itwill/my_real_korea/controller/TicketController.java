package com.itwill.my_real_korea.controller;

import com.itwill.my_real_korea.dto.ticket.Ticket;
import com.itwill.my_real_korea.service.city.CityService;
import com.itwill.my_real_korea.service.ticket.TicketImgService;
import com.itwill.my_real_korea.service.ticket.TicketService;
import com.itwill.my_real_korea.util.PageMakerDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TicketController {

    TicketService ticketService;
    CityService cityService;
    TicketImgService ticketImgService;

    //test 중
    @Autowired
    public TicketController(TicketService ticketService, CityService cityService,TicketImgService ticketImgService) {
        this.ticketService = ticketService;
        this.cityService = cityService;
        this.ticketImgService = ticketImgService;
    }

    //키워드, 지역별 - 필터 + 가격순, 날짜별 정렬 - 화면에 어떻게 넘길 지 생각하기 ㅠ 
    @ApiOperation(value="티켓리스트")
    @GetMapping(value="/ticketList",  produces="application/json;charset=UTF-8")
    public Map<String, Object> ticketList(@RequestParam int currentPage,
                                         String keyword, int cityNo,  String sortOrder){
        Map<String,Object> ticketMap = new HashMap<>();
        int code = 1;
        String msg = "성공";
        PageMakerDto<Ticket> ticketList = null;
        try{
            ticketList = ticketService.selectByTicketAllSort(currentPage,keyword,cityNo,sortOrder);

            if(ticketList.getTotRecordCount() != 0 && ticketList != null) {
                code = 1;
                msg = "성공";
            } else {
                code = 2;
                msg = "검색 조건에 해당하는 결과가 없습니다.";
            }
        } catch (Exception e){
            e.printStackTrace();
            code = 3;
            msg = "오류";
        }
        
        ticketMap.put("code", code);
        ticketMap.put("msg", msg);
        ticketMap.put("ticketList", ticketList);
        
        return ticketMap;
    }
}
