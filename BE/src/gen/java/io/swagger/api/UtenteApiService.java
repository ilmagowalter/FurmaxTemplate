package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;


import io.swagger.model.ErroreGenerico;
import io.swagger.model.Utente;
import io.swagger.model.UtentiPaginati;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;


public interface UtenteApiService {
      Response utenteGet(Long pageSize,Long pageNumber,SecurityContext securityContext)
      throws NotFoundException;
      Response utenteIdUtentePut(Long idUtente,Utente utente,SecurityContext securityContext)
      throws NotFoundException;
      Response utentePost(Utente utenti,SecurityContext securityContext)
      throws NotFoundException;
}
