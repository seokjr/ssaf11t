package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.Guild;
import com.ssafy.board.model.dto.SearchCondition;

public interface GuildService {
	
	// 전체 길드 조회
	public List<Guild> GuildList();
		
	// 길드 생성
	public void createGuild(Guild guild);
		
	// 길드명으로 길드 하나 정확히 찾기
	public Guild findByGuildName(String guildName);
		
	// 특정 키워드가 들어간 길드명을 보유한 길드명 목록
	public List<Guild> searchGuild(SearchCondition searchCondition);
		
	// 길드 정보 수정(parameterType 확정 후 매퍼 수정 필요)
	// public void updateGuild();
		
	// 길드 삭제
	public void closeGuild(String guildName);
	
}
