package kr.co.sboard.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.sboard.vo.ArticleVo;
import kr.co.sboard.vo.FileVo;

@Repository
public interface BoardDao {
	
	public int insertArticle(ArticleVo vo);
	public void insertFile(FileVo vo);
	public void insertComment(ArticleVo vo);
	public ArticleVo selectArticle(int seq);
	public List<ArticleVo> selectArticles(int start); //쿼리문에 맵핑해야되니까 int start선언
	public List<ArticleVo> selectComments(int seq); 
	public int selectCountTotal();
	public FileVo selectFile(int fseq);
	public void updateArticle(ArticleVo vo);
	public void updateComment(int seq);
	public void updateFileDownload(int fseq);
	public void deleteArticle(int seq);
	public void deleteComment(int seq);

}
