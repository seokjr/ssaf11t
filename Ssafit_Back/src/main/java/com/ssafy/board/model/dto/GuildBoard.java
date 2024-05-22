package com.ssafy.board.model.dto;

public class GuildBoard {
	private String guildName;
	private String userId;
	private String boardTitle;
	private String boardContent;
	private int viewCnt;
	private String regDate;
	
	public GuildBoard() {
		
	}
	
	public GuildBoard(String guildName, String userId, String boardTitle, String boardContent) {
		this.guildName = guildName;
		this.userId = userId;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
	}

	public GuildBoard(String guildName, String userId, String boardTitle, String boardContent, int viewCnt,
			String regDate) {
		this.guildName = guildName;
		this.userId = userId;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.viewCnt = viewCnt;
		this.regDate = regDate;
	}
	
	public GuildBoard(String guildName, String userId, String regDate) {
		this.guildName = guildName;
		this.userId = userId;
		this.regDate = regDate;
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

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "guild_boards [guildName=" + guildName + ", userId=" + userId + ", boardTitle=" + boardTitle
				+ ", boardContent=" + boardContent + ", viewCnt=" + viewCnt + ", regDate=" + regDate + "]";
	}
	
}