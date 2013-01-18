package org.zetta1985.framework.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;

/**
 * @author t_hara
 *
 */
public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = -5273023448041027800L;

	private Object source;
	
	private Set<ConstraintViolation<Object>> violations;

	/**
	 * @param source
	 * @param violations
	 */
	public ValidationException(Object source,
			Set<ConstraintViolation<Object>> violations) {
		super();
		this.source = source;
		this.violations = violations;
	}

	/**
	 * @return the source
	 */
	public Object getSource() {
		return source;
	}
	
	/**
	 * @return the violations
	 */
	public Set<ConstraintViolation<Object>> getViolations() {
		return violations;
	}
}
