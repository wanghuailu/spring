package org.springframework.debug.createBean.defaultBean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kenny
 * @date 2021-12-13
 */
public class TestDefaultBean {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("createBean/defaultBean.xml");
		XmlPerson xmlPerson = ac.getBean("xmlPerson", XmlPerson.class);
		System.out.println(xmlPerson.toString());


		AnnotationPerson annotationPerson = ac.getBean("annotationPerson", AnnotationPerson.class);
		annotationPerson.setUsername("刘备");
		System.out.println(annotationPerson.toString());
	}
}
