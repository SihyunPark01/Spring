package kr.co.kmarket.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.co.kmarket.service.ProductCartService;
import kr.co.kmarket.service.ProductService;
import kr.co.kmarket.vo.CategoriesVo;
import kr.co.kmarket.vo.MemberVo;
import kr.co.kmarket.vo.ProductCartVo;
import kr.co.kmarket.vo.ProductVo;
import kr.co.kmarket.vo.SearchVo;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;
	@Autowired
	private ProductCartService cartService;
	
	
	
	@GetMapping("/product/cart")
	public String cart() {
		return "/product/cart";
	}
	
	@ResponseBody
	@PostMapping("/product/cart")
	public String cart(ProductCartVo vo) {
		
		int result = cartService.selectCountCart(vo); //result값은 1또는 0임
		if(result == 0) {//장바구니에 상품이 없으면
			cartService.insertCart(vo);
		}
		
		//이게 왜 필요하냐면 view페이지의 **********ajax 처리하기 위함...
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		return new Gson().toJson(json);
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
	public String view(HttpSession sess, int productCode, Model model) {
		
		//현재 로그인 아이디 가져오기
		//MemberVo memberVo = (MemberVo) sess.getAttribute("sessMember");
		
		//String uid = memberVo.getUid();
		
		
		ProductVo product = service.selectProduct(productCode); 
		model.addAttribute("product", product); //강사님은 productVo에 담음 그래서 view페이지에 모두 productVo.~~~임 (나는 product.~~~이구)
		
		
		return "/product/view";
	}
}
