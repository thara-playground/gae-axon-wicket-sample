package org.zetta1985.framework.axon.appengine;

import org.axonframework.domain.AggregateIdentifier;
import org.axonframework.domain.DomainEvent;
import org.axonframework.domain.DomainEventStream;
import org.axonframework.domain.StringAggregateIdentifier;
import org.axonframework.eventsourcing.AggregateFactory;
import org.axonframework.eventsourcing.AggregateSnapshot;
import org.axonframework.eventsourcing.EventSourcedAggregateRoot;
import org.axonframework.eventsourcing.Snapshotter;
import org.axonframework.eventstore.SnapshotEventStore;
import org.axonframework.guice.AggregateFactoriesHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;

/**
 * @author t_hara
 *
 */
public class TaskQueueSnapshotter implements Snapshotter{

	private static final Logger logger = LoggerFactory.getLogger(TaskQueueSnapshotter.class);
	
	private String url;
	
	private SnapshotEventStore eventStore;
	
	private AggregateFactoriesHolder aggregateFactoryHolders;
	
	/**
	 * @param eventStore
	 */
	public TaskQueueSnapshotter(String url, SnapshotEventStore eventStore, AggregateFactoriesHolder aggregateFactoryHolders) {
		super();
		Assert.hasText(url);
		
		this.url = url;
		this.eventStore = eventStore;
		this.aggregateFactoryHolders = aggregateFactoryHolders;
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public void scheduleSnapshot(String typeIdentifier,
			AggregateIdentifier aggregateIdentifier) {
        logger.debug("Schedule a new task to create a snapshot for type {} and aggregate {}",
                typeIdentifier, aggregateIdentifier);

        Queue queue = QueueFactory.getQueue("snapshotter");

        queue.add(TaskOptions.Builder.withUrl(this.url)
                .param("typeIdentifier", typeIdentifier)
                .param("aggregateIdentifier", aggregateIdentifier.asString())
                .method(TaskOptions.Method.POST)
        );
	}
	

    public void createSnapshot(String typeIdentifier, String aggregateIdentifier) {
        DomainEventStream eventStream =
                eventStore.readEvents(typeIdentifier, new StringAggregateIdentifier(aggregateIdentifier));
        DomainEvent snapshotEvent = createSnapshot(typeIdentifier, eventStream);
        if (snapshotEvent != null) {
            eventStore.appendSnapshotEvent(typeIdentifier, snapshotEvent);
        }
    }
	
    private DomainEvent createSnapshot(String typeIdentifier, DomainEventStream eventStream) {
    	
    	AggregateFactory<?> aggregateFactory = aggregateFactoryHolders.getFactory(typeIdentifier);
    	
    	DomainEvent firstEvent = eventStream.peek();
    	AggregateIdentifier aggregateIdentifier = firstEvent.getAggregateIdentifier();

        EventSourcedAggregateRoot aggregate = aggregateFactory.createAggregate(aggregateIdentifier, firstEvent);
        aggregate.initializeState(eventStream);

        return new AggregateSnapshot<EventSourcedAggregateRoot>(aggregate);
    }

}
