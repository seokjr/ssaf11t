package com.ssafy.board.model.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.board.model.dto.User;

public interface UserDao {
	// 전체 유저 가져오기
	public List<User> selectAll();
	
	// 유저 등록하기
	public void insertUser(User user);
	
	// 로그인할때 쓸 기능으로 id랑 password로 유저 가져오기
	public User selectOne(Map<String, String> info);
	
	// 마이페이지할 때 쓸 기능으로 userId 를 토큰에서 가져와서 일치하는지 확인하고 가져오기
	public User selectUserByIdToken(String id);
	
	// 이메일 중복 확인용(컨트롤러 코드 간략화)
	public User selectUserByEmail(String email);
	
	// 유저 정보 수정용
	public void updateUser(User user);
	
	// 유저 삭제
	public void deleteUser(String userId);
}