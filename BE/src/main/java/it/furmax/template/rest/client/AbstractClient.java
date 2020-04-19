package it.furmax.template.rest.client;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jboss.logging.Logger;
import org.jboss.resteasy.util.HttpResponseCodes;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractClient {

	private static Logger log = Logger.getLogger(LoginClient.class.getName());

	private HttpPost post;
	private CloseableHttpClient client;
	private ObjectMapper objectMapper;

	public AbstractClient() {
	}

	public AbstractClient(final String host, final String path) {
		init(host, path);
	}

	public void init(String host, String path) {
		this.client = HttpClients.createDefault();
		this.post = new HttpPost(host + "/" + path);
		this.post.setHeader("Accept", "application/json");
		this.post.setHeader("Content-type", "application/json");
		this.objectMapper = new ObjectMapper();
	}

	public Object post(Object body, Class responseClass)
			throws IOException, ClientProtocolException, HttpResponseException {
		return post(body, responseClass, null);
	}

	public Object post(Object body, Class responseClass, String token)
			throws IOException, ClientProtocolException, HttpResponseException {
		CloseableHttpResponse response = null;
		try {
			String parsed = objectMapper.writeValueAsString(body);
			post.setEntity(new StringEntity(parsed, ContentType.APPLICATION_JSON));
			if (token != null) {
				post.setHeader("Authorization", "Bearer " + token);
			}
			response = client.execute(post);
			HttpEntity entity = response.getEntity();
			if (response.getStatusLine().getStatusCode() != HttpResponseCodes.SC_OK) {
				throw new HttpResponseException(response.getStatusLine().getStatusCode(),
						response.getStatusLine().getReasonPhrase());
			}
			if (entity == null) {
				throw new ClientProtocolException("Response contains no content");
			}
			return objectMapper.readValue(response.getEntity().getContent(), responseClass);
		} catch (IOException e) {
			log.error("loginPost - error", e);
			return null;
		} finally {
			if (response != null) {
				response.close();
			}
		}
	}

}
