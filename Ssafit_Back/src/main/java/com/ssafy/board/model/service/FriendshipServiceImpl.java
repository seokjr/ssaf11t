package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.FriendshipDao;
import com.ssafy.board.model.dto.Friendship;

@Service
public class FriendshipServiceImpl implements FriendshipService {

	private final FriendshipDao friendshipDao;

	public FriendshipServiceImpl(FriendshipDao friendshipDao) {
		this.friendshipDao = friendshipDao;
	}

	@Override
	public List<Friendship> selectAll() {
		return friendshipDao.selectAll();
	}

	@Override
	public void insertRequest(Friendship friendship) {
		friendshipDao.insertRequest(friendship);
	}

	@Override
	public void acceptRequest(Friendship friendship) {
		friendshipDao.acceptRequest(friendship);
	}

	@Override
	public void deleteFriendship(Friendship friendship) {
		friendshipDao.deleteFriendship(friendship);
	}

	@Override
	public List<Friendship> selectPendingFriends(String id) {
		return friendshipDao.selectPendingFriends(id);
	}

	@Override
	public List<Friendship> selectAcceptedFriends(String id) {
		return friendshipDao.selectAcceptedFriends(id);
	}

	@Override
	// 이 관계 이미 친구인가요?
	public boolean areFriends(Friendship friendship) {
		friendship.setStatus("accepted");
		if(friendshipDao.getFriendshipByUserIdsAndStatus(friendship)!=null) {
			return true;
		} else {
			Friendship f = friendship.reverseUserId();
			f.setStatus("accepted");
			if(friendshipDao.getFriendshipByUserIdsAndStatus(f)!=null) {
				return true;
			} else {
				return false;
			}
		}
		
		
	}
}