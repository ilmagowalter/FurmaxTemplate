package it.furmax.template.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import it.furmax.template.SystemConstants;
import it.furmax.template.controller.AbstractController;

public final class AbstractControllerTest {

	private AbstractController concrete;

	@Before
	public void setup() {
		concrete = Mockito.mock(AbstractController.class, Mockito.CALLS_REAL_METHODS);
	}

	@Test
	public void nullLimitPageSize() {
		Long res = concrete.limitPageSize(null);
		assertNotNull(res);
		assertTrue(res.compareTo(SystemConstants.PAGINATION_PAGE_MAX_SIZE) == 0);
	}

	@Test
	public void belowZeroLimitPageSize() {
		Long res = concrete.limitPageSize(Long.valueOf(-1));
		assertNotNull(res);
		assertTrue(res.compareTo(1l) == 0);
	}

	@Test
	public void correctLimitPageSize() {
		Long res = concrete.limitPageSize(Long.valueOf(20));
		assertNotNull(res);
		assertTrue(res.compareTo(20l) == 0);
	}

	@Test
	public void maxLimitPageSize() {
		Long res = concrete.limitPageSize(SystemConstants.PAGINATION_PAGE_MAX_SIZE + 1);
		assertNotNull(res);
		assertTrue(res.compareTo(SystemConstants.PAGINATION_PAGE_MAX_SIZE) == 0);
	}

}
