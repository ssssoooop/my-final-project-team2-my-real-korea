package com.itwill.my_real_korea.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
이름        널?       유형           
--------- -------- ------------ 
CITY_NO   NOT NULL NUMBER       
CITY_NAME NOT NULL VARCHAR2(50) 
LATITUDE  NOT NULL NUMBER       
LONGITUDE NOT NULL NUMBER 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {
	private int cityNo;
	private String cityName;
	private long latitude;
	private long longitude;
}
