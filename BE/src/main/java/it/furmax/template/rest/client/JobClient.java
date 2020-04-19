package it.furmax.template.rest.client;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;

import io.swagger.model.RispostaGenerica;

public final class JobClient extends AbstractClient {

	private String host;
	private String path;

	public JobClient(final String host) {
		this.host = host;
		this.path = "/job";
	}

	public RispostaGenerica jobPost(final String jobId, final String token)
			throws IOException, ClientProtocolException, HttpResponseException {
		init(host, path + "/?idJob=" + jobId);
		return (RispostaGenerica) post(null, RispostaGenerica.class, token);
	}

}
