package org.springframework.debug.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestJdkProxy {

	public static void main(String[] args) {
		// 这个属性设置，可以让生成的代理字节码保存到当前项目路径下
		// true 开启； false 关闭
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "false");

		MyCalculateInterface myCalculateInterface = new MyCalculate();
		ClassLoader classLoader = MyCalculateInterface.class.getClassLoader();
		Class<?>[] interfaces = MyCalculate.class.getInterfaces();
		InvocationHandler h = new InvocationHandler() {
			Object result;

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				result = method.invoke(myCalculateInterface, args);
				System.out.println("调用结果：" + result);
				return result;
			}
		};

		// JDK动态代理要求
		// 1、被代理的类必须实现接口
		// 2、必须要有一个 InvocationHandler
		Object proxy = Proxy.newProxyInstance(classLoader, interfaces, h);
		MyCalculateInterface proxyInterface = ((MyCalculateInterface) proxy);
		proxyInterface.add(1, 2);
		System.out.println(proxyInterface.getClass());
	}
}
