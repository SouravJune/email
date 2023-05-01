package com.spring_email.request;

import org.springframework.web.multipart.MultipartFile;

public class EmailerRequest {

	private String to; 

	private String emailSubject;
	
	private String emailBody;

	private MultipartFile attachement;
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getEmailSubject() {
		return emailSubject;
	}
	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}
	public String getEmailBody() {
		return emailBody;
	}
	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}
	
	public MultipartFile getAttachement() {
		return attachement;
	}
	public void setAttacement(MultipartFile attachement) {
		this.attachement = attachement;
	}
	public EmailerRequest(String to, String emailSubject, String emailBody) {
		super();
		this.to = to;
		this.emailSubject = emailSubject;
		this.emailBody = emailBody;
	}
	public EmailerRequest() {
		super();
	}
}
