package it.furmax.template.dto;

import javax.persistence.metamodel.SingularAttribute;

/**
 * Dto used to construct jpa nested attribute criteria
 */
public final class NestedAttributeDto {

	private SingularAttribute attribute;
	private Object value;

	public NestedAttributeDto(SingularAttribute attribute, Object value) {
		this.attribute = attribute;
		this.value = value;
	}

	public SingularAttribute getAttribute() {
		return attribute;
	}

	public Object getValue() {
		return value;
	}

}
