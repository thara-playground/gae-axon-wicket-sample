package org.zetta1985.addressbook.web;

import org.apache.wicket.Page;
import org.apache.wicket.guice.GuiceComponentInjector;
import org.apache.wicket.protocol.http.HttpSessionStore;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.session.ISessionStore;
import org.zetta1985.addressbook.web.pages.HomePage;

public class AddressbookApplication extends WebApplication
{
    @Override
    public Class<? extends Page> getHomePage() {
      return HomePage.class;
    }

    @Override
    protected void init() {
      super.init();
      getResourceSettings().setResourcePollFrequency(null);
      addComponentInstantiationListener(
    		  new GuiceComponentInjector(this)
      );
    }

    @Override
    protected ISessionStore newSessionStore() {
      return new HttpSessionStore(this);
    }
}
