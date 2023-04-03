package com.itwill.my_real_korea.dto.user;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	private String userId;
	private String password;
	private String name;
	private String nickname;
	private String phone;
	private String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birth;
	private String address;
	private int gender;
	private int point;
	private int isAdmin;
	private int mailAuth;
	private int mailKey;
	private UserAddInfo userAddInfo;
	private UserImg userImg;
	public User(String userId, String password, String name, String nickname, String phone, String email, Date birth,
			String address, int gender, int point, int isAdmin, int mailAuth, int mailKey) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
		this.phone = phone;
		this.email = email;
		this.birth = birth;
		this.address = address;
		this.gender = gender;
		this.point = point;
		this.isAdmin = isAdmin;
		this.mailAuth = mailAuth;
		this.mailKey = mailKey;
	}
	
	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

