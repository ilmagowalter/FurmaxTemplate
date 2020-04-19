package it.furmax.template.controller;

import java.sql.Timestamp;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import com.itextpdf.styledxmlparser.jsoup.helper.Validate;

import io.swagger.model.Autenticazione;
import io.swagger.model.InformazioniAccesso;
import it.furmax.template.converter.UserConverter;
import it.furmax.template.exception.UserNotEnabledException;
import it.furmax.template.exception.UserNotFoundException;
import it.furmax.template.model.AnaUser;
import it.furmax.template.repository.UserRepository;

@Stateless
public class LoginController {

	private static Logger log = Logger.getLogger(LoginController.class.getName());

	@Inject
	private UserRepository userRepository;

	private UserConverter converter = new UserConverter();

	public InformazioniAccesso login(final Autenticazione autenticazione)
			throws UserNotEnabledException, UserNotFoundException {
		log.debug("login - start");
		final Timestamp now = new Timestamp(System.currentTimeMillis());
		Validate.notNull(autenticazione.getUsername());
		Validate.notNull(autenticazione.getPassword());
		AnaUser user = userRepository.findUserByUserNamePassword(autenticazione.getUsername(),
				autenticazione.getPassword());
		if (user == null) {
			log.debug("login - no user found for username=" + autenticazione.getUsername());
			return null;
		}
		InformazioniAccesso ia = new InformazioniAccesso();
		ia.setUtente(converter.toUtente(user));
		user.setLastConnectTime(now);
		userRepository.save(user);
		log.debug("login - end");
		return ia;
	}

}
