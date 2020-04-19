package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;


import io.swagger.model.Autenticazione;
import io.swagger.model.ErroreGenerico;
import io.swagger.model.InformazioniAccesso;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;


public interface LoginApiService {
      Response loginPost(Autenticazione autenticazione,SecurityContext securityContext)
      throws NotFoundException;
}
