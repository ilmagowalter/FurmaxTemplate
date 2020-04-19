package it.furmax.template.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

@SuppressWarnings({ "unchecked", "rawtypes" })
public abstract class AbstractRepository<T> {

	// Persistence constants
	private static final String PERSISTENCE_CONTEXT_NAME = "primary";

	@PersistenceContext(unitName = PERSISTENCE_CONTEXT_NAME)
	protected EntityManager em;

	protected Class<T> type;

	public T findById(final Long id) {
		return em.find(type, id);
	}

	public T save(T model) {
		em.persist(model);
		em.flush();
		return model;
	}

	public void delete(final T model) {
		em.remove(model);
	}

	public void deleteFlush(final T model) {
		em.remove(model);
		em.flush();
	}

	public void delete(final List<Long> ids) {
		for (Long id : ids) {
			T e = findById(id);
			delete(e);
		}
	}

	public void deleteEntities(final List<T> models) {
		for (T t : models) {
			delete(t);
		}
	}

	public void deleteEntitiesFlush(final List<T> models) {
		for (T t : models) {
			delete(t);
		}
		em.flush();
	}

	public T merge(T model) {
		return em.merge(model);
	}

	public T persist(T model) {
		em.persist(model);
		return model;
	}

	public List<T> findByIds(final List<Long> ids) {
		if (ids == null || ids.isEmpty()) {
			return new ArrayList<>();
		}
		List<T> res = new ArrayList<>();
		for (Long id : ids) {
			T entry = findById(id);
			if (entry != null) {
				res.add(entry);
			}
		}
		return res;
	}

	public List<T> find(final SingularAttribute field, final Object value) {
		Map<SingularAttribute, Object> fields = new HashMap<>();
		fields.put(field, value);
		return find(fields);
	}

	public List<T> find(final Map<SingularAttribute, Object> fields) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<T> cq = builder.createQuery(type);
		Root<T> root = cq.from(type);
		List<Predicate> predicates = new ArrayList<>();
		if (fields != null && !fields.isEmpty()) {
			for (Entry<SingularAttribute, Object> entry : fields.entrySet()) {
				predicates.add(buildPredicate(entry.getKey().getName(), entry.getValue(), builder, root));
			}
		}
		// set where
		Predicate[] arrayPredicate = predicates.toArray(new Predicate[predicates.size()]);
		if (!predicates.isEmpty()) {
			cq.where(arrayPredicate);
		}
		TypedQuery<T> query = em.createQuery(cq);
		return query.getResultList();
	}

	public PaginatedResult<T> findPaginated(final Long pageSize, final Long pageNumber) {
		return findPaginated(null, pageSize, pageNumber);
	}

	public PaginatedResult<T> findPaginated(final Map<SingularAttribute, Object> fields, final Long pageSize,
			final Long pageNumber) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<T> cq = builder.createQuery(type);
		Root<T> root = cq.from(type);
		List<Predicate> predicates = new ArrayList<>();
		if (fields != null && !fields.isEmpty()) {
			for (Entry<SingularAttribute, Object> entry : fields.entrySet()) {
				predicates.add(buildPredicate(entry.getKey().getName(), entry.getValue(), builder, root));
			}
		}
		// set where
		Predicate[] arrayPredicate = predicates.toArray(new Predicate[predicates.size()]);
		if (!predicates.isEmpty()) {
			cq.where(arrayPredicate);
		}
		TypedQuery<T> query = em.createQuery(cq);
		if (pageNumber != null && pageSize != null) {
			query.setFirstResult((int) ((pageNumber - 1) * pageSize)).setMaxResults(pageSize.intValue());
		}
		List<T> res = query.getResultList();
		if (res == null || res.isEmpty()) {
			return new PaginatedResult<>();
		}
		Long totElements = countElements(builder, arrayPredicate);
		PaginatedResult<T> pr = new PaginatedResult<>();
		pr.setData(res);
		pr.setPagination(buildPagination(pageSize, pageNumber, totElements));
		return pr;
	}

	protected Pagination buildPagination(final Long pageSize, final Long pageNumber, final Long totElements) {
		Pagination pagination = new Pagination();
		pagination.setPageNumber(pageNumber != null ? pageNumber : 0);
		pagination.setPageSize(pageSize != null ? pageSize : 0);
		pagination.setTotalElements(totElements);
		pagination.setTotalPages(getNumOfPages(pageSize, totElements));
		return pagination;
	}

	protected Long getNumOfPages(final Long pageSize, final Long totalElements) {

		if (pageSize == null) {
			return 0L;
		}
		Long numOfPages = (totalElements % pageSize) == 0 ? (totalElements / pageSize) : (totalElements / pageSize) + 1;
		return numOfPages;
	}

	private Predicate buildPredicate(String name, Object value, CriteriaBuilder builder, Root<T> root) {
		if (value == null) {
			return builder.isNull(root.get(name));
		}
		if (value instanceof List) {
			return builder.in(root.get(name).in(value));
		}
		return builder.equal(root.get(name), value);
	}

	protected long countElements(final CriteriaBuilder builder, final Predicate... whereExpression) {
		CriteriaQuery<Long> countq = builder.createQuery(Long.class);
		countq.select(builder.count(countq.from(type)));
		em.createQuery(countq);
		countq.where(whereExpression);
		return em.createQuery(countq).getSingleResult();
	}

}
