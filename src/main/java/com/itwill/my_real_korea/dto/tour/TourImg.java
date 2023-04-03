package com.itwill.my_real_korea.dto.tour;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
이름         널?       유형            
---------- -------- ------------- 
TO_IMG_NO  NOT NULL NUMBER        
TO_IMG_URL NOT NULL VARCHAR2(500) 
TO_NO               NUMBER   
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TourImg {
	private int toImgNo;
	private String toImgUrl;
	private int toNo;	//FK
}
