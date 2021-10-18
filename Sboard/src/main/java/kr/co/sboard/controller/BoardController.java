package kr.co.sboard.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.sboard.vo.MemberVo;

@Controller
public class BoardController {

	@GetMapping(value= {"/","/index"})
	public String index(HttpSession sess) {
		
		MemberVo vo = (MemberVo) sess.getAttribute("sessMember");
		
		if(vo == null) {//로그인을 안했으면
			return "forward:/member/login";	
		}else {
			return "forward:/member/register";	
		}
	}
	
	@GetMapping("/list")
	public String list() {
		return "/list";
	}
	
	@GetMapping("/view")
	public String view() {
		return "/view";
	}
	
	@GetMapping("/write")
	public String write() {
		return "/write";
	}
	
	@GetMapping("/modify")
	public String modify() {
		return "/modify";
	}
	
	
	
}
