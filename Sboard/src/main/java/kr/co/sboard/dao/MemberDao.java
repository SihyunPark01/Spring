package kr.co.sboard.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.sboard.vo.MemberVo;
import kr.co.sboard.vo.TermsVo;

@Repository
public interface MemberDao {
	
	public void insertMember(MemberVo vo);
	public TermsVo selectTerms();
	public MemberVo selectMember(String uid, String pass); //그래야 쿼리문에 uid, pass에 각각 맵핑되지..
	public List<MemberVo> selectMembers();
	
	public int selectCountUid(String uid);
	public int selectCountNick(String nick);
	public int selectCountEmail(String email);
	public int selectCountHp(String hp);
	
	public void updateMember(MemberVo vo);
	public void deleteMember(String uid);

}
