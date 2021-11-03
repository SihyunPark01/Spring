package kr.co.kmarket.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kmarket.admin.service.AdminProductService;
import kr.co.kmarket.vo.ProductCate1Vo;
import kr.co.kmarket.vo.ProductCate2Vo;

@Controller
public class AdminProductController {

	@Autowired
	private AdminProductService service;
	
	
	@GetMapping("/admin/product/list")
	public String list() {
		return "/admin/product/list";
	}
	
	@GetMapping("/admin/product/register")
	public String register() {
		return "/admin/product/register";
	}
	
	@ResponseBody        //밑에 맵핑주소가 페이지가 아니라 데이터이고 이걸 바로 보내줘야할때 responsbody를 선언.
	@GetMapping("/admin/product/getCate1")
	public List<ProductCate1Vo> getCate1() {
		
		List<ProductCate1Vo> cate1s = service.selectCate1();
		
		return cate1s; //이렇게해도 바로 json으로 변환시켜줌 but dispatcher가 뷰페이지로 착각함 그래서 @responsebody를 해줘야함
	}
	
	@ResponseBody        //밑에 맵핑주소가 페이지가 아니라 데이터이고 이걸 바로 보내줘야할때 responsbody를 선언.
	@GetMapping("/admin/product/getCate2")
	public List<ProductCate2Vo> getCate2(int cate1) {
		
		List<ProductCate2Vo> cate2s = service.selectCate2(cate1);
		
		return cate2s; //이렇게해도 바로 json으로 변환시켜줌 but dispatcher가 뷰페이지로 착각함 그래서 @responsebody를 해줘야함
	}
}
