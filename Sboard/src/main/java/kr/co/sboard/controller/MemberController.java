package kr.co.sboard.controller;

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

import kr.co.sboard.service.MemberService;
import kr.co.sboard.vo.MemberVo;
import kr.co.sboard.vo.TermsVo;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	
	@GetMapping("/member/login")
	public String login() {
		return "/member/login";
	}
	
	@PostMapping("/member/login")
	public String login(HttpSession sess, String uid, String pass) {
		
		MemberVo vo = service.selectMember(uid, pass);
		
		if(vo == null) {
			//System.out.println("회원이 아닙니다.");이렇게 콘솔보면서 테스트하면서 진행
			//회원이 아닐경우
			return "redirect:/member/login?success=100";
		}else {
			//System.out.println("회원이 맞습니다.");
			//회원이 맞을경우
			sess.setAttribute("sessMember", vo);
			return "redirect:/list";
		}
	}
	
	@GetMapping("/member/logout")
	public String logout(HttpSession sess) {
		sess.invalidate(); //현재 사용자 정보객체 세션 삭제
		return "redirect:/member/login?success=102";
	}
	
	
	
	
	@GetMapping("/member/terms")
	public String terms(Model model) {
		
		TermsVo vo = service.selectTerms();
		model.addAttribute(vo);
		
		return "/member/terms";
	}
	
	@GetMapping("/member/register")
	public String register() {
		return "/member/register";
	}
	
	
	@PostMapping("/member/register")
	public String register(MemberVo vo, HttpServletRequest req) {
		
		String regip = req.getRemoteAddr();
		vo.setRegip(regip);
		
		service.insertMember(vo);
		
		return "redirect:/member/login?success=101";
	}
	
	@ResponseBody   /*response객체에 실어서 전송, 자바객체를 HTTP요청의 바디내용으로 매핑하여 클라이언트로 전송*/
	@GetMapping("/member/checkUid")
	public String checkUid(String uid){//()안에 파라미터 이름 들어가쟈냐
		//System.out.println("uid :" + uid); //항상 확인작업을 거쳐라 근데 콘솔창에 안뜨는디
		
		int result = service.selectCountUid(uid);
		//System.out.println("result:"+result); // result값을 ajax선언한 json data로 보내줘야하므로 아래 추가
		
		//Json 객체 생성 --- Gson 라이브러리 추가 
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		return new Gson().toJson(json);
		//return "/member/register";
	}
	
	@ResponseBody   /*response객체에 실어서 전송, 자바객체를 HTTP요청의 바디내용으로 매핑하여 클라이언트로 전송*/
	@GetMapping("/member/checkNick")
	public String checkNick(String nick){//()안에 파라미터 이름 들어가쟈냐
		
		int result = service.selectCountNick(nick);
		
		//Json 객체 생성 --- Gson 라이브러리 추가 
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		return new Gson().toJson(json);
		//return "/member/register";
	}
	
	
	@ResponseBody   
	@GetMapping("/member/checkEmail")
	public String checkEmail(String email){
		
		int result = service.selectCountEmail(email);
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		return new Gson().toJson(json);
	}
	
	@ResponseBody   /*response객체에 실어서 전송, 자바객체를 HTTP요청의 바디내용으로 매핑하여 클라이언트로 전송*/
	@GetMapping("/member/checkHp")
	public String checkHp(String hp){//()안에 파라미터 이름 들어가쟈냐
		
		int result = service.selectCountHp(hp);
		
		//Json 객체 생성 --- Gson 라이브러리 추가 
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		return new Gson().toJson(json);
		//return "/member/register";
	}
	
	
	
	
	
	
	
	
}
