package com.demo.service1.config;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Configuration
public class MailConfiguration {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(String to) {

		final SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(to);

		msg.setSubject("Testing from Spring Boot");
		msg.setText("Hello World \n Spring Boot Email");

		this.javaMailSender.send(msg);

	}

	public void sendEmailWithAttachment(String to) throws MessagingException, IOException {

		final MimeMessage msg = this.javaMailSender.createMimeMessage();

		// true = multipart message
		final MimeMessageHelper helper = new MimeMessageHelper(msg, true);

		helper.setTo(to);

		helper.setSubject("Testing from Spring Boot");

		// default = text/plain
		// helper.setText("Check attachment for image!");

		// true = text/html
		helper.setText("<h1>Check attachment for image!</h1>", true);

		// hard coded a file path
		// FileSystemResource file = new FileSystemResource(new
		// File("path/android.png"));

		helper.addAttachment("my_photo.png", new ClassPathResource("android.png"));

		this.javaMailSender.send(msg);

	}
}
