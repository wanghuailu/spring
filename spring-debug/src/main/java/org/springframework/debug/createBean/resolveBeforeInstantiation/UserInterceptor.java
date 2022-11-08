package org.springframework.debug.createBean.resolveBeforeInstantiation;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author kenny
 * @date 2021-12-08
 */
public class UserInterceptor implements MethodInterceptor {

	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("执行目标方法之前");
		Object object = methodProxy.invokeSuper(o, objects);
		System.out.println("执行目标方法之后");
		return object;
	}
}
