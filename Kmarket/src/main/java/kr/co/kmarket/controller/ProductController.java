package kr.co.kmarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

	@GetMapping("/product/cart")
	public String cart() {
		return "/product/cart";
	}
	@GetMapping("/product/list")
	public String list() {
		return "/product/list";
	}
	@GetMapping("/product/order")
	public String order() {
		return "/product/order";
	}
	@GetMapping("/product/order-complete")
	public String orderComplete() {
		return "/product/order-complete";
	}
	@GetMapping("/product/search")
	public String search() {
		return "/product/search";
	}
	@GetMapping("/product/view")
	public String view() {
		return "/product/view";
	}
}
