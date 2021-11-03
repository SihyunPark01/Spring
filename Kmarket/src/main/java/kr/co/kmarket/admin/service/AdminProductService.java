package kr.co.kmarket.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.admin.dao.AdminProductDao;
import kr.co.kmarket.vo.ProductCate1Vo;
import kr.co.kmarket.vo.ProductCate2Vo;

@Service
public class AdminProductService {

	@Autowired
	private AdminProductDao dao;
	
	public void insertProduct() {}
	public void selectProduct(){}
	public void selectProducts(){}
	public void updateProduct(){}
	public void deleteProduct(){}
	
	public List<ProductCate1Vo> selectCate1(){
		
			return dao.selectCate1();
	}
	public List<ProductCate2Vo> selectCate2(int cate1){
		
			return dao.selectCate2(cate1);
	}
	
	
}
