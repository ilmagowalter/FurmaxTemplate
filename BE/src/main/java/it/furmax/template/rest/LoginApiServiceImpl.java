package it.furmax.template.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.jboss.logging.Logger;

import io.swagger.api.LoginApiService;
import io.swagger.api.NotFoundException;
import io.swagger.model.Autenticazione;
import io.swagger.model.InformazioniAccesso;
import it.furmax.template.controller.LoginController;
import it.furmax.template.exception.UserNotEnabledException;
import it.furmax.template.exception.UserNotFoundException;
import it.furmax.template.repository.SystemRepository;
import it.furmax.template.util.auth.JwtManager;

/**
 * Service implementation for Login
 */
@RequestScoped
public class LoginApiServiceImpl extends BaseApiServiceImpl implements LoginApiService {

	private static final String TOKEN_BEARER = "Bearer";

	private static Logger log = Logger.getLogger(LoginApiServiceImpl.class.getName());

	@Inject
	private JwtManager jwtManager;

	@Inject
	private LoginController loginController;

	@Inject
	private SystemRepository systemRepository;

	@Override
	public Response loginPost(Autenticazione autenticazione, SecurityContext securityContext) throws NotFoundException {
		log.info("loginPost - start");
		try {
			InformazioniAccesso ia = loginController.login(autenticazione);
			if (ia == null) {
				log.warn("loginPost - not authorized");
				return buildNotAuthorized();
			}
			String tokenTime = systemRepository.getTokenTime();
			final Integer tokenValidityTime = Integer.valueOf(tokenTime) * 60; // in seconds
			String id = String.valueOf(ia.getUtente().getIdUtente());
			String[] roles = new String[1];
			roles[0] = "rest";
			ia.setToken(jwtManager.createJwt(id, roles, tokenValidityTime));
			ia.setTipoToken(TOKEN_BEARER);
			ia.setScadenza(Long.valueOf(tokenTime));
			log.info("loginPost - end");
			return Response.ok().entity(ia).build();
		} catch (UserNotFoundException unf) {
			log.error("loginPost - user not found for id=" + unf, unf);
			return buildNotAuthorized();
		} catch (UserNotEnabledException une) {
			log.error("loginPost - user not enabled, userId=" + une.getMessage(), une);
			return buildNotAuthorized();
		} catch (Exception e) {
			log.error("loginPost - error during login ", e);
			return buildNotAuthorized();
		}

	}

}
