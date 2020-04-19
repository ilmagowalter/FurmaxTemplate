package it.furmax.template.controller;

import java.sql.Timestamp;
import java.time.Instant;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.commons.lang3.Validate;
import org.jboss.logging.Logger;

import io.swagger.model.Utente;
import io.swagger.model.UtentiPaginati;
import it.furmax.template.converter.UserConverter;
import it.furmax.template.exception.EmailAlreadyExistsException;
import it.furmax.template.exception.UserNotFoundException;
import it.furmax.template.exception.UsernameAlreadyExistsException;
import it.furmax.template.model.AnaUser;
import it.furmax.template.repository.PaginatedResult;
import it.furmax.template.repository.UserRepository;

@Stateless
public class UserController extends AbstractController {

	private static Logger log = Logger.getLogger(UserController.class.getName());

	@Inject
	private UserRepository userRepository;

	private UserConverter converter = new UserConverter();

	public UtentiPaginati list(final Long pageSize, final Long pageNumber) {
		log.debug("list - start");
		final Long size = limitPageSize(pageSize);
		PaginatedResult<AnaUser> res = userRepository.findPaginated(size, pageNumber);
		log.debug("lista - end");
		return converter.toUtentiPaginati(res);
	}

	public Utente create(final Utente utente, final Long userId)
			throws UsernameAlreadyExistsException, EmailAlreadyExistsException {
		log.debug("create - start");
		final Timestamp now = Timestamp.from(Instant.now());
		Validate.notNull(utente);
		Validate.notNull(utente.getNomeUtente());
		Validate.notNull(utente.getEmail());
		Validate.notNull(utente.getNome());
		Validate.notNull(utente.getCognome());
		Validate.notNull(utente.isAbilitato());
		// check if exist given email
		checkExists(utente);
		AnaUser user = new AnaUser();
		user.setUsername(utente.getNomeUtente());
		user.setEmail(utente.getEmail());
		user.setFirstname(utente.getNome());
		user.setLastname(utente.getCognome());
		user.setPhone(utente.getTelefono());
		user.setPassword(utente.getNomeUtente());
		user.setEnabled(utente.isAbilitato());
		user.setVersion(1L);
		user.setInsertTime(now);
		user.setUpdateTime(now);
		user.setIdUserInsert(userId);
		user.setIdUserUpdate(userId);
		user = userRepository.save(user);
		log.debug("create - end");
		return converter.toUtente(user);
	}

	public Utente modify(final Long idUtente, final Utente utente, final Long userId)
			throws EmailAlreadyExistsException, UsernameAlreadyExistsException, UserNotFoundException {
		log.debug("modify - start");
		final Timestamp now = Timestamp.from(Instant.now());
		Validate.notNull(idUtente);
		Validate.notNull(utente);
		Validate.notNull(utente.getNomeUtente());
		Validate.notNull(utente.getEmail());
		Validate.notNull(utente.getNome());
		Validate.notNull(utente.getCognome());
		Validate.notNull(utente.isAbilitato());
		AnaUser userToModify = userRepository.findById(idUtente);
		// check if exist given email
		checkExists(utente);
		if (userToModify == null) {
			throw new UserNotFoundException(idUtente);
		}
		userToModify.setVersion(userToModify.getVersion() + 1);
		userToModify.setUpdateTime(now);
		userToModify.setIdUserUpdate(userId);
		userToModify.setEmail(utente.getEmail());
		userToModify.setFirstname(utente.getNome());
		userToModify.setLastname(utente.getCognome());
		userToModify.setPhone(utente.getTelefono());
		userToModify.setEnabled(utente.isAbilitato());
		userToModify = userRepository.save(userToModify);
		log.debug("modify - end");
		return converter.toUtente(userToModify);
	}

	private void checkExists(Utente utente) throws EmailAlreadyExistsException, UsernameAlreadyExistsException {
		// check if exist given username
		if (userRepository.existUsername(utente)) {
			log.error("there is another user with username " + utente.getNomeUtente());
			throw new UsernameAlreadyExistsException(utente.getNomeUtente());
		}
		// check if exist given email
		if (userRepository.existEmail(utente)) {
			log.error("there is another user with emanil " + utente.getEmail());
			throw new EmailAlreadyExistsException(utente.getEmail());
		}

	}

	public AnaUser findById(final Long id) {
		Validate.notNull(id);
		return userRepository.findById(id);
	}

}
