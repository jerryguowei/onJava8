package jerry.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendSimpleMail {
	public static void main(String[] args) {
     String from="jerryguowei@gmai.com";
    String userName="jerryguowei@gmail.com";
    String password= "";
    
    String host = "smtp.gmail.com";

    
    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", host);
    props.put("mail.smtp.port", "587");
    
	Session session = Session.getInstance(props,new Authenticator() {
		protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
			return new javax.mail.PasswordAuthentication(userName, password);
		}
	});
	
	MimeMessage message = new MimeMessage(session);
	 try {
	     message.setFrom(new InternetAddress(from));
	     message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("jevon_8@hotmail.com"));
	     message.setSubject("Test Mail");
	     message.setText("Hello, this is a test mail!");
	     Transport.send(message);
	     System.out.println("Send message successfully");
	} catch (MessagingException e) {
       throw new RuntimeException(e);
	}

    
	}
}
