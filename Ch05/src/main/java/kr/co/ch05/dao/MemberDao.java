package kr.co.ch05.dao;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;

public class MemberDao {

	@Inject
	private SqlSessionTemplate mybatis;
	
	public void insertMember() {}
	public void selectMember() {}
	public void selectMembers() {}
	public void updateMember() {}
	public void deleteMember() {}
	
	
}
