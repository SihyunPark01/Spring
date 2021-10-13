package kr.co.ch05.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.ch05.vo.UserVO;

@Repository
public class UserDao {
	
	@Inject
	private SqlSessionTemplate mybatis;
	
	public void insertUser(UserVO vo) {
		mybatis.insert("mapper.user.insertUser", vo); //vo안에 있는 이름에 맞춰서 #{}에 맵핑함.
	}
	public UserVO selectUser(String uid) {
		return mybatis.selectOne("mapper.user.selectUser", uid);
	
	}
	public List<UserVO> selectUsers() {
		
		//List<UserVO> users = mybatis.selectList("mapper.user.selectUsers");
		//return users;를 아래와같이 한줄로 축약
		
		return mybatis.selectList("mapper.user.selectUsers"); 
	}
	
	public void updateUser(UserVO vo) {
		mybatis.update("mapper.user.updateUser", vo);
		
	}
	public void deleteUser(String uid) {
		mybatis.delete("mapper.user.deleteUser", uid);
	
	}
	
}
