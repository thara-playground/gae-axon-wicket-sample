package org.zetta1985.addressbook.web;

import org.zetta1985.addressbook.web.resources.ContactAddressResource;
import org.zetta1985.addressbook.web.resources.ContactResource;
import org.zetta1985.addressbook.web.task.CQRSTasks;

import com.google.inject.AbstractModule;

/**
 * @author t_hara
 */
public class ResourcesModule extends AbstractModule {

	/**
	 * @inheritDoc
	 */
	@Override
	protected void configure() {
		bind(ContactResource.class);
		bind(ContactAddressResource.class);
		
		bind(CQRSTasks.class);
	}

}
