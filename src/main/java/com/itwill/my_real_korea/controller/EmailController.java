package com.itwill.my_real_korea.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.my_real_korea.dto.user.EmailAuthRequest;
import com.itwill.my_real_korea.service.user.EmailService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @ApiOperation(value = "이메일 인증번호 (구글)")
    @PostMapping(value = "email_auth_success", produces = "application/json;charset=UTF-8")
    public String mailConfirm(@RequestBody EmailAuthRequest emailDto) throws MessagingException, UnsupportedEncodingException {

        emailService.sendEmail(emailDto.getEmail());
        return "email_auth_success";
    }

	
	
}