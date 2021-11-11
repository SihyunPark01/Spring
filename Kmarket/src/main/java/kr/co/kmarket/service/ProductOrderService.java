package kr.co.kmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.dao.ProductOrderDao;
import kr.co.kmarket.vo.ProductOrderVo;

@Service
public class ProductOrderService {

	@Autowired
	private ProductOrderDao dao;
	
	public void insertOrder(ProductOrderVo vo) {
			dao.insertOrder(vo);
	}
	public void insertOrderDetail(int orderId, int productCode) {
		dao.insertOrderDetail(orderId, productCode);
	}
	
	
	
	public void selectOrder(){}
	public void selectOrders(){}
	public void updateOrder(){}
	public void deleteOrder(){}  
	
	
	
}
