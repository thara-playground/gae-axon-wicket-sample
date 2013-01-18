package org.zetta1985.addressbook.api.command.validation;

import javax.validation.Configuration;
import javax.validation.MessageInterpolator;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.validator.HibernateValidatorConfiguration;
import org.hibernate.validator.engine.ResourceBundleMessageInterpolator;
import org.junit.runners.model.InitializationError;
import org.zetta1985.framework.validation.ParametarizedRessourceBundleMessageInterpolator;
import org.zetta1985.test.inject.GuiceTestRunner;

import com.google.inject.AbstractModule;

/**
 * @author t_hara
 */
public class ValidationTestRunner extends GuiceTestRunner {

	/**
	 * @param classToRun
	 * @param modules
	 * @throws InitializationError
	 */
	public ValidationTestRunner(Class<?> classToRun)
			throws InitializationError {
		super(classToRun, new ValidationModule());
	}

	static class ValidationModule extends AbstractModule {

		@Override
		protected void configure() {
			MessageInterpolator delegate = new ResourceBundleMessageInterpolator();
			MessageInterpolator messageInterpolator = new ParametarizedRessourceBundleMessageInterpolator(delegate);
			
			Configuration<?> configure = Validation.byDefaultProvider().configure();
			((HibernateValidatorConfiguration)configure).messageInterpolator(messageInterpolator);
			
			ValidatorFactory validatorFactory = configure.buildValidatorFactory();
			Validator validator = validatorFactory.getValidator();
			
			bind(Validator.class).toInstance(validator);
		}
		
	}
}
