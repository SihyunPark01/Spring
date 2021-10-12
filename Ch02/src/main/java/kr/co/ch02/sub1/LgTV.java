package kr.co.ch02.sub1;

import org.springframework.beans.factory.annotation.Autowired;

public class LgTV implements Tv{

	@Autowired
	private Speaker speaker; //new 객체 생성하지 않아도 @autowired나 @inject로 객체를 주입받을 수 있음
	
	@Override
	public void powerOn() {
		System.out.println("LgTV powerOn...");
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV powerOff...");		
	}

	@Override
	public void chUp() {
		System.out.println("LgTV chUp...");
		//주입 받은 Speaker 객체 실행
	}

	@Override
	public void chDown() {
		System.out.println("LgTV chDown...");
	}

	@Override
	public void soundUp() {
		//주입 받은 Speaker 객체 실행
		speaker.soundUp();
	}

	@Override
	public void soundDown() {
		//주입 받은 Speaker 객체 실행		
		speaker.soundDown();
	}

}
