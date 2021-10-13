package kr.co.ch05.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.ch05.dao.UserDao;
import kr.co.ch05.vo.UserVO;

@Service
public class UserService {


	@Inject
	private UserDao dao;
	
	public void insertUser(UserVO vo) {
		dao.insertUser(vo);
	}
	public UserVO selectUser(String uid) {
		return dao.selectUser(uid);
	}
	public List<UserVO> selectUsers() {
//		List<UserVO> users = dao.selectUsers();
//		return users
		return dao.selectUsers();
	}
	public void updateUser(UserVO vo) {
		dao.updateUser(vo);
	}
	public void deleteUser(String uid) {
		dao.deleteUser(uid);
	}	
}
