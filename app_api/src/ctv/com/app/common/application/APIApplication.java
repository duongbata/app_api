package ctv.com.app.common.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import ctv.com.app.common.service.DemoService;

public class APIApplication extends Application{
	private Set<Object> singletons = new HashSet<Object>();
	 
	public APIApplication() {
		singletons.add(new DemoService());
	}
 
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
