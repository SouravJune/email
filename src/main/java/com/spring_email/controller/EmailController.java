package com.spring_email.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_email.request.EmailerRequest;
import com.spring_email.service.EmailService;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("api/email-service")
public class EmailController {
	
	private final EmailService emailService;

	public EmailController(EmailService emailService) {
		this.emailService = emailService;
	}
	
	@PostMapping("/send-mail")
	public ResponseEntity<String> sendMail(@RequestBody EmailerRequest emailerRequest) {
		return ResponseEntity.ok().body(emailService.sendEmail(emailerRequest));
	}
	
	@PostMapping("/send-mail-with-attachement")
	public ResponseEntity<String> sendMailWithAttachement(@ModelAttribute EmailerRequest emailerRequest) 
					throws IllegalStateException, MessagingException, IOException {
		return ResponseEntity.ok().body(emailService.sendEmailWithAttachement(emailerRequest));
	}
	
	//@RequestBody EmailerRequest emailerRequest emailerRequest
}
