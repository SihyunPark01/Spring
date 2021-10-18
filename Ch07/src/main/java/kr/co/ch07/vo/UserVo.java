package kr.co.ch07.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {
	
	private String uid;
	private String name;
	private String hp;
	private int age;
	
	
	//@AllArgsConstructor이 의미하는 바 흐흐흐
//	public UserVo(String uid, String name, String hp, int age) {
//		this.uid = uid;
//		this.name = name;
//		this.hp = hp;
//		this.age = age;
//	}
	
	
	
	
}
