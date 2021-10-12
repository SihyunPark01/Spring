package kr.co.ch02.sub1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/* 
 * ��¥ : 2021/10/11
 * �̸� : �ڽ���
 * ���� : ������ IoC �ǽ��ϱ�
 * 
 * IoC(������ ����)
 * - �ڹ� ��ü�� �����ϰ� ��ü�� ������ �������踦 ������ �����̳ʷ� ó���ϴ� ����
 * - ������ IoC�� �̿��ؼ� ��ü���� ���յ��� ��ȭ
 * - IoC�� �����ϴ� ����� DI(Dependency Injection)
 * - DI��� 3���� �� annotation����� ���� ���� �����
 * 
 * 
 * 
 * �� �������� ������Ʈ�ѷ��� ����� ��������~~~~!
*/

public class IocTest {
	
//	@Autowired //inject�� �� �� ����. �߿��� ������̼�!
//	private LgTV ltv;
//	
//	@Inject
//	private SamsungTV stv;
	
	
	public static void main(String[] args) {
		
		// DI(Ioc�� �����ϴ� ���)�� Ȱ������ ���� ��ü ���� (���� ����)
		Tv tv1 = new LgTV();
		Tv tv2 = new SamsungTV();
		
		tv1.powerOn();
		tv1.chUp();
		tv1.powerOff();
		
		tv2.powerOn();
		tv2.chUp();
		tv2.powerOff();
		
	
		
		// ������ �����̳��� ��ü�� ������ �����ϴ� ���
		ApplicationContext ctx = new GenericXmlApplicationContext("root-context.xml");
		
		Tv ltv= (Tv) ctx.getBean("ltv");
		Tv stv= (Tv) ctx.getBean("stv");
		
		ltv.powerOn();
		ltv.chDown();
		ltv.soundDown();
		ltv.powerOff();
		
		stv.powerOn();
		stv.chDown();
		stv.soundUp();
		stv.powerOff();
		
	}
}
