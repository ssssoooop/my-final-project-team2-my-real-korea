package com.itwill.my_real_korea.dto.tripboard;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.itwill.my_real_korea.dto.City;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TripBoard {
	private int tBoNo;
	private String tBoTitle;
	private String tBoContent;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date tBoDate;
	private int tBoReadcount;
	private int tBoStatus;
	private int tBoPerson;
	private String tBoImg;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date tBoStartDate;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date tBoEndDate;
	private String tBoStyle;
	private String hashtag;
	//FK
	private City city;
	private String userId;
	
}
