package kr.co.farmstory.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import kr.co.farmstory.vo.ArticleVo;
import kr.co.farmstory.vo.FileVo;

@Repository
public interface BoardDao {
	
	public int insertArticle(ArticleVo vo);
	public void insertFile(FileVo vo);
	public ArticleVo selectArticle(int seq); 
	public List<ArticleVo> selectArticles(int start, String cate);
	public FileVo selectFile(int fseq);
	
	public int selectCountTotal(String cate);
	public void updateArticle(ArticleVo vo);
	public void deleteArticle(int seq);
}
