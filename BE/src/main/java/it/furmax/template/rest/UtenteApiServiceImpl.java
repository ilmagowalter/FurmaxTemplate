package it.furmax.template.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.jboss.logging.Logger;

import io.swagger.api.NotFoundException;
import io.swagger.api.UtenteApiService;
import io.swagger.model.Utente;
import io.swagger.model.UtentiPaginati;
import it.furmax.template.MessageConstants;
import it.furmax.template.controller.UserController;
import it.furmax.template.exception.EmailAlreadyExistsException;
import it.furmax.template.exception.UserNotFoundException;
import it.furmax.template.exception.UsernameAlreadyExistsException;

/**
 * Service implementation for User (utenti) api services
 */
@RequestScoped
public class UtenteApiServiceImpl extends BaseApiServiceImpl implements UtenteApiService {

	private static Logger log = Logger.getLogger(UtenteApiServiceImpl.class.getName());

	@Inject
	private UserController userController;

	@Override
	public Response utenteGet(Long pageSize, Long pageNumber, SecurityContext securityContext)
			throws NotFoundException {
		log.info("utenteGet - start");
		try {
			UtentiPaginati res = userController.list(pageSize, pageNumber);
			log.info("utenteGet - end");
			return Response.ok().entity(res).build();
		} catch (Exception e) {
			log.error("utenteGet - error generic", e);
			return buildErroreGenericoInternalError();
		}
	}

	@Override
	public Response utentePost(Utente utente, SecurityContext securityContext) throws NotFoundException {
		log.info("utentePost - start");
		try {
			Utente res = userController.create(utente, getUserId(securityContext));
			log.info("utentePost - end");
			return Response.ok().entity(res).build();
		} catch (UsernameAlreadyExistsException uae) {
			log.error("utentePost - error - username already exists", uae);
			return buildErroreGenericoBadRequest(MessageConstants.USERNAME_ALREADY_EXISTS, "");
		} catch (EmailAlreadyExistsException eae) {
			log.error("utentePost - error - email already exists", eae);
			return buildErroreGenericoBadRequest(MessageConstants.EMAIL_ALREADY_EXISTS, "");
		} catch (Exception e) {
			log.error("utentePost - error generic", e);
			return buildErroreGenericoInternalError();
		}
	}

	@Override
	public Response utenteIdUtentePut(Long idUtente, Utente utente, SecurityContext securityContext)
			throws NotFoundException {
		log.info("utentePut - start");
		try {
			Utente res = userController.modify(idUtente, utente, getUserId(securityContext));
			log.info("utentePut - end");
			return Response.ok().entity(res).build();
		} catch (UsernameAlreadyExistsException uae) {
			log.error("utentePut - error - username already exists", uae);
			return buildErroreGenericoBadRequest(MessageConstants.USERNAME_ALREADY_EXISTS, "");
		} catch (EmailAlreadyExistsException eae) {
			log.error("utentePut - error - email already exists", eae);
			return buildErroreGenericoBadRequest(MessageConstants.EMAIL_ALREADY_EXISTS, "");
		} catch (UserNotFoundException unf) {
			log.error("utentePut - error - user not found", unf);
			return buildErroreGenericoBadRequest(MessageConstants.USER_NOT_FOUND, unf.getMessage());
		} catch (Exception e) {
			log.error("utentePut - error generic", e);
			return buildErroreGenericoInternalError();
		}
	}

}
