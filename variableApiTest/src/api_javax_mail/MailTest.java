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
//      String myMail = "ckemrfla2@naver.com";	//���� �޴� ���
//      String host     = "smtp.naver.com";		// ���̹� ���� ����
//      final String user   = "d----____----b@naver.com";		//���� ������ ����� �����ּ�
//      final String password  = "qlalfqjs5";					//���� ������ ����� ���Ϻ��
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
//         message.setSubject(myMail+"�Կ��� �����׽�Ʈ");
//         Date d = new Date();
//         d.getTime();
//         SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��");
//         // Text
//         message.setText(sdf.format(d)+"�� "+myMail+"�� ������ �����ý��ϴ�.");
//         
//         // send the message
//         Transport.send(message);
//         System.out.println("���� ������ �Ϸ�.");
//         
//      } catch (MessagingException e) {
//         e.printStackTrace();
//      } 
      
   }
}




