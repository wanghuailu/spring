package org.springframework.debug.createBean.factoryMethod;

/**
 * @author kenny
 * @date 2021-12-08
 */
public class MyInstantiationFactory {

	public Dog createDog() {
		return new Dog("藏獒");
	}
}
