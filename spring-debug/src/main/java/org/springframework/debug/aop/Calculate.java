package org.springframework.debug.aop;

/**
 * @author kenny
 * @date 2021-12-24
 */
public class Calculate {

	public void add() {
		System.out.println("1 + 1 = " + (1 + 1));
	}

	public void sub() {
		System.out.println("1 - 1 = " + (1 - 1));
	}

	public void multi() {
		System.out.println("1 x 1 = " + (1 * 1));
	}

	public void div() {
		System.out.println("1 ÷ 1 = " + (1 / 1));
		throw new RuntimeException("计算异常");
	}
}
