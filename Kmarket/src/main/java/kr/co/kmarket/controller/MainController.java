package kr.co.kmarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kmarket.service.MainService;
import kr.co.kmarket.vo.CategoriesVo;

@Controller
public class MainController {

	@Autowired
	private MainService service;
	
	@GetMapping(value= {"/","/index"})
	public String index(Model model) {
	
		//이 방법 하지말고
		//List<CategoriesVo> cates = service.selectCategories();
		//model.addAttribute("cates", cates);
		
		return "/index";
	}
	
	@ResponseBody
	@GetMapping("/getCategories")
	public List<CategoriesVo> getCategories() {
		
		List<CategoriesVo> cates = service.selectCategories();
		return cates; // /getCategories 링크 들어가서 확인해봐
		
	}
	
}
