package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.UtenteApiService;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.ErroreGenerico;
import io.swagger.model.Utente;
import io.swagger.model.UtentiPaginati;

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

@Path("/utente")


@io.swagger.annotations.Api(description = "the utente API")

public class UtenteApi  {

    @Inject UtenteApiService service;

    @GET
    @Path("/")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "ricerca all'interno degli utenti utenti", notes = "ritorna l'elenco degli utenti, paginato e filtrato secondo input", response = UtentiPaginati.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "APIKeyHeader")
    }, tags={ "utenti", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "elenco degli utenti", response = UtentiPaginati.class) })
    public Response utenteGet( @Min(1) @Max(300)  @DefaultValue("20") @QueryParam("pageSize") Long pageSize, @Min(1)  @DefaultValue("1") @QueryParam("pageNumber") Long pageNumber,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.utenteGet(pageSize,pageNumber,securityContext);
    }
    @PUT
    @Path("/{idUtente}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "modifica un utente esistente", notes = "modifica un utente esistente", response = Utente.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "APIKeyHeader")
    }, tags={ "utenti", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "utente salvato in banca dati", response = Utente.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "input non valido", response = ErroreGenerico.class) })
    public Response utenteIdUtentePut( @Min(0) @PathParam("idUtente") Long idUtente,@ApiParam(value = "dettagli dell'utente da modificare" ,required=true) Utente utente,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.utenteIdUtentePut(idUtente,utente,securityContext);
    }
    @POST
    @Path("/")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "crea un utente", notes = "crea un utente", response = Utente.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "APIKeyHeader")
    }, tags={ "utenti", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "utente salvato in banca dati", response = Utente.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "input non valido", response = ErroreGenerico.class) })
    public Response utentePost(@ApiParam(value = "utenti da creare" ,required=true) Utente utenti,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.utentePost(utenti,securityContext);
    }
}
