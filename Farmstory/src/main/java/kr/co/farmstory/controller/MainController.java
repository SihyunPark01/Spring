package kr.co.farmstory.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.farmstory.vo.MemberVo;

@Controller
public class MainController {

	@GetMapping(value = {"/","/index"})
	public String index(HttpSession sess, Model model, String success) {
		
		MemberVo vo = (MemberVo) sess.getAttribute("sessMember");
		model.addAttribute("success", success);

		return "/index";
	}
	
	@GetMapping("/introduction/hello")
	public String hello() {
		return "/introduction/hello";
	}
	@GetMapping("/introduction/direction")
	public String direction() {
		return "/introduction/direction";
	}
}
