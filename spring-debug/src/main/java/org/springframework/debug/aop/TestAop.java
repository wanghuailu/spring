package org.springframework.debug.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kenny
 * @date 2021-12-24
 */
public class TestAop {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("aop/application.xml");
		Calculate calculate = ac.getBean(Calculate.class);
		System.out.println("调用加法开始");
		// 执行流程
		// cglibMethodInvocation
		// ReflectiveMethodInvocation
		// ExposeInvocationInterceptor
		calculate.add();
		System.out.println("调用加法结束");

		System.out.println("调用减法开始");
		calculate.sub();
		System.out.println("调用减法结束");

		System.out.println("调用乘法开始");
		calculate.multi();
		System.out.println("调用乘法结束");

		System.out.println("调用除法开始");
		calculate.div();
		System.out.println("调用除法结束");
	}
}
