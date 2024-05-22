package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.GuildUser;

public interface GuildUserService {
	
	// 전체 정보 조회
	public List<GuildUser> selectAll();
	
	// 가입과 동시에 해당 유저를 마스터로 등록
	public void addMasterToGuild(GuildUser guildUser);
		
	// 길드에 일반 멤버로 가입
	public void joinGuild(GuildUser guildUser);
		
	// 길드 유저 목록
	public List<GuildUser> getUsersByGuildName(String guildName);
		
	// 해당 유저가 가입한 길드 목록
	public List<GuildUser> getGuildsByUserId(String userId);
		
	// 해당 길드명과 유저 아이디 조합으로 검색(PK)
	public GuildUser findByGuildNameAndUserId(GuildUser guildUser);
		
	// 유저 길드장 여부 수정
	public void updateStatus(GuildUser guildUser, String newStatus);

	// 길드 탈퇴
	public void leaveGuild(GuildUser guildUser);
}
