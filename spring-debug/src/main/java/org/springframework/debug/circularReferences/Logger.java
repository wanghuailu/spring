package org.springframework.debug.circularReferences;

/**
 * @author kenny
 * @date 2021-12-23
 */
public class Logger {

	private void beforeMethod() {
		System.out.println("Logger=====beforeMethod");
	}

	private void afterMethod() {
		System.out.println("Logger=====afterMethod");
	}
}
