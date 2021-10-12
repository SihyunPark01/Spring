package kr.co.ch02.sub1;

import org.springframework.stereotype.Component;

@Component  //이게 root-context.xml에 클래스 등록하는 작업이나 똑같음.
public class Speaker {

	public void soundUp() {
		System.out.println("Speaker soundUp...");
	}
	
	public void soundDown() {
		System.out.println("Speaker soundDown...");
	}
	
}
