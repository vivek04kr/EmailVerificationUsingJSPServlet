package com.vivek.model;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendingEmail {

	private String userEmail;
	private String myHash;
	
	public SendingEmail(String userEmail, String myHash) {
		this.userEmail = userEmail;
		this.myHash = myHash;
	}
	
	public void sendMail() {
		
		String email = "admin@gmail.com";//Your email here
		String pword = "admin"; //Email Password
		
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, pword);
			}
		});
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));
			message.setSubject("Your Email Verification Link From IndiaTechSoft.com");
			message.setText("Verification Link...");
			message.setText("Your Verification Link ::"+"http://localhost:8088/EmailServletWithVerification/ActivateAccount?key1="+userEmail+"&key2="+myHash);
			Transport.send(message);
			
			
		}catch(Exception ex) {
			System.out.println("SendingEmail...."+ex);
		}
		
	}
	
}
