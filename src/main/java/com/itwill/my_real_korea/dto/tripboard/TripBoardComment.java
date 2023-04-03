package com.itwill.my_real_korea.dto.tripboard;

import java.util.Date;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripBoardComment {

	private int tCoNo;
	private String tCommentContent;
	private Date tCommentDate;
	private int tBoNo;
	private String userId;
}
