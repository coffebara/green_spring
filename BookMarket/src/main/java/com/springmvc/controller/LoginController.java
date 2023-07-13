package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
//	시큐리티 설정 파일에 authentication-failure-url=/loginfailed 로 요청할 때 매핑합니다.
	@GetMapping("/loginfailed")
	public String loginerror(Model model) {
		model.addAttribute("error", "true");
		
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(Model model) {
		return "login";
	}

}
