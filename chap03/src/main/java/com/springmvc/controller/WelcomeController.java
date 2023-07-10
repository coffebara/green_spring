package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//Spring MVC에서 컨트롤러 역할을 하는 클래스임
public class WelcomeController {
	@RequestMapping(value="/home", method = RequestMethod.GET)
	// "/home" URL에 대한 GEt 요청 처리
	public String welcome(Model model) {
		model.addAttribute("greeting", "Welcome to BookMarker");
		// Model 객체에 "strapline"이라는 이름을 속성을 추가하고,그 값을
		model.addAttribute("strapline", "Welcome to Web Shoppping Mall!");
		return "welcome";
	}
}
//빌드 정보: <build>
//프로젝트 빌드할 때 필요한 요소들을 불러오고 싶다면 <build>요소 안에 설정
//<plugins>요소를 이용하여 빌드에서 사용할 플로그인을 설정