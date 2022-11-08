package org.springframework.debug.circularReferences;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kenny
 * @date 2021-12-23
 */
public class TestCircularReference {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("circularReferences/application.xml");
		A a = ac.getBean(A.class);
		System.out.println(a);
		System.out.println(a.getB());

		B b = ac.getBean(B.class);
		System.out.println(b);
		System.out.println(b.getA());
	}
}
