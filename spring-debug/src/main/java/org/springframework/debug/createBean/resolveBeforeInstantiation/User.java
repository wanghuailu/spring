package org.springframework.debug.createBean.resolveBeforeInstantiation;

/**
 * @author kenny
 * @date 2021-12-08
 */
public class User {

	private String username;

	public User() {
	}

	public User(String username) {
		this.username = username;
	}

	public void sleep() {
		System.out.println(username + "需要睡觉了");
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
