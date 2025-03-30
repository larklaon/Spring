package com.ktdsuniversity.edu.syj.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HelloBootController {
	@GetMapping("/hello")
	public String hello() {
		return "helloboot";
	}

}
