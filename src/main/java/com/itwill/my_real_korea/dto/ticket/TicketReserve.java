package com.itwill.my_real_korea.dto.ticket;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketReserve {

    private int tiRsNo;
    private Date tiRsDate;
    private int tiRsQty;
    private String tiRsMsg;
    private Ticket ticket;
    private String userId;
}
