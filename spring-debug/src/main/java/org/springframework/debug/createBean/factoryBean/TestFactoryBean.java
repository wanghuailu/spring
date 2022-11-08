package org.springframework.debug.createBean.factoryBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kenny
 * @date 2021-12-08
 * <p>
 * 通过 factoryBean 的 getObject() 方法创建 bean
 */
public class TestFactoryBean {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("createBean/factoryBean.xml");
		MyFactoryBean myFactoryBean = (MyFactoryBean) ac.getBean("&myFactoryBean");
		System.out.println(myFactoryBean);
		Person person = (Person) ac.getBean("myFactoryBean");
		person.eat();
	}
}
