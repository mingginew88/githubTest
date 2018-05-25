package api_javax_mail;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;



public class MailTest {
   public static void main(String[] args) {
//      String myMail = "ckemrfla2@naver.com";	//메일 받는 사람
//      String host     = "smtp.naver.com";		// 네이버 내에 설정
//      final String user   = "d----____----b@naver.com";		//메일 보내는 사람의 메일주소
//      final String password  = "qlalfqjs5";					//메일 보내는 사람의 메일비번
//      
//      // Get the session object
//      Properties props = new Properties();
//      props.put("mail.smtp.host", host);
//      props.put("mail.smtp.auth", "true");
//      
//      Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
//         protected PasswordAuthentication getPasswordAuthentication() {
//            return new PasswordAuthentication(user, password);
//         }
//      });
//      
//      // Compose the message
//      try {
//         MimeMessage message = new MimeMessage(session);
//         message.setFrom(new InternetAddress(user));
//         message.addRecipient(Message.RecipientType.TO, new InternetAddress(myMail));
//         
//         // Subject
//         message.setSubject(myMail+"님에게 메일테스트");
//         Date d = new Date();
//         d.getTime();
//         SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
//         // Text
//         message.setText(sdf.format(d)+"에 "+myMail+"로 메일을 보내봤습니다.");
//         
//         // send the message
//         Transport.send(message);
//         System.out.println("메일 보내기 완료.");
//         
//      } catch (MessagingException e) {
//         e.printStackTrace();
//      } 
      
   }
}




