package kr.co.ch05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	
	@GetMapping
	public void register() {}
	
	public void list() {}
	
	public void modify() {}

}
