package org.springframework.debug.aop.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author kenny
 * @date 2022-01-13
 */
public class TestAnnotationAop {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(SpringAopConfiguration.class);
		// 在执行BFPP的时候，会执行其中的一个子类 ConfigurationClassPostProcessor，完成注解的扫描，完成 beanDefinition 的创建过程
		ac.refresh();

		// 下面的AOP流程和xml的流程是一样的
		Calculate calculate = ac.getBean(Calculate.class);
		// 这里需要注意下，先要到类里面debug，否则 debug 的时候，F7进不去
		calculate.add();
	}
}
