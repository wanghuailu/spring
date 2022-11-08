package org.springframework.debug.aop;


import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author kenny
 * @date 2021-12-24
 */
public class Logger {

	public void beforeMethod() {
		System.out.println("beforeMethod==================");
	}

	public void after() {
		System.out.println("after==================");
	}

	public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("around before==================");
		proceedingJoinPoint.proceed();
		System.out.println("around end==================");
	}

	public void afterReturning() {
		System.out.println("afterReturning==================");
	}

	public void afterThrowing(Throwable ex) {
		System.out.println("afterThrowing==================");
	}
}
