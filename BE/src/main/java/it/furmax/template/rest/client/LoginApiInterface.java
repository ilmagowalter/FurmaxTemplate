package it.furmax.template.rest.client;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import io.swagger.annotations.ApiParam;
import io.swagger.api.NotFoundException;
import io.swagger.model.Autenticazione;
import io.swagger.model.ErroreGenerico;
import io.swagger.model.InformazioniAccesso;

@Path("/login")

@io.swagger.annotations.Api(description = "the login API")

public interface LoginApiInterface {

	@POST
	@Path("/")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	@io.swagger.annotations.ApiOperation(value = "effettua il login", notes = "valida le credenziali fornite ed effettua l'accesso, ritornando la apiKey da utilizzare nelle altre chiamate", response = InformazioniAccesso.class, tags = {
			"login", })
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "successo, token di autenticazione", response = InformazioniAccesso.class),

			@io.swagger.annotations.ApiResponse(code = 400, message = "errore di autenticazione", response = ErroreGenerico.class) })
	public Response loginPost(@ApiParam(value = "", required = true) Autenticazione autenticazione)
			throws NotFoundException;
}
