package kr.co.kmarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.kmarket.service.MainService;
import kr.co.kmarket.vo.CategoriesVo;

@Controller
public class MainController {

	@Autowired
	private MainService service;
	
	@GetMapping(value= {"/","/index"})
	public String index(Model model) {
	
		List<CategoriesVo> cates = service.selectCategories();
		model.addAttribute("cates", cates);
		
		return "/index";
	}
	
	@GetMapping("/getCategories")
	public void getCategories() {
		
		
	}
	
}
