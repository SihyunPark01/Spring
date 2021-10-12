package kr.co.ch02.sub1;

import org.springframework.beans.factory.annotation.Autowired;

public class SamsungTV implements Tv{

	@Autowired
	private Speaker speaker;
	
	@Override
	public void powerOn() {
		System.out.println("SamsungTV powerOn...");
		
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV powerOff...");		
	}

	@Override
	public void chUp() {
		System.out.println("SamsungTV chUp...");
		
	}

	@Override
	public void chDown() {
		System.out.println("SamsungTV chDown...");		
		
	}

	@Override
	public void soundUp() {
		//���� ���� Speaker ��ü ����
		speaker.soundUp();
		
	}

	@Override
	public void soundDown() {
		//���� ���� Speaker ��ü ����		
		speaker.soundDown();
		
	}

	
}
