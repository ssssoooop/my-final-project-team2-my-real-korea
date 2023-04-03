package com.itwill.my_real_korea.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddInfo {
	/*
	 * 이름        널? 유형             
--------- -- -------------- 
introduce    VARCHAR2(1000) 
alcohol      NUMBER         
smoking      NUMBER         
user_id      VARCHAR2(50) 
	 */
	
private String introduce;
private int alcohol;
private int smoking;
private String userId;

}
