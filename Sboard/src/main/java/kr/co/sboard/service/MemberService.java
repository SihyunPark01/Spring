package kr.co.sboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sboard.dao.MemberDao;
import kr.co.sboard.vo.MemberVo;
import kr.co.sboard.vo.TermsVo;

@Service
public class MemberService {

	@Autowired
	private MemberDao dao;
	
	public void insertMember(MemberVo vo) {
		dao.insertMember(vo);
	}
	
	public TermsVo selectTerms() {
		return dao.selectTerms();
	}
	
	public MemberVo selectMember(String uid, String pass) {
		return dao.selectMember(uid, pass);
	}
	public List<MemberVo> selectMembers(){
		return dao.selectMembers();
	}
	
	public int selectCountUid(String uid) {
		return dao.selectCountUid(uid);
	};
	
	public int selectCountNick(String nick) {
		return dao.selectCountNick(nick);
	};
	
	public int selectCountEmail(String email) {
		return dao.selectCountEmail(email);
	};

	public int selectCountHp(String hp) {
		return dao.selectCountHp(hp);
	};
	
	public void updateMember(MemberVo vo){
		dao.updateMember(vo);
	}
	public void deleteMember(String uid){
		dao.deleteMember(uid);
	}
	
	
}
