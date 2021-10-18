package kr.co.ch08.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.ch08.vo.MemberVo;
import kr.co.ch08.vo.UserVo;

@Repository
public interface MemberDao { //class대신 interface구현하는이유 : user.xml에 namespaces로 클래스명 잡아주고 id값으로 함수명 바로 잡아줄거라
	//굳이 class선언하고 mybatis 불러올 필요 없음.
	
	public void insertMember(MemberVo vo);
	public MemberVo selectMember(String uid);
	public List<MemberVo> selectMembers();
	public void updateMember(MemberVo vo);
	public void deleteMember(String uid);
	
}



