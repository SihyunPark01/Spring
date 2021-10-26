package kr.co.farmstory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	
	@GetMapping("/member/login")
	public String login() {
		return "/member/login";
	}
	@GetMapping("/member/terms")
	public String terms() {
		return "/member/terms";
	}
	@GetMapping("/member/register")
	public String register() {
		return "/member/register";
	}
}
