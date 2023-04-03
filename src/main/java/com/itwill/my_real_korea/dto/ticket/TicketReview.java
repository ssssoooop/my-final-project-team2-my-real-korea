package com.itwill.my_real_korea.dto.ticket;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketReview {

    private int tiReviewNo;
    private Date tiReviewDate;
    private String tiReviewTitle;
    private String tiReviewContent;
    private String tiReviewImg;
    private int tiNo;
    private String userId;



}
