package kr.co.kmarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.dao.ProductCartDao;
import kr.co.kmarket.dao.ProductDao;
import kr.co.kmarket.vo.CategoriesVo;
import kr.co.kmarket.vo.ProductCartVo;
import kr.co.kmarket.vo.ProductVo;
import kr.co.kmarket.vo.SearchVo;

@Service
public class ProductCartService {

	@Autowired
	private ProductCartDao dao;
	
	public void insertCart(ProductCartVo vo) {
		dao.insertCart(vo);
	}
	public void selectCart() {}
	public void selectCarts(){}
	public void updateCarts(){}
	public void deleteCarts(){}
	
}
