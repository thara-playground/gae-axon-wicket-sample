package org.zetta1985.framework.domain;

import java.io.Serializable;

/**
 * @author t_hara
 *
 */
public interface ValueObject <T extends ValueObject<T>> extends Serializable{

	boolean sameValueAs(T other);
}
