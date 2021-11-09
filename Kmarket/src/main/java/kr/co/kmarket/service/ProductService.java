package kr.co.kmarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.dao.ProductDao;
import kr.co.kmarket.vo.ProductVo;

@Service
public class ProductService {

	@Autowired
	private ProductDao dao;
	
	
	public void insertProduct() {}
	public void selectProduct(){}
	public List<ProductVo> selectProducts(ProductVo vo){
		return dao.selectProducts(vo);
	}
	public void updateProduct(){}
	public void deleteProduct(){}
	
}
