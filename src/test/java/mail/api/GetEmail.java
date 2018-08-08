package mail.api;

import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;


 /* 
  *   This class is created to get email content sent from the application in order to make assertion 
  *   whether the email which is sent by the application contains certain content as we expected.
  *   
  *    Note : work is continuing on email attachment... 
  */
public class GetEmail {
	
	/*
	 *  email address and password. Note: email address varies in accordance with mail server
	 *  Note: refer to line emailStore.connect()
	 */
	
	private static final String emailID = "marat.metoff@gmail.com";     // preferred email address
	private static final String emailPassword = "95088114Mm!";         // password of the email
	public static String emailSender ;
	public static String emailSubject;
	public static String emailSentDate;
	
	public static void main(String[] args) {
		/*String*/ Object content = getEmailContent(emailID, emailPassword);
		System.out.println(content.toString());
		System.out.println("Email is from : " + emailSender);
		System.out.println("Email subject is : "+ emailSubject);
		System.out.println("Email sent-date : "+ emailSentDate);
	}
	
	public static /*String*/ Object getEmailContent(String emailID, String emailPassword){
		/*String*/ Object body= "";
		try {
			// set properties for IMAP email server protocol
			Properties properties = new Properties();
			properties.setProperty("mail.store.protocol", "imaps");
			// create session for connection to the mail server and pass the default properties
			Session emailSession = Session.getDefaultInstance(properties);
			// create Store for IMAP protocol
			Store emailStore  = emailSession.getStore("imaps");
			// connect to the mail server as user preferences. 
			// Note: for GMAIL mail server: "imap.gmail.com" . for OUTLOOK mail server: "imap-mail.outlook.com"
			emailStore.connect("imap.gmail.com", emailID, emailPassword);
			// create folder instance get the inbox folder 
			Folder emailFolder = emailStore.getFolder("Inbox");
			// open folder as Read_only
			emailFolder.open(Folder.READ_ONLY);
			// create message instance for the message we want
			// in this case I want to get the first message in the inbox
			Message messages[] = emailFolder.getMessages();
		
			for (int i = messages.length-1; i < messages.length; i++) {
				Message message = messages[i];
				// get the sender, subject and the sent date
				emailSender = message.getFrom()[0].toString();
				emailSubject = message.getSubject();
				emailSentDate= message.getSentDate().toString();
	
				// create object for email content
				Object emailContentObject = message.getContent();
//				// break the email content into multi_part. Note: need some research on this.
//			    Multipart part = (Multipart) emailContentObject;
//			    // get the first bodyPart of the email content. Note: need some research on this.
//			    BodyPart bodyPart = part.getBodyPart(0);
//			    // get the bodyPart and turn in into readable string.
//				body = bodyPart.getContent().toString();
				body = /*(String)*/ message.getContent();

			}
			// close the folder and store 
			emailFolder.close(false);
			emailStore.close();
			
		} catch (NoSuchProviderException nspe) {
			nspe.printStackTrace();
		}catch (MessagingException me) {
			me.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return body;
	}
	
	
}
