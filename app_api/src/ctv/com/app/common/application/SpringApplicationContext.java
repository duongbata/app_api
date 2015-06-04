package ctv.com.app.common.application;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringApplicationContext implements ApplicationContextAware{
	private static ApplicationContext appContext;
	
	public SpringApplicationContext(){}
	
	@Override
	public void setApplicationContext(ApplicationContext appContext)
			throws BeansException {
		this.appContext = appContext;
	}
	
	public static Object getBean(String beanName) {
		return appContext.getBean(beanName);
	}
}
