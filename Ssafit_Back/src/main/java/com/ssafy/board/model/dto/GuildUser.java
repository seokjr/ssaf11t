package com.ssafy.board.model.dto;

public class GuildUser {
	private String guildName;
	private String userId;
	private String status;
	
	public GuildUser() {
		
	}
	
	public GuildUser(String guildName, String userId) {
		this.guildName = guildName;
		this.userId = userId;
	}

	public GuildUser(String guildName, String userId, String status) {
		this.guildName = guildName;
		this.userId = userId;
		this.status = status;
	}

	public String getGuildName() {
		return guildName;
	}

	public void setGuildName(String guildName) {
		this.guildName = guildName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "guild_users [guildName=" + guildName + ", userId=" + userId + ", status=" + status + "]";
	}
	
}