package com.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.model.Email;

@Service
public class EmailService {

	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmail(Email email)
	{
		try {
			
		MimeMessage mmessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mhelper = new MimeMessageHelper(mmessage);
		
		mhelper.setFrom("swapnilbamble77786@gmail.com");
		mhelper.setTo(email.getTo());
		mhelper.setSubject(email.getSubject());
		mhelper.setText(email.getMessage());
		
		javaMailSender.send(mmessage);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
