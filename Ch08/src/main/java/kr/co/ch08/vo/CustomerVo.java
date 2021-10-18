package kr.co.ch08.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerVo {
	private int custid;
	private String name;
	private String address;
	private String phone;
}
