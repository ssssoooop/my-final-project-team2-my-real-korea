package com.itwill.my_real_korea.dto.tour;

import java.util.ArrayList;
import java.util.List;

import com.itwill.my_real_korea.dto.City;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
이름        널?       유형             
--------- -------- -------------- 
TO_NO     NOT NULL NUMBER         
TO_NAME   NOT NULL VARCHAR2(1000) 
TO_TYPE   NOT NULL NUMBER         
TO_TIME   NOT NULL NUMBER         
TO_PERSON NOT NULL NUMBER         
TO_MEET   NOT NULL VARCHAR2(100)  
TO_PRICE  NOT NULL NUMBER         
TO_INFO   NOT NULL VARCHAR2(4000) 
TO_NOTICE NOT NULL VARCHAR2(1000) 
TO_COUNT           NUMBER         
CITY_NO            NUMBER     
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tour {
	private int toNo;
	private String toName;
	private int toType;
	private int toTime;
	private int toPerson;
	private String toMeet;
	private int toPrice;
	private String toInfo;
	private String toNotice;
	private int toCount;
	private City city;		//FK
	
	private List<TourImg> tourImgList;


	public Tour(int toNo, String toName, int toType, int toTime, int toPerson, String toMeet, int toPrice,
			String toInfo, String toNotice, int toCount,City city) {
		super();
		this.toNo = toNo;
		this.toName = toName;
		this.toType = toType;
		this.toTime = toTime;
		this.toPerson = toPerson;
		this.toMeet = toMeet;
		this.toPrice = toPrice;
		this.toInfo = toInfo;
		this.toNotice = toNotice;
		this.toCount = toCount;
		this.city = city;
		this.tourImgList=new ArrayList<TourImg>();
	}
	
	
	
	
}
