package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.User;

public interface UserService {
	//전체 사용자 목록 불러오기
	public List<User> getUserList();
	
	//사용자 등록하기
	public void signup(User user);
	
	//로그인 하기
	public User login(String id, String password);
	
	// 마이페이지 들어갈 때 쓸 것으로 1명 유저 가져오기 액세스 토큰에서 아이디 받기
	public User chooseOneUser(String id);
	
	// 이메일 중복 확인용(컨트롤러 코드 간략화)
	public User chooseOneUserByEmail(String email);
	
	// 유저 정보 수정
	public void changeInfo(User user);
	
	// 유저 정보 삭제
	public void removeUser(String userId);
}
