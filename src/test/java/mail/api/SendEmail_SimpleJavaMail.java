package mail.api;

import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.MailerBuilder;

public class SendEmail_SimpleJavaMail {

	public static void main(String[] args) {

		Email email = EmailBuilder.startingBlank().from("Marat Metoff", "marat.metoff@gmail.com")
				.to("Tista", "mmetoff@tistatech.com").to("Home", "marat.metoff@gmail.com")
				.withSubject("My Bakery is finally open!")
				.withPlainText("Mom, Dad. We did the opening ceremony of our bakery!!!").buildEmail();

		MailerBuilder.withSMTPServer("smtp.gmail.com", 587, "marat.metoff@gmail.com", "95088114Mm!").buildMailer().sendMail(email);
	}

}
