package it.furmax.template.repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Paginated Result support class for Repositories
 */
public class PaginatedResult<T> {

	private List<T> data = new ArrayList<>();

	private Pagination pagination = new Pagination();

	public List<T> getData() {
		return data;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

}
