package org.springframework.debug.createBean.factoryMethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kenny
 * @date 2021-12-08
 */
public class TestFactoryMethod {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("createBean/factoryMethod.xml");
		Dog dog1 = (Dog) ac.getBean("dog1");
		dog1.call();
		Dog dog2 = (Dog) ac.getBean("dog2");
		dog2.call();
	}
}
