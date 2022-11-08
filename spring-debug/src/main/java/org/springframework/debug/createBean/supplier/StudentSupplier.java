package org.springframework.debug.createBean.supplier;

/**
 * @author kenny
 * @date 2021-12-08
 */
public class StudentSupplier {

	public static Student createStudent() {
		return new Student("xiaoming", 12);
	}
}
