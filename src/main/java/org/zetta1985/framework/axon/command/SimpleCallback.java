package org.zetta1985.framework.axon.command;

import org.axonframework.commandhandling.CommandCallback;

/**
 * @author t_hara
 *
 */
public class SimpleCallback<R> implements CommandCallback<R> {

	private R result;
	
	public SimpleCallback() {
		super();
	}
	
	public R get() {
		return result;
	}
	
	/**
	 * @inheritDoc
	 */
	@Override
	public void onFailure(Throwable cause) {
		if (cause instanceof RuntimeException) {
			throw (RuntimeException)cause;
		}else {
			throw new Error(cause);
		}
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public void onSuccess(R result) {
		this.result = result;
	}
}
