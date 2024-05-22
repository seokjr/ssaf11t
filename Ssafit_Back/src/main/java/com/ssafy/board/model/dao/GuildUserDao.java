package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.GuildUser;

public interface GuildUserDao {
	
	// 전체 정보 조회
	public List<GuildUser> selectAll();
	
	// 길드를 생성한/가입한 유저 정보 입력
	public void insertGuildUser(GuildUser guildUser);
	
	// 길드에 가입한 유저 목록
	public List<GuildUser> selectUserByGuildName(String guildName);
	
	// 해당 유저가 가입한 길드 목록
	public List<GuildUser> selectGuildByUserId(String userId);
	
	// 해당 길드명과 유저 아이디 조합으로 검색(PK)
	public GuildUser selectByGuildNameAndUserId(GuildUser guildUser);
	
	// 유저 길드장 여부 수정
	public void updateStatus(GuildUser guildUser);

	// 길드 탈퇴
	public void deleteGuildUser(GuildUser guildUser);
	
}
