package org.zetta1985.framework.validation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.validator.constraints.Length;

/**
 * @author t_hara
 *
 */
public class Employee {

	@NotNull(message="{error.required},{employee.id}")
	@Length(min=4, max=4, message="{error.length},{employee.id}")
	private String id;
	
	@NotNull(message="{error.required},{employee.name}")
	private String name;
	
	@Null(message="{error.null}")
	String text;

	/**
	 * @param id
	 * @param name
	 */
	public Employee(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
}
