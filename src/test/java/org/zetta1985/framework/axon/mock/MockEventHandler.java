package org.zetta1985.framework.axon.mock;

import org.axonframework.eventhandling.annotation.EventHandler;

/**
 * @author t_hara
 *
 */
public class MockEventHandler {

    @EventHandler
    public void handle(MockCreatedEvent event) {
    	System.out.println(event.getName());
    }
}
