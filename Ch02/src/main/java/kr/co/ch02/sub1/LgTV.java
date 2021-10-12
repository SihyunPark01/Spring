package kr.co.ch02.sub1;

import org.springframework.beans.factory.annotation.Autowired;

public class LgTV implements Tv{

	@Autowired
	private Speaker speaker; //new ��ü �������� �ʾƵ� @autowired�� @inject�� ��ü�� ���Թ��� �� ����
	
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
		//���� ���� Speaker ��ü ����
	}

	@Override
	public void chDown() {
		System.out.println("LgTV chDown...");
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
