package org.springframework.debug.overrideApplicationContext;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kenny
 * @date 2021-12-13
 */
public class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {

	public MyClassPathXmlApplicationContext(String configLocation) throws BeansException {
		super(configLocation);
		System.out.println("自已定义的 ApplicationContext");
	}
}
