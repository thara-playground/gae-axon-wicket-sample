package org.zetta1985.framework.inject.axon;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang.SystemUtils;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.eventstore.EventStore;
import org.axonframework.eventstore.fs.FileSystemEventStore;
import org.axonframework.guice.AxonSubcribingModule;
import org.axonframework.repository.Repository;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.zetta1985.framework.axon.command.SimpleCallback;
import org.zetta1985.framework.axon.mock.MockAggregate;
import org.zetta1985.framework.axon.mock.MockCommandSubscriber;
import org.zetta1985.framework.axon.mock.MockCreateCommand;
import org.zetta1985.framework.axon.mock.MockEventSubscriber;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.TypeLiteral;


/**
 * @author t_hara
 *
 */
public class SubcribingIntegrationTest {

	public static class TestModule extends AxonSubcribingModule {

		@Override
		protected void configure() {
			bindRepository(new TypeLiteral<Repository<MockAggregate>>() {}, MockAggregate.class);
			
			getCommandBinder().addBinding().to(MockCommandSubscriber.class);
			getEventBinder().addBinding().to(MockEventSubscriber.class);
		}
	}
	
	static Injector injector;
	
	@BeforeClass
	public static void beforeTest() {
		AbstractModule configModule = new MockConfigModule() {
			@Override
			protected void configure() {
				FileSystemEventStore eventStore = new FileSystemEventStore();
				FileSystemResource fileSystemResource = new FileSystemResource(SystemUtils.USER_DIR + "/" + "target");
				eventStore.setBaseDir(fileSystemResource.getFile());
				bind(EventStore.class).toInstance(eventStore);
			}
		};
		
		injector = Guice.createInjector(
				configModule,
				new TestModule()
				);
	}
	
	@Test
	public void inject() {
//		CommandBus commandBus = injector.getInstance(CommandBus.class);
//		
//		SimpleCallback<String> c = new SimpleCallback<String>();
//		commandBus.dispatch(new MockCreateCommand("zetta1985"), c);
//		assertEquals("success", c.get());
	}
}
