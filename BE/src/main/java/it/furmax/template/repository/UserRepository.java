package it.furmax.template.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.metamodel.SingularAttribute;

import org.jboss.logging.Logger;

import io.swagger.model.Utente;
import it.furmax.template.exception.UserNotEnabledException;
import it.furmax.template.exception.UserNotFoundException;
import it.furmax.template.model.AnaUser;
import it.furmax.template.model.AnaUser_;

public class UserRepository extends AbstractRepository<AnaUser> {

	private static Logger log = Logger.getLogger(UserRepository.class.getName());

	public UserRepository() {
		type = AnaUser.class;
	}

	public AnaUser findUserByUserNamePassword(final String username, final String password)
			throws UserNotEnabledException, UserNotFoundException {
		if (username == null || password == null) {
			throw new UserNotFoundException();
		}
		Map<SingularAttribute, Object> fields = new HashMap<>();
		fields.put(AnaUser_.username, username);
		fields.put(AnaUser_.password, password);
		List<AnaUser> users = find(fields);
		if (users == null || users.isEmpty()) {
			throw new UserNotFoundException(username);
		}
		AnaUser user = users.get(0);
		if (user.getEnabled() != null && !user.getEnabled()) {
			log.warn("findUserByUserNamePassword - user not enabled, id=" + user.getId());
			throw new UserNotEnabledException(username);
		}
		return user;
	}

	public boolean existUsername(final Utente utente) {
		if (utente == null) {
			return false;
		}
		if (utente.getNomeUtente() == null) {
			return false;
		}
		List<AnaUser> res;
		if (utente.getIdUtente() == null) {
			final String hql = " FROM AnaUser WHERE LOWER(username) = LOWER(:username)";
			res = em.createQuery(hql, AnaUser.class).setParameter("username", utente.getNomeUtente()).getResultList();
		} else {
			final String hql = " FROM AnaUser WHERE LOWER(username) = LOWER(:username) and id <> :userId";
			res = em.createQuery(hql, AnaUser.class).setParameter("username", utente.getNomeUtente())
					.setParameter("userId", utente.getIdUtente()).getResultList();
		}
		return res != null && !res.isEmpty() ? true : false;
	}

	public boolean existEmail(final Utente utente) {
		if (utente == null) {
			return false;
		}
		if (utente.getEmail() == null) {
			return false;
		}
		List<AnaUser> res;
		if (utente.getIdUtente() == null) {
			final String hql = " FROM AnaUser WHERE LOWER(email) = LOWER(:email)";
			res = em.createQuery(hql, AnaUser.class).setParameter("email", utente.getEmail()).getResultList();
		} else {
			final String hql = " FROM AnaUser WHERE LOWER(email) = LOWER(:email) and id <> :userId";
			res = em.createQuery(hql, AnaUser.class).setParameter("email", utente.getEmail())
					.setParameter("userId", utente.getIdUtente()).getResultList();
		}
		return res != null && !res.isEmpty() ? true : false;
	}

}
