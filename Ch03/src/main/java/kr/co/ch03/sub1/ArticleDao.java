package kr.co.ch03.sub1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //spring container(root-context)에 등록시키는 작업
public class ArticleDao {

	@Autowired
	private DaoAdvice advice;
	
	
	public void insertArticle() {
		advice.beforeAdvice1();
		System.out.println("핵심관심 -- insertArticle");
		advice.afterAdvice1();
	}
	public void selectArticle() {
		System.out.println("핵심관심 -- selectArticle");
	}
	public void updateArticle() {
		System.out.println("핵심관심 -- updateArticle");
	}
	public void deleteArticle() {
		System.out.println("핵심관심 -- deleteArticle");
	}

}
