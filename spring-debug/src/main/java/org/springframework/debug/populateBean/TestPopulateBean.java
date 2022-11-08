package org.springframework.debug.populateBean;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.debug.populateBean.annotation.TestController;
import org.springframework.debug.populateBean.myAnnotation.TestMyAutowiredController;

/**
 * @author kenny
 * @date 2021-12-15
 */
public class TestPopulateBean {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("populateBean/application.xml");

		Student student = ac.getBean("student", Student.class);
		System.out.println(student);

		Student student1 = ac.getBean("student1", Student.class);
		System.out.println(student1);

		Address address = ac.getBean("address", Address.class);
		System.out.println(address);

		TestController testController = ac.getBean("testController", TestController.class);
		System.out.println(testController);

		TestMyAutowiredController testMyAutowiredController = ac.getBean("testMyAutowiredController", TestMyAutowiredController.class);
		System.out.println(testMyAutowiredController);
	}
}
