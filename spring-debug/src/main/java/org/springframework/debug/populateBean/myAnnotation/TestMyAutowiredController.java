package org.springframework.debug.populateBean.myAnnotation;

import org.springframework.stereotype.Controller;

@Controller
public class TestMyAutowiredController {

	@MyAutowired
	private TestMyAutowiredService testMyAutowiredService;
}
