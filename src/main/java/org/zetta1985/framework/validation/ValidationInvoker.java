package org.zetta1985.framework.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.commons.lang.Validate;

/**
 * @author t_hara
 *
 */
public class ValidationInvoker {

	private final Validator validator;

	/**
	 * @param validator
	 */
	public ValidationInvoker(Validator validator) {
		super();
		Validate.notNull(validator, "validator is required.");
		this.validator = validator;
	}

	/**
	 * @param invocation
	 * @param ann
	 */
	protected void validate(Object target, Validation ann) {
		
		Set<ConstraintViolation<Object>> violations = null;
		if (ann == null) {
			violations = validator.validate(target);
		}else {
			Class<?>[] groups = ann.groups();
			violations = validator.validate(target, groups);
		}
		if (violations != null && !violations.isEmpty()) {
			throw new ValidationException(target, violations);
		}
	}
}