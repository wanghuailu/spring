package org.springframework.debug.overrideApplicationContext;

import org.springframework.context.ApplicationContext;

/**
 * @author kenny
 * @date 2021-12-13
 */
public class TestApplicationContext {

	public static void main(String[] args) {
		ApplicationContext ac = new MyClassPathXmlApplicationContext("overrideApplicationContext/application.xml");
		System.out.println(ac.getBean("user"));
	}
}
