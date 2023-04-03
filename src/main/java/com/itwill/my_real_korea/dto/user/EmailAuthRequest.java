package com.itwill.my_real_korea.dto.user;

import com.itwill.my_real_korea.controller.NotEmpty;

import lombok.Data;

@Data
public class EmailAuthRequest {

    @NotEmpty(message = "이메일을 입력해주세요")
    public String email;
}