package org.springframework.debug.mvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kenny
 * @date 2022-04-02
 */
@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello() {
		return "hello world";
	}
}
