package org.zetta1985.framework.axon.appengine;

import org.axonframework.domain.AggregateIdentifier;
import org.axonframework.domain.DomainEvent;
import org.axonframework.domain.MutableEventMetaData;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;

/**
 * @author t_hara
 */
@SuppressWarnings("serial")
public abstract class TaskQueueAnnotatedAggregateRoot extends
		AbstractAnnotatedAggregateRoot {

	/**
	 * @param identifier
	 */
	public TaskQueueAnnotatedAggregateRoot(AggregateIdentifier identifier) {
		super(identifier);
	}
	
	/**
	 * @inheritDoc
	 */
	@Override
	protected void apply(DomainEvent event) {
		MutableEventMetaData metaData = (MutableEventMetaData)event.getMetaData();
		metaData.put("taskQueue", Boolean.TRUE);
		metaData.put("aggregateType", getClass().getSimpleName());
		super.apply(event);
	}
}
