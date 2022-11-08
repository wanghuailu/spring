package org.springframework.debug.createBean.factoryMethod;

/**
 * @author kenny
 * @date 2021-12-08
 */
public class Dog {

	private String name;

	public Dog() {
	}

	public Dog(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void call() {
		System.out.println(name + "在汪汪汪的叫");
	}
}
