package com.spring_email.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class AppConfig {

	@Value("${spring.mail.host}")
	private String mailHost;
	
	@Value("${spring.mail.port}")
	private String mailPort;
	
	@Value("${spring.mail.username}")
	private String mailUsername;
	
	@Value("${spring.mail.password}")
	private String mailPassword;
	
	@Bean
	JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		javaMailSenderImpl.setHost(mailHost);
		javaMailSenderImpl.setPort(Integer.parseInt(mailPort));
		javaMailSenderImpl.setUsername(mailUsername);
		javaMailSenderImpl.setPassword(mailPassword);
		
		Properties javaMailProperties = javaMailSenderImpl.getJavaMailProperties();
		javaMailProperties.put("mail.smtp.starttls.enable", "true");
		
		return javaMailSenderImpl;
	}
}
