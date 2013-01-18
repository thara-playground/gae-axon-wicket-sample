package org.zetta1985.framework.validation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author t_hara
 *
 */
@Documented
@Target({ TYPE })
@Retention(RUNTIME)
public @interface Validation {

	Class<?>[] groups() default {};
}
