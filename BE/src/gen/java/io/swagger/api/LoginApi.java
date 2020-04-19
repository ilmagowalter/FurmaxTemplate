package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.LoginApiService;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.Autenticazione;
import io.swagger.model.ErroreGenerico;
import io.swagger.model.InformazioniAccesso;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.inject.Inject;

import javax.validation.constraints.*;

@Path("/login")


@io.swagger.annotations.Api(description = "the login API")

public class LoginApi  {

    @Inject LoginApiService service;

    @POST
    @Path("/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Effettua il login", notes = "Valida le credenziali fornite ed effettua l'accesso, ritornando la apiKey da utilizzare nelle altre chiamate", response = InformazioniAccesso.class, tags={ "login", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successo, token di autenticazione", response = InformazioniAccesso.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "errore di autenticazione", response = ErroreGenerico.class) })
    public Response loginPost(@ApiParam(value = "" ,required=true) Autenticazione autenticazione,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.loginPost(autenticazione,securityContext);
    }
}
