package kr.co.kmarket.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.ProductVo;

@Repository
public interface ProductDao {
	
	public void insertProduct();
	public void selectProduct();
	public List<ProductVo> selectProducts(ProductVo vo);
	public void updateProduct();
	public void deleteProduct();
	

}
