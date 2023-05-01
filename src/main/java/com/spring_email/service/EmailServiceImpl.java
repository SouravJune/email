package com.spring_email.service;

import java.io.File;
import java.io.IOException;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring_email.request.EmailerRequest;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService{
	
	private final JavaMailSender javaMailSender;

	public EmailServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Override
	public String sendEmail(EmailerRequest emailerRequest) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(emailerRequest.getTo());
		simpleMailMessage.setSubject(emailerRequest.getEmailSubject());
		simpleMailMessage.setText(emailerRequest.getEmailBody());
		
		javaMailSender.send(simpleMailMessage);
		
		return "Email sent successfully";
	}

	@Override
	public String sendEmailWithAttachement(EmailerRequest emailerRequest) throws MessagingException, IllegalStateException, IOException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true); //true because we will recieve file as multipartfile
		mimeMessageHelper.setTo(emailerRequest.getTo());
		mimeMessageHelper.setSubject(emailerRequest.getEmailSubject());
		mimeMessageHelper.setText(emailerRequest.getEmailBody());
		mimeMessageHelper.addAttachment(emailerRequest.getAttachement().getOriginalFilename(), 
					convertMultipartFile(emailerRequest.getAttachement(), emailerRequest.getAttachement().getOriginalFilename()));

		javaMailSender.send(mimeMessage);
		
		return "Email sent successfully";
		
	}
	
	private File convertMultipartFile(MultipartFile attachement, String fileName) throws IllegalStateException, IOException {
		File convertedFile = new File(System.getProperty("java.io.tmpdir") + "/" + fileName);
		System.out.println("System.getProperty : " + System.getProperty("java.io.tmpdir") + "/" + fileName);
		attachement.transferTo(convertedFile);
		
		return convertedFile;
	}

}
