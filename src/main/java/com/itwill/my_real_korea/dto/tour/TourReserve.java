package com.itwill.my_real_korea.dto.tour;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
이름              널?       유형             
--------------- -------- -------------- 
TO_RS_NO        NOT NULL NUMBER         
TO_RS_DESC      NOT NULL VARCHAR2(1000) 
TO_RS_START_DAY NOT NULL DATE           
TO_RS_PERSON    NOT NULL NUMBER         
TO_RS_MSG                VARCHAR2(500)  
TO_NO                    NUMBER         
USER_ID                  VARCHAR2(50) 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TourReserve {
	private int toRsNo;
	private Date toRsStartDay;
	private int toRsPerson;
	private String toRsMsg;
	private Tour tour;	//FK
	private String userId;	//FK

}
