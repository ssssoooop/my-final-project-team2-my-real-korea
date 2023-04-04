package com.itwill.my_real_korea.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class Payment {

    private int pNo;
    private int pPrice;
    private int pQty;
    private Date pDate;
    private int pPoint;
    private int pMethod;

    private int ticketRsNo;
    private int tourRsNo;
    private String userId;


}
