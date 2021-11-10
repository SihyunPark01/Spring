package kr.co.kmarket.dao;


import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.ProductCartVo;

@Repository
public interface ProductCartDao {
	
	public void insertCart(ProductCartVo vo);
	public int selectCountCart(ProductCartVo vo);
	public void selectCart();
	public void selectCarts();
	public void updateCart();
	public void deleteCart();

}
