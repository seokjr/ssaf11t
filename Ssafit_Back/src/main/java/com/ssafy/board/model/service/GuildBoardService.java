package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.GuildBoard;

public interface GuildBoardService {
	
	// 전체 게시글 목록 조회
	public List<GuildBoard> selectAll();

	// 게시글 등록
	public void createBoard(GuildBoard guildBoard);
		
	// 게시글 하나 선택(PK)
	public GuildBoard readBoard(GuildBoard guildBoard);
		
	// 각 길드의 게시글 목록 조회
	public List<GuildBoard> getListByGuildName(String GuildName);
		
	// 본인의 전체 게시글 목록 조회
	public List<GuildBoard> getListByUserId(String userId);
		
	// 해당 길드에서 특정 유저의 게시글 목록 조회
	public List<GuildBoard> getListAllByGuildNameAndUserId(String GuildName, String userId);
		
	// 게시글 수정(작성날짜도 함께 최신화)
	public void updateBoard(GuildBoard guildBoard);
		
	// 게시글 삭제
	public void deleteBoard(GuildBoard guildBoard);

}
