package com.vicky.service;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.vicky.Repository.FeedBackRepository;
import com.vicky.entity.FeedBackEntity;

@Service
public class FeedBackService {

	private String SENDER_EMAIL_ID = "siddhivinayakplatinum@gmail.com";
	private String SENDER_EMAIL_PASS = "Platinum@712";
	private String RECEIVER_EMAIL_ID = "jalaj.purohit@gmail.com";
	
	@Autowired
	FeedBackRepository feedBackRepository;
	
	public String feedbackdetails(String name, String mobileNo, String message) throws Exception {
		
		sendEmail(name,mobileNo,message);
		return feedBackRepository.save(name,mobileNo,message);
	}

	public List<FeedBackEntity> feedbackdetailsFetch() throws Exception {
		return feedBackRepository.fetchAllDetails();
	}
	
	
    private Session getEmailSession(){
       
      Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        return Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(SENDER_EMAIL_ID, SENDER_EMAIL_PASS);
                    }
                });
       
    }
   
   @Async
    public void sendEmail(String name, String mobileNo, String msg){   
        try {
            Session session = getEmailSession();
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(SENDER_EMAIL_ID));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(RECEIVER_EMAIL_ID)
            );
            message.setSubject("Notification from Siddhivinayak Society");
            
            StringBuffer str = new StringBuffer();
            str.append("Name : ").append(name).append("<br>").append("Mobile No : ").append(mobileNo).append("<br>").append("Message : ").append(msg);            
            message.setContent(str.toString(), "text/html; charset=utf-8");
            Transport.send(message);
        } catch (MessagingException e) {
             e.printStackTrace();
        }
    }

 
}
