package com.mindfire.dietplanner.api.util;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 * MailComponent class can be used to send mail to user's email. It is basically
 * used to send HTML formatted diet plan to user's email.
 */
@Component
public class MailComponent {

	@Autowired
	private JavaMailSender mailSender;

	/**
	 * Sends mail with HTML content with specified email address, custom subject and
	 * formatted HTML content.
	 * 
	 * @param {@link
	 * 			String} Receipient's email address
	 * @param {@link
	 * 			String} Subject for mail
	 * @param {@link
	 * 			String} HTML content for mail body
	 * @return {@link Boolean} True if mail is sent, else false.
	 */
	public boolean sendMailWithHtml(String mailTo, String subject, String text) {
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);

			helper.setTo(mailTo);
			helper.setSubject(subject);
			message.setContent(text, "text/html");

			mailSender.send(message);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

}