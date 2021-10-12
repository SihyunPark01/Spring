package kr.co.ch04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Component �����ص������� �ǹ̿� �°� 
@Controller
public class MainController {

	//"/"�� ���� �������ָ� ������������ ������
	@RequestMapping(value = {"/","/hello"}, method = RequestMethod.GET) //Ŭ���̾�Ʈ�� hello��� ��û�ϸ� ���� return���� ����Ǵ� ����
	public String hello() {
		return "hello";
	} //����Ʈ��Ʈ�ѷ��� �տ� �ּ�, �ڿ� Ȯ����"jsp"�� �ٿ��ٰž�
	
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome() {
		return "welcome";
	}
	
	@GetMapping(value = "/greeting")
	public String greeting() {
		return "greeting";
	}
}
