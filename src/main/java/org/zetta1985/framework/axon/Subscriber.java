package org.zetta1985.framework.axon;


/**
 * @author t_hara
 *
 */
public interface Subscriber<T> {

	void subscribe(T target);
}
