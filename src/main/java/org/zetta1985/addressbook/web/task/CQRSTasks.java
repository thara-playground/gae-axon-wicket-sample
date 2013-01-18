package org.zetta1985.addressbook.web.task;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.axonframework.eventhandling.EventBus;
import org.zetta1985.framework.axon.appengine.AppEngineEventBus;
import org.zetta1985.framework.axon.appengine.TaskQueueSnapshotter;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author t_hara
 */
@Path("task")
public class CQRSTasks {

	@Inject
	Injector injector;
	
	@Inject
	TaskQueueSnapshotter snapshotter;
	
	@POST
	@Path("/publishEvent")
	public void publish(
			@FormParam("aggregateType") String aggregateType,
			@FormParam("aggregateIdentifier") String aggregateIdentifier,
			@FormParam("sequenceNumber") Long sequenceNumber) {
		
		AppEngineEventBus eventBus = (AppEngineEventBus)injector.getInstance(EventBus.class);
		eventBus.publish(aggregateType, aggregateIdentifier, sequenceNumber);
	}
	
	@POST
	@Path("/snapshot")
	public void snapshotting(
			@FormParam("typeIdentifier") String typeIdentifier,
			@FormParam("aggregateIdentifier") String aggregateIdentifier) {
		snapshotter.createSnapshot(typeIdentifier, aggregateIdentifier);
	}
}
