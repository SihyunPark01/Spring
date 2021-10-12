package kr.co.ch04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Component 선언해도되지만 의미에 맞게 
@Controller
public class MainController {

	//"/"를 같이 지정해주면 시작페이지로 설정됨
	@RequestMapping(value = {"/","/hello"}, method = RequestMethod.GET) //클라이언트가 hello라고 요청하면 밑의 return값이 수행되는 것임
	public String hello() {
		return "hello";
	} //프론트컨트롤러가 앞에 주소, 뒤에 확장자"jsp"를 붙여줄거야
	
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome() {
		return "welcome";
	}
	
	@GetMapping(value = "/greeting")
	public String greeting() {
		return "greeting";
	}
}
