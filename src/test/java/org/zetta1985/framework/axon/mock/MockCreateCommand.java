package org.zetta1985.framework.axon.mock;

/**
 * @author t_hara
 *
 */
public class MockCreateCommand {

	private String name;

	public MockCreateCommand(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
