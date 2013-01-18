package org.zetta1985.framework.domain;

/**
 * @author t_hara
 *
 */
public interface Entity<T> {

	boolean sameIdentityAs(T other);
}
