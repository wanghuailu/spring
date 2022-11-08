package org.springframework.debug.aop.annotation;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author kenny
 * @date 2021-12-24
 */
@Aspect
public class Logger {

	@Before(value = "execution(* org.springframework.debug.aop.annotation.Calculate.*())")
	public void beforeMethod(JoinPoint joinPoint) {
		System.out.println("beforeMethod==================");
	}

	@After(value = "execution(* org.springframework.debug.aop.annotation.Calculate.*())")
	public void after() {
		System.out.println("after==================");
	}

	@Around(value = "execution(* org.springframework.debug.aop.annotation.Calculate.*())")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("around before==================");
		Object result = proceedingJoinPoint.proceed();
		System.out.println("around end==================");
		return result;
	}

	@AfterReturning(pointcut = "execution(* org.springframework.debug.aop.annotation.Calculate.*())")
	public void afterReturning() {
		System.out.println("afterReturning==================");
	}

	@AfterThrowing(pointcut = "execution(* org.springframework.debug.aop.annotation.Calculate.*())")
	public void afterThrowing() {
		System.out.println("afterThrowing==================");
	}
}
