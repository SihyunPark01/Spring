package kr.co.kmarket.dao;

import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.MemberTermsVo;
import kr.co.kmarket.vo.MemberVo;

@Repository
public interface MemberDao {

	public MemberVo insertMember(MemberVo vo);
	public MemberVo selectMember(String uid, String pass);
	public MemberTermsVo selectTerms();
	
}
