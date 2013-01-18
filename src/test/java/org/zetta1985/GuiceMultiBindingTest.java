package org.zetta1985;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Binding;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;


/**
 * @author t_hara
 *
 */
public class GuiceMultiBindingTest {

	public static class Bean<T> {
		T value;
		
		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}
	
	public static class Service{
		@Inject Bean<String> bean;
	}
	
	public static class TestModule extends AbstractModule{

		@Override
		protected void configure() {
			Bean<String> bean1 = new Bean<String>();
			bean1.value = "test";
			bind(new TypeLiteral<Bean<String>>() {}).toInstance(bean1);
			Bean<Integer> bean2 = new Bean<Integer>();
			bind(new TypeLiteral<Bean<Integer>>() {}).toInstance(bean2);
			bind(Service.class).toInstance(new Service());
		}
	}
	
	@Test
	public void test() {
		Injector injector = Guice.createInjector(new TestModule());
		
		List<Binding<Bean<?>>> findBindings = injector.findBindingsByType(new TypeLiteral<Bean<?>>() {});
		for (Binding<Bean<?>> binding : findBindings) {
			Bean<?> bean = binding.getProvider().get();
			System.out.println(bean);
		}
		
		Map<Key<?>, Binding<?>> bindings = injector.getBindings();
		Set<Entry<Key<?>, Binding<?>>> entrySet = bindings.entrySet();
		for (Entry<Key<?>, Binding<?>> entry : entrySet) {
			Key<?> key = entry.getKey();
			Class<?> rawType = key.getTypeLiteral().getRawType();
			
			if (Bean.class.isAssignableFrom(rawType)) {
				System.out.println(rawType);
			}
			
			System.out.println(key.toString());
			System.out.println(entry.getValue().toString());
		}
		
		
	}
}
