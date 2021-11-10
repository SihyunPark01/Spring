package kr.co.kmarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.kmarket.service.ProductService;
import kr.co.kmarket.vo.CategoriesVo;
import kr.co.kmarket.vo.ProductVo;
import kr.co.kmarket.vo.SearchVo;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;
	
	
	@GetMapping("/product/cart")
	public String cart() {
		return "/product/cart";
	}

	@GetMapping("/product/list")
	public String list(ProductVo vo, Model model, String pg) {
		
		System.out.println("cate1 : "+vo.getCate1());
		System.out.println("cate2 : "+vo.getCate2());
		System.out.println("order : "+vo.getOrder());
		
		// 리스트 페이지 처리
		int currentPage = service.getCurrentPage(pg); 
		int start = service.getLimitStart(currentPage);
		int total = service.selectCountTotal(vo); //전체 게시물 개수니까 쿼리문 날려야 함 -- 쿼리문작업하고돌아와
		int pageStartNum = service.getPageStartNum(total, start);
		int lastPageNum = service.getLastPageNum(total);
		int groups[] = service.getPageGroup(currentPage, lastPageNum);
		
		
		vo.setStart(start);  //위에 있는 int start를 아래 selectProducts(vo)여기 vo에 담기위해서 vo.setStart(start) 선언해줘야함
		
		List<ProductVo> products = service.selectProducts(vo);
		CategoriesVo cateVo = service.selectCategoryTitle(vo);
		
		model.addAttribute("products", products);
		model.addAttribute("cateVo", cateVo);
		model.addAttribute("order", vo.getOrder());
		model.addAttribute("productCode", vo.getProductCode());
		
		model.addAttribute("pageStartNum", pageStartNum); 
		model.addAttribute("currentPage", currentPage); 
		model.addAttribute("lastPageNum", lastPageNum); 
		model.addAttribute("groups", groups); 

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
	public String search(SearchVo vo, Model model) {
		
		List<ProductVo> products = service.selectProductSearch(vo);
		model.addAttribute("products", products);
		model.addAttribute("keyword", vo.getKeyword());
		model.addAttribute("productCount", products.size());
		
		return "/product/search";
	}
	
	
	@GetMapping("/product/view")
	public String view(ProductVo vo, Model model) {
		
		ProductVo product = service.selectProduct(vo.getProductCode());
		
		model.addAttribute("product", product);
		
		return "/product/view";
	}
}
