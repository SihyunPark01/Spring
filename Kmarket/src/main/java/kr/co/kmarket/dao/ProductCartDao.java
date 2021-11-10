package kr.co.kmarket.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.CategoriesVo;
import kr.co.kmarket.vo.ProductCartVo;
import kr.co.kmarket.vo.ProductVo;
import kr.co.kmarket.vo.SearchVo;

@Repository
public interface ProductCartDao {
	
	public void insertCart(ProductCartVo vo);
	public void selectCart();
	public void selectCarts();
	public void updateCart();
	public void deleteCart();

}
