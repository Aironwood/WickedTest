package com.mycompany;

import com.mycompany.OwnerPage.OwnerPage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import com.mycompany.OwnerPage.OwnerPage;
import com.mycompany.PropertyPage.PropertyPage;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 * 
 * @see com.mycompany.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return PropertyPage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();
                getRequestCycleSettings().setResponseRequestEncoding("UTF-8"); 
                getMarkupSettings().setDefaultMarkupEncoding("UTF-8"); 
		// add your configuration here
	}
}
