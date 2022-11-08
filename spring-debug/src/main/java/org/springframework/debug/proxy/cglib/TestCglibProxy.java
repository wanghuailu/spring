package org.springframework.debug.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

public class TestCglibProxy {

	public static void main(String[] args) {
		// 动态代理创建的class文件存储到本地指定的磁盘空间内
//		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "d:\\");

		// 通过cglib动态代理获取对象的过程，创建调用对象
		Enhancer enhancer = new Enhancer();

		// 设置enhancer对象的父类
		enhancer.setSuperclass(MyCalculate.class);

		// 设置enhancer的回调对象
		enhancer.setCallback(new MyCglib());

		// 创建代理对象
		MyCalculate myCalculate = (MyCalculate) enhancer.create();

		myCalculate.add(1, 5);

		System.out.println(myCalculate.getClass());
	}

}


