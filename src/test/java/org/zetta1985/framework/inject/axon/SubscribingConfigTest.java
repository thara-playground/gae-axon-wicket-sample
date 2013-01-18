package org.zetta1985.framework.inject.axon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;


import org.axonframework.commandhandling.CommandBus;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.guice.AxonSubcribingModule;
import org.axonframework.guice.CommandSubscriber;
import org.axonframework.guice.EventSubscriber;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Scopes;


/**
 * @author t_hara
 *
 */
public class SubscribingConfigTest {

	static int commandSubscribingCount;
	static int eventSubscribingCount;
	
	static Injector injector;
	
	@BeforeClass
	public static void beforeTest() {
		injector = Guice.createInjector(
				new ConfigModule(),
				new TestModule(),
				new TestModule()
		);
	}
	
	@Test
	public void subscribing_for_commandBus() {
		CommandBus instance1 = injector.getInstance(CommandBus.class);
		assertNotNull(instance1);
		
		CommandBus instance2 = injector.getInstance(CommandBus.class);
		assertSame(instance1, instance2);
		
		assertEquals(2, commandSubscribingCount);
	}
	
	@Test
	public void subscribing_for_eventBus() {
		EventBus instance1 = injector.getInstance(EventBus.class);
		assertNotNull(instance1);
		EventBus instance2 = injector.getInstance(EventBus.class);
		assertSame(instance1, instance2);
		
		assertEquals(2, eventSubscribingCount);
	}
	
	public static class ConfigModule extends AbstractModule {
		@Override
		protected void configure() {
			bind(CommandBus.class).toProvider(MockCommandBusProvider.class).in(Scopes.SINGLETON);
			bind(EventBus.class).toProvider(MockEventBusProvider.class).in(Scopes.SINGLETON);
		}
	}
	
	public static class TestEventSubscriber implements EventSubscriber {
		@Override
		public void subscribe(EventBus eventBus) {
			eventSubscribingCount++;
		}
	}
	
	public static class TestCommandSubscriber implements CommandSubscriber {
		@Override
		public void subscribe(CommandBus commandBus) {
			commandSubscribingCount++;
		}
	}
	
	public static class TestModule extends AxonSubcribingModule {
		@Override
		protected void configure() {
			getCommandBinder().addBinding().to(TestCommandSubscriber.class);
			getEventBinder().addBinding().to(TestEventSubscriber.class);
		}
	}
}
