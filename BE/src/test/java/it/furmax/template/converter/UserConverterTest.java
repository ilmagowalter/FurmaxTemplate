package it.furmax.template.converter;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.text.ParseException;
import java.time.Instant;

import org.junit.Test;

import io.swagger.model.Utente;
import io.swagger.model.UtentiPaginati;
import it.furmax.template.converter.UserConverter;
import it.furmax.template.model.AnaUser;
import it.furmax.template.repository.PaginatedResult;

public final class UserConverterTest {

	private static final String EMAIL = "email";
	private static final String FIRSTNAME = "firstname";
	private static final String LASTNAME = "lastname";
	private static final String USERNAME = "username";
	private static final String PHONE = "555-555-555";
	private static final Long LAST_CONNECT_TIME = 1546300800000L;
	private static final Long LAST_CHANGE_PWD = 1546300800000L;
	private UserConverter converter = new UserConverter();

	@Test
	public void nullConvert() {
		assertNotNull(converter.toUtente(null));
	}

	@Test
	public void modelConvert() throws ParseException {
		AnaUser model = new AnaUser();
		model.setId(1L);
		model.setUsername(USERNAME);
		model.setEmail(EMAIL);
		model.setFirstname(FIRSTNAME);
		model.setLastname(LASTNAME);
		model.setPhone(PHONE);
		model.setEnabled(Boolean.TRUE);
		model.setLastChangePwd(Timestamp.from(Instant.ofEpochMilli(LAST_CHANGE_PWD)));
		model.setLastConnectTime(Timestamp.from(Instant.ofEpochMilli(LAST_CONNECT_TIME)));
		Utente res = converter.toUtente(model);
		assertNotNull(res);
		assertTrue(res.getIdUtente() == 1L);
		assertModel(res);
	}

	@Test
	public void paginatedTest() throws ParseException {
		PaginatedResult<AnaUser> paginated = new PaginatedResult<>();
		for (Long i = 0L; i < 3; i++) {
			AnaUser model = new AnaUser();
			model.setId(i);
			model.setUsername(USERNAME);
			model.setEmail(EMAIL);
			model.setFirstname(FIRSTNAME);
			model.setLastname(LASTNAME);
			model.setPhone(PHONE);
			model.setEnabled(Boolean.TRUE);
			model.setLastChangePwd(Timestamp.from(Instant.ofEpochMilli(LAST_CHANGE_PWD)));
			model.setLastConnectTime(Timestamp.from(Instant.ofEpochMilli(LAST_CONNECT_TIME)));
			paginated.getData().add(model);
		}
		UtentiPaginati up = converter.toUtentiPaginati(paginated);
		assertNotNull(up);
		assertNotNull(up.getData());
		assertNotNull(up.getPaginazione());
		Long i = 0L;
		for (Utente res : up.getData()) {
			assertNotNull(res);
			assertTrue(res.getIdUtente() == i);
			assertModel(res);
			i++;
		}

	}

	private void assertModel(final Utente res) {
		assertTrue(res.getEmail().equals(EMAIL));
		assertTrue(res.isAbilitato());
		assertTrue(res.getNome().equals(FIRSTNAME));
		assertTrue(res.getCognome().equals(LASTNAME));
		assertTrue(res.getNomeUtente().equals(USERNAME));
		assertTrue(res.getTelefono().equals(PHONE));
	}

}
