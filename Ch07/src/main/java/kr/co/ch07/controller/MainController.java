package kr.co.ch07.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.ch07.vo.UserVo;

@Controller
public class MainController {

	@GetMapping(value= {"/", "/index"})
	public String index(Model model) {

		String title = "스프링부트 타임리프 실습";
		String hello = "hello thymeleaf";
		
		UserVo user = new UserVo();
		user.setUid("a101");
		user.setName("홍길동");
		user.setHp("010-1234-1111");
		user.setAge(21);
		
		List<UserVo> users = new ArrayList<>();
		users.add(new UserVo("a101","김유신","010-1234-1111",25));
		users.add(new UserVo("a102","김춘추","010-1234-2222",32));
		users.add(new UserVo("a103","장보고","010-1234-3333",29));
		users.add(new UserVo("a104","강감찬","010-1234-4444",24));
		users.add(new UserVo("a105","이순신","010-1234-5555",22));
		
		
		model.addAttribute("title",title);
		model.addAttribute("hello",hello);
		model.addAttribute(user);
		model.addAttribute("users", users);
		
		return "/index";
	}

	@GetMapping("/include")
	public String include() {
		
		return "/include";
	}
	
}
