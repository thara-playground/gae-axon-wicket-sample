package org.zetta1985.test.inject;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * @author t_hara
 * 
 */
public class GuiceTestRunner extends BlockJUnit4ClassRunner{

	private final Injector injector;

	public GuiceTestRunner(Class<?> classToRun, Module... modules) throws InitializationError {
		super(classToRun);
		this.injector = Guice.createInjector(modules);
	}
	
	/**
	 * @inheritDoc
	 */
	@Override
	protected Object createTest() throws Exception {
		return injector.getInstance(getTestClass().getJavaClass());
	}
	
	/**
	 * @return the injector
	 */
	public Injector getInjector() {
		return injector;
	}
}
