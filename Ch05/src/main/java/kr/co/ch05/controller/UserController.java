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
	public String list(Model model) {//req ��ü ��� model ��ü�� ��
		
		List<UserVO> users = service.selectUsers();
		//������ model ��ü�� �̿��ؼ� ������Ʈ�� �ڷ���� --- �̰� jsp������ Httpservlet req ��ü
		model.addAttribute("users", users);      //model.addAttribute(users); �̷��Ը� �����ص� ��
		return "/user/list";
	}
		
	@RequestMapping(value = "/user/register", method = RequestMethod.GET)
	public String register() {
		return "/user/register";
	}
	
	@PostMapping("/user/register")
	public String register(UserVO vo) { 

		service.insertUser(vo);
		return "redirect:/user/register"; //post��û������ forward�� �ȵ�...
		
		//�̰� �ַܼ� Ȯ���Ϸ��� �ѰŰ�
//		System.out.println("uid : "+vo.getUid());
//		System.out.println("name : "+vo.getName());
//		System.out.println("hp : "+vo.getHp());
//		System.out.println("age : "+vo.getAge());
		
		//�̰� jsp��Ÿ�����ݾ�? ���̻� �̷��� ������ �ʿ� ����
//���̻� �̷��� �����൵ ��...���� ��ȣ�ӿ� ������ �������ָ� ��--�� ��ȣ�� �����鵵 ��������ϱ� bean��ü�� UserVO���� ������		
//		String uid = req.getParameter("uid");
//		String name = req.getParameter("name");
//		String hp = req.getParameter("hp");
//		String age = req.getParameter("age");
	}
	
	@GetMapping(value = "/user/modify")
	public String modify(String uid, Model model) { //(UserVO vo)�ص� ���� �ٵ� uid�� ����ҰŴϱ� ����...
		
		UserVO user = service.selectUser(uid);
		model.addAttribute(user); //��ü���� ǥ�� ���ϸ� �ҹ��ڷ� �����ϴ� ��üŸ��. ������ ("user", user)�� �ؾ������� �̰͵� ����������
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
