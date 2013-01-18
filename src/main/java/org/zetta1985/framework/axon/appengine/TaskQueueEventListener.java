package org.zetta1985.framework.axon.appengine;

import java.io.Serializable;

import org.axonframework.domain.DomainEvent;
import org.axonframework.domain.Event;
import org.axonframework.domain.EventMetaData;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.annotation.AnnotationEventListenerAdapter;

import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;

/**
 * @author t_hara
 */
public class TaskQueueEventListener extends AnnotationEventListenerAdapter {

	private String taskQueueUrl;	// "/task/publishEvent"
	
	/**
	 * @param annotatedEventListener
	 * @param eventBus
	 */
	public TaskQueueEventListener(Object annotatedEventListener,
			EventBus eventBus, String taskQueueUrl) {
		super(annotatedEventListener, eventBus);
		this.taskQueueUrl = taskQueueUrl;
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public void handle(Event event) {
		EventMetaData metaData = event.getMetaData();
		if (metaData.get("taskQueue") == Boolean.TRUE) {
			if (DomainEvent.class.isAssignableFrom(event.getClass())) {
				DomainEvent domainEvent = (DomainEvent)event;
				Serializable aggregateType = metaData.get("aggregateType");
				Queue queue = QueueFactory.getQueue("publishEvent");
				
				queue.add(TaskOptions.Builder.withUrl(taskQueueUrl)
						.param("aggregateType", aggregateType.toString())
						.param("aggregateIdentifier", domainEvent.getAggregateIdentifier().asString())
						.param("sequenceNumber", domainEvent.getSequenceNumber().toString())
						.method(TaskOptions.Method.POST));
			}
		}else {
			super.handle(event);
		}
	}
}
