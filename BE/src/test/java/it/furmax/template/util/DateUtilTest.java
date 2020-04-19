package it.furmax.template.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;

import it.furmax.template.util.DateUtil;

public final class DateUtilTest {

	@Test
	public void nullHourTest() {
		assertTrue(DateUtil.formatOnlyHour(null).isEmpty());
	}

	@Test
	public void nowHourTest() {
		Date now = new Date();
		String res = DateUtil.formatOnlyHour(Timestamp.from(now.toInstant()));
		assertNotNull(res);
		assertTrue(!res.isEmpty());
	}

}
