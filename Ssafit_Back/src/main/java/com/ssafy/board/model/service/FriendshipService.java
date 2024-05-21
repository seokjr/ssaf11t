package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.Friendship;

public interface FriendshipService {
	// 전체 목록 조회
	public List<Friendship> selectAll();
		
	// 친구 요청 넣음
	public void insertRequest(Friendship friendship);

	// 친구 요청 수락
	public void acceptRequest(Friendship friendship);

	// 친구 요청 거절/친구 삭제
	public void deleteFriendship(Friendship friendship);
		
	// 이미 친구인 상대 리스트 검색
	public List<Friendship> selectPendingFriends(String id);

	// 나한테 친구 요청중인 상대 리스트 검색
	public List<Friendship> selectAcceptedFriends(String id);
	
	// 이 관계 이미 친구인가요?
	public boolean areFriends(Friendship friendship);
	
}