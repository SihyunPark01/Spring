package kr.co.ch03.sub1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //spring container(root-context)�� ��Ͻ�Ű�� �۾�
public class ArticleDao {

	@Autowired
	private DaoAdvice advice;
	
	
	public void insertArticle() {
		advice.beforeAdvice1();
		System.out.println("�ٽɰ��� -- insertArticle");
		advice.afterAdvice1();
	}
	public void selectArticle() {
		System.out.println("�ٽɰ��� -- selectArticle");
	}
	public void updateArticle() {
		System.out.println("�ٽɰ��� -- updateArticle");
	}
	public void deleteArticle() {
		System.out.println("�ٽɰ��� -- deleteArticle");
	}

}
