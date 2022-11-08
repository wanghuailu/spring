package org.springframework.debug.createBean.factoryBean;

/**
 * @author kenny
 * @date 2021-12-08
 */
public class Person {

	private String username;

	public Person() {
	}

	public Person(String username) {
		this.username = username;
	}

	public void eat() {
		System.out.println("通过 factoryBean 创建的 " + username + " 正在吃饭");
	}
}
