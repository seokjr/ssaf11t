package com.ssafy.board.model.dto;

public class Guild {
	private String guildName;
	private String tag;
	private String regDate;
	
	public Guild() {
		
	}
	
	public Guild(String guildName, String tag) {
		this.guildName = guildName;
		this.tag = tag;
	}
	
	public Guild(String guildName, String tag, String regDate) {
		this.guildName = guildName;
		this.tag = tag;
		this.regDate = regDate;
	}

	public String getGuildName() {
		return guildName;
	}

	public void setGuildName(String guildName) {
		this.guildName = guildName;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "guilds [guildName=" + guildName + ", tag=" + tag + ", regDate=" + regDate + "]";
	}
	
}