package it.furmax.template.controller;

import org.jboss.logging.Logger;

import it.furmax.template.SystemConstants;

public abstract class AbstractController {

	protected static final String UTF_8 = "UTF-8";
	private static Logger log = Logger.getLogger(AbstractController.class.getName());

	protected Long limitPageSize(final Long pageSize) {
		if (pageSize == null) {
			return SystemConstants.PAGINATION_PAGE_MAX_SIZE;
		}
		Long size = pageSize > SystemConstants.PAGINATION_PAGE_MAX_SIZE ? SystemConstants.PAGINATION_PAGE_MAX_SIZE
				: pageSize;
		return size <= 0 ? 1 : size;
	}

}
