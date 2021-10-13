package kr.co.ch05.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.ch05.service.UserService;
import kr.co.ch05.vo.UserVO;

@Controller
public class UserController {

	
	@Autowired
	private UserService service;
	
	
	@GetMapping("/user/list")
	public String list(Model model) {//req 객체 대신 model 객체를 씀
		
		List<UserVO> users = service.selectUsers();
		//스프링 model 객체를 이용해서 컴포넌트간 자료공유 --- 이게 jsp에서는 Httpservlet req 객체
		model.addAttribute("users", users);      //model.addAttribute(users); 이렇게만 선언해도 됨
		return "/user/list";
	}
		
	@RequestMapping(value = "/user/register", method = RequestMethod.GET)
	public String register() {
		return "/user/register";
	}
	
	@PostMapping("/user/register")
	public String register(UserVO vo) { 

		service.insertUser(vo);
		return "redirect:/user/register"; //post요청에서는 forward가 안됨...
		
		//이건 콘솔로 확인하려고 한거고
//		System.out.println("uid : "+vo.getUid());
//		System.out.println("name : "+vo.getName());
//		System.out.println("hp : "+vo.getHp());
//		System.out.println("age : "+vo.getAge());
		
		//이게 jsp스타일이잖아? 더이상 이렇게 선언할 필요 없음
//더이상 이렇게 안해줘도 됨...위에 괄호속에 변수로 선언해주면 됨--그 괄호속 변수들도 보기싫으니까 bean객체인 UserVO만들어서 선언해		
//		String uid = req.getParameter("uid");
//		String name = req.getParameter("name");
//		String hp = req.getParameter("hp");
//		String age = req.getParameter("age");
	}
	
	@GetMapping(value = "/user/modify")
	public String modify(String uid, Model model) { //(UserVO vo)해도 되지 근데 uid만 사용할거니까 굳이...
		
		UserVO user = service.selectUser(uid);
		model.addAttribute(user); //객체명을 표기 안하면 소문자로 시작하는 객체타입. 보통은 ("user", user)로 해야하지만 이것도 생략가능함
		return "/user/modify";
	}
		
	@PostMapping(value = "/user/modify")
	public String modify(UserVO vo) {
			
		service.updateUser(vo);
		return "redirect:/user/list";
	}
	
	@GetMapping(value = "/user/delete")
	public String delete(String uid) {
		
		service.deleteUser(uid);
		return "redirect:/user/list";
	}
	
}
