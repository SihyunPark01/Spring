package kr.co.ch08.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.ch08.vo.CustomerVo;

@Repository
public interface CustomerDao {

	public void insertCustomer(CustomerVo vo);
	public CustomerVo selectCustomer(int custid);
	public List<CustomerVo> selectCustomers();
	public void updateCustomer(CustomerVo vo);
	public void deleteCustomer(int custid);
	
	
}
