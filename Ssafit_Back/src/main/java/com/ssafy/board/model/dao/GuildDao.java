package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.Guild;
import com.ssafy.board.model.dto.SearchCondition;

public interface GuildDao {
	
	// 전체 길드 조회
	public List<Guild> selectAll();
	
	// 길드 생성
	public void insertGuild(Guild guild);
	
	// 길드명으로 길드 하나 정확히 찾기
	public Guild selectOneByGuildName(String guildName);
	
	// 길드 검색
	public List<Guild> searchGuild(SearchCondition searchCondition);
	
	// 길드 정보 수정(parameterType 확정 후 매퍼 수정 필요)
	// public void updateGuild();
	
	// 길드 삭제
	public void deleteGuild(String guildName);
	

}
