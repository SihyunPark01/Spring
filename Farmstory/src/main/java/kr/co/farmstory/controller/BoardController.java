package kr.co.farmstory.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.co.farmstory.service.BoardService;
import kr.co.farmstory.vo.ArticleVo;
import kr.co.farmstory.vo.FileVo;
import kr.co.farmstory.vo.MemberVo;


@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	
	@GetMapping("/board/list")
	public String list(String pg, Model model, String group, String cate) {
		
		//페이지 처리
		int currentPage = service.getCurrentPage(pg); 
		int start = service.getLimitStart(currentPage);
		int total = service.selectCountTotal(cate); //전체 게시물 개수니까 쿼리문 날려야 함 -- 쿼리문작업하고돌아와
		int pageStartNum = service.getPageStartNum(total, start);
		int lastPageNum = service.getLastPageNum(total);
		int groups[] = service.getPageGroup(currentPage, lastPageNum);
		
		List<ArticleVo> articles =service.selectArticles(start ,cate);
		
		model.addAttribute("group", group);
		model.addAttribute("cate", cate);
		
		model.addAttribute("articles", articles);
		model.addAttribute("pageStartNum", pageStartNum); 
		model.addAttribute("currentPage", currentPage); 
		model.addAttribute("lastPageNum", lastPageNum); 
		model.addAttribute("groups", groups); 
		
		return "/board/list";
	}
	
	@GetMapping("/board/write")
	public String write(Model model, String group, String cate) {
		
		model.addAttribute("group", group);
		model.addAttribute("cate", cate);
		return "/board/write";
	}
	
	@PostMapping("/board/write")
	public String write(HttpServletRequest req, Model model, String group, String cate, ArticleVo vo) {
		
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
			vo.setFile(1);
			seq = service.insertArticle(vo);
			FileVo fvo = service.fileUpload(vo.getFname(), seq);
			service.insertFile(fvo);
		}
		
		return "redirect:/board/list?group="+group+"&cate="+cate;
	}
	
	
	@GetMapping("/board/view")
	public String view(HttpSession sess, Model model, String group, String cate, int seq) {
		
		MemberVo mvo = (MemberVo) sess.getAttribute("sessMember");
		
		model.addAttribute("group", group);
		model.addAttribute("cate", cate);
		
		ArticleVo vo = service.selectArticle(seq);
		List<ArticleVo> comments = service.selectComments(seq);
		
		model.addAttribute(vo);
		model.addAttribute("comments",comments);
		
		if(mvo == null) {
			return "redirect:/member/login?success=102";
		}else {
			return "/board/view";
		}
	
	}
	
	@GetMapping("/board/modify")
	public String modify(Model model, String group, String cate, int seq) {
		ArticleVo vo = service.selectArticle(seq);
		model.addAttribute("group", group);
		model.addAttribute("cate", cate);
		model.addAttribute(vo);
		return "/board/modify";
	}
	
	@PostMapping("/board/modify")
	public String modify(Model model, String group, ArticleVo vo) {
		
		int seq = vo.getSeq();
		model.addAttribute("vo",vo);
		
		model.addAttribute("group", group);
		model.addAttribute("cate", vo.getCate());
		
		service.updateArticle(vo);
		
		if(vo.getFname().isEmpty()) { 
			vo.setFile(0);
			seq = service.insertArticle(vo); //확인용 할땐 잠시 주석처리 / 작성글 삽입하고 글번호를 받아야함
		} else {
			vo.setFile(1);
			seq = service.insertArticle(vo);
			FileVo fvo = service.fileUpload(vo.getFname(), seq);
			service.insertFile(fvo);
		}
		return "redirect:/board/view?group="+group+"&cate="+vo.getCate()+"&seq="+vo.getSeq();
	}
	
	@GetMapping("/board/delete")
	public String delete(Model model, String group, String cate, int seq) {
		service.deleteArticle(seq);
		model.addAttribute("group", group);
		model.addAttribute("cate", cate);
		return "redirect:/board/list?group="+group+"&cate="+cate;
	}
	
	@PostMapping("/board/insertComment")
	public String insertComment(Model model, String group, String cate, ArticleVo vo) {
		
		service.insertComment(vo);
		
		model.addAttribute("group", group);
		model.addAttribute("cate", cate);
		return "redirect:/board/view?group="+group+"&cate="+cate+"&seq="+vo.getParent();
	}
	
	@GetMapping("/board/deleteComment")
	public String deleteComment(Model model, String group, String cate, int seq, int parent) {
		service.deleteComment(seq);
		model.addAttribute("group", group);
		model.addAttribute("cate", cate);
		return "redirect:/board/view?group="+group+"&cate="+cate+"&seq="+parent;
	}

	
	@PostMapping("/board/updateComment")
	public String updateComment(HttpServletRequest req, ArticleVo vo, Model model, String content, String group, String cate) {
		
		 int seq = vo.getSeq();
		 int parent = vo.getParent();

		 service.updateComment(seq, content);
		 
		model.addAttribute("group", group);
		model.addAttribute("cate", cate);
		model.addAttribute("content", content);
		
		return "redirect:/board/view?group="+group+"&cate="+cate+"&seq="+parent;
		//return "/member/register"
		
	}
	
}
