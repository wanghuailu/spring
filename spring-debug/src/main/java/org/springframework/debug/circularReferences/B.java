package org.springframework.debug.circularReferences;

/**
 * @author kenny
 * @date 2021-12-23
 */
public class B {

	private A a;

	public B() {
	}

	public A getA() {
		return a;
	}

	public void setA(A a) {
		this.a = a;
	}
}
