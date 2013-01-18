package org.zetta1985.framework.axon;

import org.apache.commons.lang.Validate;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.callbacks.VoidCallback;
import org.zetta1985.framework.CommandDispatcher;

/**
 * @author t_hara
 */
public class DefaultCommandDispatcher implements CommandDispatcher {

	private final CommandBus commandBus;
	
	/**
	 * @param commandBus
	 */
	public DefaultCommandDispatcher(CommandBus commandBus) {
		super();
		Validate.notNull(commandBus);
		this.commandBus = commandBus;
	}

	@Override
	public void dispatch(Object command) {
		Validate.notNull(command);
		commandBus.dispatch(command, new DefaultCallback());
	}
	
	public static class DefaultCallback extends VoidCallback{
		
		@Override
		protected void onSuccess() {
			// do nothing.
		}
		
		@Override
		public void onFailure(Throwable cause) {
			throw (cause instanceof RuntimeException) 
				? (RuntimeException)cause : new CommandDispatchException(cause);
		}
	}
}
