package org.springframework.debug.createBean.resolveBeforeInstantiation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kenny
 * @date 2021-10-18
 */
public class TestResolveBeforeInstantiation {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("createBean/resolveBeforeInstantiation.xml");
		User user = applicationContext.getBean(User.class);
		user.setUsername("张三");
		user.sleep();
	}
}
