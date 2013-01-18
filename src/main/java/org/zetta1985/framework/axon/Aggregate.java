package org.zetta1985.framework.axon;

import org.axonframework.domain.AggregateIdentifier;
import org.zetta1985.framework.axon.appengine.TaskQueueAnnotatedAggregateRoot;

/**
 * @author t_hara
 *
 */
@SuppressWarnings("serial")
public abstract class Aggregate extends TaskQueueAnnotatedAggregateRoot{

	/**
	 * @param identifier
	 */
	public Aggregate(AggregateIdentifier identifier) {
		super(identifier);
	}
}
