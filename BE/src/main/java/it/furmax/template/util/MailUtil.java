package it.furmax.template.util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.jboss.logging.Logger;

import it.furmax.template.dto.EmailParamsDto;

/**
 * Utility class for sending email
 */
public final class MailUtil {

	private static final String TEXT_HTML = "text/html";

	private static Logger log = Logger.getLogger(MailUtil.class.getName());

	private static final String MAIL_SMTP_STARTTLS_ENABLE = "mail.smtp.starttls.enable";
	private static final String SMTP_DEFAULT_PORT = "25";
	private static final String MAIL_SMTP_HOST = "mail.smtp.host";
	private static final String MAIL_SMTP_PORT = "mail.smtp.port";
	private static final String MAIL_SMTP_TIMEOUT = "mail.smtp.timeout";
	private static final String MAIL_SMTP_CONNECTION_TIMEOUT = "mail.smtp.connectiontimeout";
	private static final String AUTH_TLS = "TLS";

	private MailUtil() {
	}

	public static void sendEmail(final EmailParamsDto params, final String emailTo, final String body)
			throws AddressException, MessagingException {
		Validate.notNull(params);
		Validate.notNull(emailTo);
		// build email session
		Properties props = new Properties();
		props.put(MAIL_SMTP_HOST, params.getHost());
		props.put(MAIL_SMTP_PORT, params.getPort() != null ? params.getPort() : Integer.parseInt(SMTP_DEFAULT_PORT));
		// this two parameters must be string
		if (StringUtils.isNotEmpty(params.getSmtpTimeout())) {
			props.put(MAIL_SMTP_TIMEOUT, params.getSmtpTimeout());
		}
		if (StringUtils.isNotEmpty(params.getSmtpConnectionTimeout())) {
			props.put(MAIL_SMTP_CONNECTION_TIMEOUT, params.getSmtpConnectionTimeout());
		}
		if (params.getAuthType() != null && params.getAuthType().equals(AUTH_TLS)) {
			log.info("sendEmail - send using TLS authentication");
			props.put(MAIL_SMTP_STARTTLS_ENABLE, Boolean.toString(true));
		}
		Session session = Session.getInstance(props);

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(params.getFrom()));
		Address toAddress = new InternetAddress(emailTo);
		message.addRecipient(Message.RecipientType.TO, toAddress);
		message.setSubject(params.getSubject());
		message.setContent(body, TEXT_HTML);

		Transport transport = session.getTransport();
		transport.connect();
		if (params.getAuthType().equals(AUTH_TLS)) {
			Transport.send(message, params.getUser(), params.getPsw());
		} else {
			Transport.send(message);
		}
		transport.close();
		log.debug("sendEmail - email sent");
	}

}
