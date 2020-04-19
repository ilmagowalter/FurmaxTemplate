package it.furmax.template.rest;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;

import org.jboss.logging.Logger;

import io.swagger.model.ErroreGenerico;
import io.swagger.model.RispostaGenerica;
import it.furmax.template.MessageConstants;
import it.furmax.template.controller.MessageController;
import it.furmax.template.controller.UserController;
import it.furmax.template.model.AnaUser;

public abstract class BaseApiServiceImpl {

	private static Logger log = Logger.getLogger(BaseApiServiceImpl.class.getName());

	@Inject
	private MessageController messageController;

	@Inject
	private UserController userController;

	/**
	 * @param securityContext
	 * @return userId from securityContext, null if error
	 */
	protected Long getUserId(final SecurityContext securityContext) {
		if (securityContext != null && securityContext.getUserPrincipal() != null) {
			return Long.valueOf(securityContext.getUserPrincipal().getName());
		}
		return null;
	}

	/**
	 * @param securityContext
	 * @return {@link AnaUser} from securityContext, null if error
	 */
	protected AnaUser getUser(final SecurityContext securityContext) {
		if (securityContext != null && securityContext.getUserPrincipal() != null) {
			Long id = Long.valueOf(securityContext.getUserPrincipal().getName());
			return userController.findById(id);
		}
		return null;
	}

	protected Response buildRispostaGenerica(final String code) {
		RispostaGenerica rg = new RispostaGenerica();
		rg.setCodice(code);
		rg.setDescrizione(messageController.getMessage(code));
		return Response.ok().entity(rg).build();
	}

	protected Response buildRispostaGenerica(final String code, final String description) {
		RispostaGenerica rg = new RispostaGenerica();
		rg.setCodice(code);
		rg.setDescrizione(messageController.getMessage(code) + description);
		return Response.ok().entity(rg).build();
	}

	/**
	 * Build a Response with {@link ErroreGenerico} and httpCode Status.BAD_REQUEST
	 * 
	 * @param codeMessage
	 * @param description
	 * @return {@link Response} with provided information
	 */
	protected Response buildErroreGenericoBadRequest(final String codeMessage, final String description) {
		ErroreGenerico eg = new ErroreGenerico();
		eg.setCodice("" + Status.BAD_REQUEST.getStatusCode());
		eg.setCodiceErrore(codeMessage);
		String msg = messageController.getMessage(codeMessage);
		if (msg != null) {
			eg.setDescrizione(msg + description);
		} else {
			eg.setDescrizione(description);
		}
		return Response.status(Status.BAD_REQUEST).entity(eg).build();
	}

	/**
	 * Build a Response with {@link ErroreGenerico} and httpCode
	 * Status.INTERNAL_SERVER_ERROR
	 * 
	 * @return {@link Response} with provided information
	 */
	protected Response buildErroreGenericoInternalError() {
		return buildErroreGenericoInternalError(MessageConstants.ERROR_CODE_GENERIC,
				messageController.getMessage(MessageConstants.ERROR_CODE_GENERIC));
	}

	protected Response buildErroreGenericoInternalError(final String errorCode, final String msg) {
		ErroreGenerico eg = new ErroreGenerico();
		eg.setCodice("" + Status.INTERNAL_SERVER_ERROR.getStatusCode());
		eg.setCodiceErrore(errorCode);
		eg.setDescrizione(msg);
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(eg).build();
	}

	protected Response buildErroreGenericoInternalError(final String code) {
		RispostaGenerica rg = new RispostaGenerica();
		rg.setCodice(code);
		rg.setDescrizione(messageController.getMessage(code));
		return Response.ok().entity(rg).build();
	}

	protected Response buildNotAuthorized() {
		ErroreGenerico eg = new ErroreGenerico();
		eg.setCodice("" + Response.Status.UNAUTHORIZED.getStatusCode());
		eg.setCodiceErrore(MessageConstants.USER_NOT_AUTHORIZED);
		eg.setDescrizione(messageController.getMessage(MessageConstants.USER_NOT_AUTHORIZED));
		return Response.status(Response.Status.UNAUTHORIZED).entity(eg).build();
	}

	protected ErroreGenerico buildOnlyErroreGenericoBadRequest(final String codeMessage, final String description) {
		ErroreGenerico eg = new ErroreGenerico();
		eg.setCodice("" + Status.BAD_REQUEST.getStatusCode());
		eg.setCodiceErrore(codeMessage);
		String msg = messageController.getMessage(codeMessage);
		if (msg != null) {
			eg.setDescrizione(msg + description);
		} else {
			eg.setDescrizione(description);
		}
		return eg;
	}

}
