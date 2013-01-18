package org.zetta1985.framework.appengine;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.basic.BigDecimalConverter;
import com.thoughtworks.xstream.converters.basic.BigIntegerConverter;
import com.thoughtworks.xstream.converters.basic.BooleanConverter;
import com.thoughtworks.xstream.converters.basic.ByteConverter;
import com.thoughtworks.xstream.converters.basic.CharConverter;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.converters.basic.DoubleConverter;
import com.thoughtworks.xstream.converters.basic.FloatConverter;
import com.thoughtworks.xstream.converters.basic.IntConverter;
import com.thoughtworks.xstream.converters.basic.LongConverter;
import com.thoughtworks.xstream.converters.basic.NullConverter;
import com.thoughtworks.xstream.converters.basic.ShortConverter;
import com.thoughtworks.xstream.converters.basic.StringBufferConverter;
import com.thoughtworks.xstream.converters.basic.StringConverter;
import com.thoughtworks.xstream.converters.basic.URLConverter;
import com.thoughtworks.xstream.converters.basic.UUIDConverter;
import com.thoughtworks.xstream.converters.collections.ArrayConverter;
import com.thoughtworks.xstream.converters.collections.BitSetConverter;
import com.thoughtworks.xstream.converters.collections.CharArrayConverter;
import com.thoughtworks.xstream.converters.collections.CollectionConverter;
import com.thoughtworks.xstream.converters.collections.MapConverter;
import com.thoughtworks.xstream.converters.collections.TreeMapConverter;
import com.thoughtworks.xstream.converters.collections.TreeSetConverter;
import com.thoughtworks.xstream.converters.enums.EnumConverter;
import com.thoughtworks.xstream.converters.extended.DynamicProxyConverter;
import com.thoughtworks.xstream.converters.extended.EncodedByteArrayConverter;
import com.thoughtworks.xstream.converters.extended.FileConverter;
import com.thoughtworks.xstream.converters.extended.GregorianCalendarConverter;
import com.thoughtworks.xstream.converters.extended.JavaClassConverter;
import com.thoughtworks.xstream.converters.extended.JavaMethodConverter;
import com.thoughtworks.xstream.converters.extended.LocaleConverter;
import com.thoughtworks.xstream.converters.reflection.ExternalizableConverter;
import com.thoughtworks.xstream.converters.reflection.PureJavaReflectionProvider;
import com.thoughtworks.xstream.converters.reflection.ReflectionConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.converters.reflection.SelfStreamingInstanceChecker;
import com.thoughtworks.xstream.converters.reflection.SerializableConverter;
import com.thoughtworks.xstream.core.util.ClassLoaderReference;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.thoughtworks.xstream.mapper.Mapper;

/**
 * @author t_hara
 * 
 */
public class AppEngineXStream extends XStream {

	/**
	 * @param pureJavaReflectionProvider
	 * @param xppDriver
	 * @param classLoaderReference
	 */
	public AppEngineXStream(PureJavaReflectionProvider pureJavaReflectionProvider,
			XppDriver xppDriver, ClassLoaderReference classLoaderReference) {
		super(pureJavaReflectionProvider, xppDriver, classLoaderReference);
	}

	@Override
	protected void setupConverters() {
		Mapper mapper = getMapper();
		ReflectionProvider reflectionProvider = getReflectionProvider();

		final ReflectionConverter reflectionConverter = new ReflectionConverter(
				mapper, reflectionProvider);
		registerConverter(reflectionConverter, PRIORITY_LOW);

		registerConverter(
				new SerializableConverter(mapper, reflectionProvider),
				PRIORITY_LOW);
		registerConverter(new ExternalizableConverter(mapper), PRIORITY_LOW);

		registerConverter(new NullConverter(), PRIORITY_VERY_HIGH);
		registerConverter(new IntConverter(), PRIORITY_NORMAL);
		registerConverter(new FloatConverter(), PRIORITY_NORMAL);
		registerConverter(new DoubleConverter(), PRIORITY_NORMAL);
		registerConverter(new LongConverter(), PRIORITY_NORMAL);
		registerConverter(new ShortConverter(), PRIORITY_NORMAL);
		registerConverter((Converter) new CharConverter(), PRIORITY_NORMAL);
		registerConverter(new BooleanConverter(), PRIORITY_NORMAL);
		registerConverter(new ByteConverter(), PRIORITY_NORMAL);

		registerConverter(new StringConverter(), PRIORITY_NORMAL);
		registerConverter(new StringBufferConverter(), PRIORITY_NORMAL);
		registerConverter(new DateConverter(), PRIORITY_NORMAL);
		registerConverter(new BitSetConverter(), PRIORITY_NORMAL);
		registerConverter(new URLConverter(), PRIORITY_NORMAL);
		registerConverter(new BigIntegerConverter(), PRIORITY_NORMAL);
		registerConverter(new BigDecimalConverter(), PRIORITY_NORMAL);

		registerConverter(new ArrayConverter(mapper), PRIORITY_NORMAL);
		registerConverter(new CharArrayConverter(), PRIORITY_NORMAL);
		registerConverter(new CollectionConverter(mapper), PRIORITY_NORMAL);
		registerConverter(new MapConverter(mapper), PRIORITY_NORMAL);
		registerConverter(new TreeMapConverter(mapper), PRIORITY_NORMAL);
		registerConverter(new TreeSetConverter(mapper), PRIORITY_NORMAL);
		registerConverter(new EncodedByteArrayConverter(), PRIORITY_NORMAL);

		registerConverter(new FileConverter(), PRIORITY_NORMAL);

		registerConverter(new DynamicProxyConverter(mapper, getClassLoader()),
				PRIORITY_NORMAL);
		registerConverter(new JavaClassConverter(getClassLoader()),
				PRIORITY_NORMAL);
		registerConverter(new JavaMethodConverter(getClassLoader()),
				PRIORITY_NORMAL);
		registerConverter(new LocaleConverter(), PRIORITY_NORMAL);
		registerConverter(new GregorianCalendarConverter(), PRIORITY_NORMAL);

		registerConverter(new UUIDConverter(), PRIORITY_NORMAL);
		// registerConverter(new StringBuilderConverter(), PRIORITY_NORMAL);
		registerConverter(new EnumConverter(), PRIORITY_NORMAL);
		// registerConverter(new EnumSetConverter(getMapper()),
		// PRIORITY_NORMAL);
		// registerConverter(new EnumMapConverter(getMapper()),
		// PRIORITY_NORMAL);
		registerConverter(new SelfStreamingInstanceChecker(reflectionConverter,
				this), PRIORITY_NORMAL);
	}
}
