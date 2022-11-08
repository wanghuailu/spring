package org.springframework.debug.createBean.factoryMethod;

/**
 * @author kenny
 * @date 2021-12-08
 */
public class MyStaticFactory {

	public static Dog createDog() {
		return new Dog("旺仔");
	}
}
