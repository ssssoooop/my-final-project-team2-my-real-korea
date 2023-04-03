package com.itwill.my_real_korea.dto.ticket;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.itwill.my_real_korea.dto.City;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class Ticket {

    private int tiNo;
    private String tiTitle;
    private Date tiDate;
    private int tiPrice;
    private String tiInfo;
    private String tiNotice;
    private int tiCount;
    private City city;
    private List<TicketImg> ticketImgList;

    public Ticket(int tiNo, String tiTitle, Date tiDate, int tiPrice, String tiInfo, String tiNotice, int tiCount, City city) {
        this.tiNo = tiNo;
        this.tiTitle = tiTitle;
        this.tiDate = tiDate;
        this.tiPrice = tiPrice;
        this.tiInfo = tiInfo;
        this.tiNotice = tiNotice;
        this.tiCount = tiCount;
        this.city = city;
        this.ticketImgList = new ArrayList<>();
    }
}
