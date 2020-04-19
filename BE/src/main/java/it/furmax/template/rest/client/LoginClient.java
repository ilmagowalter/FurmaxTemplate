package it.furmax.template.rest.client;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;

import io.swagger.api.ApiException;
import io.swagger.model.Autenticazione;
import io.swagger.model.InformazioniAccesso;

public final class LoginClient extends AbstractClient {

	public LoginClient(final String host) {
		super(host, "/login");
	}

	/**
	 * effettua il login
	 *
	 * valida le credenziali fornite ed effettua l&#39;accesso, ritornando la apiKey
	 * da utilizzare nelle altre chiamate
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws IOException
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	public InformazioniAccesso loginPost(String username, String password)
			throws IOException, ClientProtocolException, HttpResponseException {
		Autenticazione autenticazione = new Autenticazione();
		autenticazione.setUsername(username);
		autenticazione.setPassword(password);
		return (InformazioniAccesso) post(autenticazione, InformazioniAccesso.class);
	}

}
