package org.springframework.debug.createBean.defaultBean;

import org.springframework.stereotype.Component;

/**
 * @author kenny
 * @date 2021-12-13
 */
@Component
public class AnnotationPerson {

	private String username;

	public AnnotationPerson() {
	}

	public AnnotationPerson(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "AnnotationPerson{" +
				"username='" + username + '\'' +
				'}';
	}
}
