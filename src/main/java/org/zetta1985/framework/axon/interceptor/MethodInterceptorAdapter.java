package org.zetta1985.framework.axon.interceptor;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.axonframework.commandhandling.CommandHandlerInterceptor;
import org.axonframework.commandhandling.InterceptorChain;
import org.axonframework.unitofwork.UnitOfWork;

/**
 * @author t_hara
 *
 */
public class MethodInterceptorAdapter implements CommandHandlerInterceptor {

	private MethodInterceptor methodInterceptor;
	
	/**
	 * @param methodInterceptor
	 */
	public MethodInterceptorAdapter(MethodInterceptor methodInterceptor) {
		super();
		this.methodInterceptor = methodInterceptor;
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public Object handle(Object command, UnitOfWork unitOfWork,
			InterceptorChain interceptorChain) throws Throwable {
		CommandInvocation invocation = new CommandInvocation(command, interceptorChain);
		return methodInterceptor.invoke(invocation);
	}
	
	static class CommandInvocation implements MethodInvocation {

		private Object command;
		
		private InterceptorChain interceptorChain;
		
		/**
		 * @param command
		 * @param interceptorChain
		 */
		public CommandInvocation(Object command,
				InterceptorChain interceptorChain) {
			super();
			this.command = command;
			this.interceptorChain = interceptorChain;
		}

		/**
		 * @inheritDoc
		 */
		@Override
		public Method getMethod() {
			return null;
		}

		/**
		 * @inheritDoc
		 */
		@Override
		public Object[] getArguments() {
			return null;
		}

		/**
		 * @inheritDoc
		 */
		@Override
		public AccessibleObject getStaticPart() {
			return null;
		}

		/**
		 * @inheritDoc
		 */
		@Override
		public Object getThis() {
			return command;
		}

		/**
		 * @inheritDoc
		 */
		@Override
		public Object proceed() throws Throwable {
			return interceptorChain.proceed();
		}
	}

}
