package org.zetta1985.framework.axon.appengine;

import java.util.Iterator;

import org.axonframework.domain.DomainEvent;
import org.axonframework.eventhandling.SimpleEventBus;
import org.axonframework.eventstore.EventSerializer;
import org.springframework.util.Assert;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

/**
 * @author t_hara
 */
public class AppEngineEventBus extends SimpleEventBus {
	
	private final EventSerializer eventSerializer;

	public AppEngineEventBus(EventSerializer eventSerializer) {
		super(false);	// not register Mbean
		Assert.notNull(eventSerializer);
		this.eventSerializer = eventSerializer;
	}
	
	public void publish(String aggregateType, String aggregateIdentifier, long sequenceNumber) {
		DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
		
		Query query = EventEntry.forAggregate(aggregateType, aggregateIdentifier, sequenceNumber);
		PreparedQuery preparedQuery = datastoreService.prepare(query);
		Iterator<Entity> entityIterator = preparedQuery.asIterable().iterator();
		
		if (entityIterator.hasNext()) {
			Entity lastSnapshot = entityIterator.next();
			EventEntry eventEntry = new EventEntry(lastSnapshot);
			DomainEvent domainEvent = eventEntry.getDomainEvent(eventSerializer);
			super.publish(domainEvent);
		}
	}
}
