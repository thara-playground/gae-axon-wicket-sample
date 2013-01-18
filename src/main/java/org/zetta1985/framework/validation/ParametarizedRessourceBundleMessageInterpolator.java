package org.zetta1985.framework.validation;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.MessageInterpolator;
import javax.validation.metadata.ConstraintDescriptor;

/**
 * @author t_hara
 *
 */
public class ParametarizedRessourceBundleMessageInterpolator implements
		MessageInterpolator {

	private static final Pattern messageParameterPattern = Pattern.compile( "(\\{[^\\}]+?\\})" );
	
	private final MessageInterpolator delegate;
	
	/**
	 * @param delegate
	 */
	public ParametarizedRessourceBundleMessageInterpolator(MessageInterpolator delegate) {
		super();
		if (delegate == null) throw new IllegalArgumentException();
		this.delegate = delegate;
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public String interpolate(String messageTemplate, Context context) {
		String message = delegate.interpolate(messageTemplate, context);
		ConstraintDescriptor<?> constraintDescriptor = context.getConstraintDescriptor();
		return interpolateMessage(message, constraintDescriptor);
	}
	
	/**
	 * @inheritDoc
	 */
	@Override
	public String interpolate(String messageTemplate, Context context,
			Locale locale) {
		String message = delegate.interpolate(messageTemplate, context, locale);
		ConstraintDescriptor<?> constraintDescriptor = context.getConstraintDescriptor();
		return interpolateMessage(message, constraintDescriptor);
	}
	
	protected String interpolateMessage(String message, ConstraintDescriptor<?> constraintDescriptor) {
		
		String[] messages = message.split(",");
		int length = messages.length;
		Matcher matcher = messageParameterPattern.matcher(messages[0]);
		
		StringBuffer sb = new StringBuffer();
		
		while ( matcher.find() ) {
			String parameter = removeCurlyBrace(matcher.group(1));
			try {
				int index = Integer.parseInt(parameter) + 1;
				if (index < length) {
					matcher.appendReplacement(sb, messages[index]);
				}
			} catch (NumberFormatException e) {
				matcher.appendReplacement(sb, parameter);
			} catch (MissingResourceException e) {
				matcher.appendReplacement(sb, parameter);
			}
		}
		
		matcher.appendTail(sb);
		return sb.toString();
	}
	
	private String removeCurlyBrace(String parameter) {
		return parameter.substring( 1, parameter.length() - 1 );
	}
}
