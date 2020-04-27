package com.sgic.internal.login.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

	@SuppressWarnings("unused")
	private JavaMailSender javaMailSender;
	
	@Autowired
	public NotificationService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendNotofication(SimpleMailMessage mail) throws MailException {
		
		//Send Mail
		
//		cc
//		mail.setTo(employee.getEmail());
//		mail.setSubject("Hello "+employee.getFirstname()+" this your password :"+employee.getName());
//		mail.setText("This is a cool email notification");
		
		javaMailSender.send(mail);
	}
}
