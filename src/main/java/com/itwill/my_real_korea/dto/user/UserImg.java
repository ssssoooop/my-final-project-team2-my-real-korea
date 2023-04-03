package com.itwill.my_real_korea.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserImg {
	
	/*
	 * 이름           널?       유형            
------------ -------- ------------- 
user_img_no  NOT NULL NUMBER        
user_img_url NOT NULL VARCHAR2(500) 
user_id               VARCHAR2(50)  
	 */
	
	private int userImgNo;
	private String userImgUrl; 
    private String userId;
    
}
            	