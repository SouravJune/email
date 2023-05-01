package com.spring_email.service;

import java.io.IOException;

import com.spring_email.request.EmailerRequest;

import jakarta.mail.MessagingException;

public interface EmailService {

	String sendEmail(EmailerRequest emailerRequest);
	String sendEmailWithAttachement(EmailerRequest emailerRequest) throws MessagingException, IllegalStateException, IOException;

}
