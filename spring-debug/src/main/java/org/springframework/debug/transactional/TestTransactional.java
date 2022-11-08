package org.springframework.debug.transactional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kenny
 * @date 2021-12-23
 */
public class TestTransactional {

	public static void main(String[] args) throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("transactional/application.xml");
		PersonService personService = ac.getBean(PersonService.class);
//		personService.insert();
		personService.update();
	}
}
