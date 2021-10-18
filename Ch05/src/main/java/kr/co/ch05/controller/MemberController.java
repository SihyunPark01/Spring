package kr.co.ch05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ch05.service.MemberService;
import kr.co.ch05.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	
	@GetMapping(value = "/member/register")
	public void register() {
		
	}
	@PostMapping(value = "/member/register")
	public void register(MemberVO vo) {
		
	}
	public void list() {}
	
	public void modify() {}

}
