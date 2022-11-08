package org.springframework.debug.createBean.supplier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kenny
 * @date 2021-12-08
 * <p>
 * 通过 bpff 修改 beanDefinition 的信息，调用 setInstanceSupplier() 方法
 */
public class TestSupplier {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("createBean/supplier.xml");
		Student student = ac.getBean("student", Student.class);
		System.out.println(student);
	}
}
