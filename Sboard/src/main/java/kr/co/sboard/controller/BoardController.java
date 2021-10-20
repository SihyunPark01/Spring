package kr.co.sboard.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.co.sboard.service.BoardService;
import kr.co.sboard.vo.ArticleVo;
import kr.co.sboard.vo.FileVo;
import kr.co.sboard.vo.MemberVo;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	
	
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
	public String list(String pg, Model model) {
		
		//페이지 처리
		int currentPage = service.getCurrentPage(pg); 
		int start = service.getLimitStart(currentPage);
		int total = service.selectCountTotal(); //전체 게시물 개수니까 쿼리문 날려야 함 -- 쿼리문작업하고돌아와
		int pageStartNum = service.getPageStartNum(total, start);
		int lastPageNum = service.getLastPageNum(total);
		int groups[] = service.getPageGroup(currentPage, lastPageNum);
		
		//original
		List<ArticleVo> articles = service.selectArticles(start);
		
		model.addAttribute("articles", articles); //뷰페이지에서 참조하기 위한 작업
		model.addAttribute("pageStartNum", pageStartNum); 
		model.addAttribute("currentPage", currentPage); 
		model.addAttribute("lastPageNum", lastPageNum); 
		model.addAttribute("groups", groups); 
		
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
	
	@PostMapping("/write")
	public String write(HttpServletRequest req, ArticleVo vo) {
		
		String regip = req.getRemoteAddr();
		vo.setRegip(regip);
		
		//작성글 Insert
		int seq = 0; 
		
		if(vo.getFname().isEmpty()) { // 스부는 !=null이 먹히지 않거든..정답은.isEmpty()다!
			// 파일을 첨부 안했을 때
			vo.setFile(0);
			seq = service.insertArticle(vo); //확인용 할땐 잠시 주석처리 / 작성글 삽입하고 글번호를 받아야함
			//System.out.println("파일첨부 안함"); //요렇게 먼저 확인 작업 꼭하기
		} else {
			// 파일을 첨부 했을 때 
			//System.out.println("파일첨부 함");  이부분 모두 BoardService에 비즈니스 처리 로직 구현메서드로 옮김
			FileVo fvo = service.fileUpload(vo.getFname(), seq);
			service.insertFile(fvo);
		}
		//System.out.println("파일 첨부 완료...");
		
		return "redirect:/list";
	}
	
	@GetMapping("/modify")
	public String modify() {
		return "/modify";
	}
}
