package it.furmax.template.dto;

public final class EmailParamsDto {

	private final String host;
	private final String port;
	private final String from;
	private String subject;
	private String body;
	private final String user;
	private final String psw;
	private final String authType;
	private final String linkTemplate;
	private final String bodyTaskCompleted;
	private final String smtpTimeout;
	private final String connectionTimeout;

	public EmailParamsDto(final String host, final String port, final String user, final String psw, final String from,
			final String subject, final String body, final String authType, final String linkTemplate,
			final String bodyTaskCompleted, final String smtpTimeout, final String connectionTimeout) {
		this.host = host;
		this.port = port;
		this.user = user;
		this.psw = psw;
		this.from = from;
		this.setSubject(subject);
		this.setBody(body);
		this.authType = authType;
		this.linkTemplate = linkTemplate;
		this.bodyTaskCompleted = bodyTaskCompleted;
		this.smtpTimeout = smtpTimeout;
		this.connectionTimeout = connectionTimeout;
	}

	public EmailParamsDto(final String host, final String port, final String user, final String psw, final String from,
			final String subject, final String body, final String authType, final String smtpTimeout,
			final String connectionTimeout) {
		this.host = host;
		this.port = port;
		this.user = user;
		this.psw = psw;
		this.from = from;
		this.setSubject(subject);
		this.setBody(body);
		this.authType = authType;
		this.linkTemplate = "";
		this.bodyTaskCompleted = "";
		this.smtpTimeout = smtpTimeout;
		this.connectionTimeout = connectionTimeout;
	}

	public String getFrom() {
		return from;
	}

	public String getSubject() {
		return subject;
	}

	public String getBody() {
		return body;
	}

	public String getHost() {
		return host;
	}

	public String getPort() {
		return port;
	}

	public String getUser() {
		return user;
	}

	public String getPsw() {
		return psw;
	}

	public String getAuthType() {
		return authType;
	}

	public String getLinkTemplate() {
		return linkTemplate;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBodyTaskCompleted() {
		return bodyTaskCompleted;
	}

	public String getSmtpTimeout() {
		return smtpTimeout;
	}

	public String getSmtpConnectionTimeout() {
		return connectionTimeout;
	}

}
