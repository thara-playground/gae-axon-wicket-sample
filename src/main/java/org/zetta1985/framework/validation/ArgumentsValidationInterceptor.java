package org.zetta1985.framework.validation;

import javax.validation.Validator;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


/**
 * @author t_hara
 *
 */
public class ArgumentsValidationInterceptor extends ValidationInvoker implements MethodInterceptor {

	/**
	 * @param validator
	 */
	public ArgumentsValidationInterceptor(Validator validator) {
		super(validator);
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		Object[] arguments = invocation.getArguments();
		if (arguments == null) return invocation.proceed();
		
		for (Object arg : arguments) {
			Validation ann = arg.getClass().getAnnotation(Validation.class);
			validate(arg, ann);
		}
		
		return invocation.proceed();
	}

}
