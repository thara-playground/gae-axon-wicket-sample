package org.zetta1985.framework.axon;

/**
 * @author t_hara
 */
public class CommandDispatchException extends RuntimeException{
	
	private static final long serialVersionUID = -1L;

	CommandDispatchException(Throwable t) {
		super(t);
	}
}