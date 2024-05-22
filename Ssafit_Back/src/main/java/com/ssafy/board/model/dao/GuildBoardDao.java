package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.GuildBoard;

public interface GuildBoardDao {
	
	// 전체 게시글 목록 조회
	public List<GuildBoard> selectAll();

	// 게시글 등록
	public void insertBoard(GuildBoard guildBoard);
	
	// 게시글 하나 선택(PK)
	public GuildBoard selectOne(GuildBoard guildBoard);
	
	// 각 길드의 게시글 목록 조회
	public List<GuildBoard> selectAllByGuildName(String GuildName);
	
	// 본인의 전체 게시글 목록 조회
	public List<GuildBoard> selectAllByUserId(String userId);
	
	// 해당 길드에서 특정 유저의 게시글 목록 조회
	public List<GuildBoard> selectAllByGuildNameAndUserId(String GuildName, String userId);
	
	// 조회수 증가
	public void updateViewCnt(GuildBoard guildBoard);
	
	// 게시글 수정(작성날짜도 함께 최신화)
	public void updateBoard(GuildBoard guildBoard);
	
	// 게시글 삭제
	public void deleteBoard(GuildBoard guildBoard);
	
}
