package com.ssafy.board.model.dto;

public class Friendship {
	private int friendshipId;
	private String user1Id;
	private String user2Id;
	private String status;
	
	public Friendship() {
	}

	public Friendship(int friendshipId, String user1Id, String user2Id, String status) {
		this.friendshipId = friendshipId;
		this.user1Id = user1Id;
		this.user2Id = user2Id;
		this.status = status;
	}

	public Friendship(String user1Id, String user2Id, String status) {
		this.user1Id = user1Id;
		this.user2Id = user2Id;
		this.status = status;
	}
	
	public Friendship(String user1Id, String user2Id) {
		this.user1Id = user1Id;
		this.user2Id = user2Id;
	}

	public int getFriendshipId() {
		return friendshipId;
	}

	public void setFriendshipId(int friendshipId) {
		this.friendshipId = friendshipId;
	}

	public String getUser1Id() {
		return user1Id;
	}

	public void setUser1Id(String user1Id) {
		this.user1Id = user1Id;
	}

	public String getUser2Id() {
		return user2Id;
	}

	public void setUser2Id(String user2Id) {
		this.user2Id = user2Id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "friendship [friendshipId=" + friendshipId + ", user1Id=" + user1Id + ", user2Id=" + user2Id
				+ ", status=" + status + "]";
	}
	
}
