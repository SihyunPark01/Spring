package kr.co.ch02.sub1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/* 
 * 날짜 : 2021/10/11
 * 이름 : 박시현
 * 내용 : 스프링 IoC 실습하기
 * 
 * IoC(제어의 역행)
 * - 자바 객체를 생성하고 객체들 사이의 의존관계를 스프링 컨테이너로 처리하는 개념
 * - 스프링 IoC를 이용해서 객체간의 결합도를 완화
 * - IoC를 구현하는 기술이 DI(Dependency Injection)
 * - DI기법 3가지 중 annotation기법을 가장 많이 사용함
 * 
 * 
 * 
 * 요 페이지가 메인컨트롤러나 비슷한 페이지네~~~~!
*/

public class IocTest {
	
//	@Autowired //inject나 둘 다 가능. 중요한 어노테이션!
//	private LgTV ltv;
//	
//	@Inject
//	private SamsungTV stv;
	
	
	public static void main(String[] args) {
		
		// DI(Ioc를 구현하는 기술)를 활용하지 않은 객체 생성 (동적 생성)
		Tv tv1 = new LgTV();
		Tv tv2 = new SamsungTV();
		
		tv1.powerOn();
		tv1.chUp();
		tv1.powerOff();
		
		tv2.powerOn();
		tv2.chUp();
		tv2.powerOff();
		
	
		
		// 스프링 컨테이너의 객체를 가져와 실행하는 방식
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
