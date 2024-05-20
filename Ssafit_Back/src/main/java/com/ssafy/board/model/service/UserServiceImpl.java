package com.ssafy.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.UserDao;
import com.ssafy.board.model.dto.User;

@Service
public class UserServiceImpl implements UserService{
	
	private final UserDao userDao;
	
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> getUserList() {
		return userDao.selectAll();
	}

	@Override
	public void signup(User user) {
		userDao.insertUser(user);
	}

	@Override
	public User login(String id, String password) {
		Map<String, String> info = new HashMap<>();
		info.put("id", id);
		info.put("password", password);
		return userDao.selectOne(info);
	}

	@Override
	public User chooseOneUser(String id) {
		return userDao.selectUserByIdToken(id);
	}
	
	@Override
	public User chooseOneUserByEmail(String email) {
		return userDao.selectUserByEmail(email);
	}
	@Override
	public void changeInfo(User user) {
		userDao.updateUser(user);
	}

	@Override
	public void removeUser(String userId) {
		userDao.deleteUser(userId);
	}
	
	@Override
	public List<User> searchUser(String key, String word) {
		Map<String, String> info = new HashMap<>();
		info.put("key", key);
		info.put("word", word);
		return userDao.searchUser(info);
	}
}
