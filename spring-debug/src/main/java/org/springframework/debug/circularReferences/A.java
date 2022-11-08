package org.springframework.debug.circularReferences;

/**
 * @author kenny
 * @date 2021-12-23
 */
public class A {

	private B b;

	public A() {
	}

	public B getB() {
		return b;
	}

	public void setB(B b) {
		this.b = b;
	}
}
