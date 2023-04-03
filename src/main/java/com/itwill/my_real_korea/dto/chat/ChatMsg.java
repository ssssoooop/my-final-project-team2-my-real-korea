package com.itwill.my_real_korea.dto.chat;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 이름            널?       유형            
------------- -------- ------------- 
MSG_NO        NOT NULL NUMBER        
MSG_CONTENT   NOT NULL VARCHAR2(500) 
MSG_SEND_TIME          DATE          
MSG_READ               NUMBER        
ROOM_NO                NUMBER        
USER_ID                VARCHAR2(50)  

 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ChatMsg {

	private int msgNo;
	private String msgContent;
	private Date msgSendTime;
	private int msgRead;
	/* FK */
	private int roomNo;
	/* FK */
	private String userId;
	
}
