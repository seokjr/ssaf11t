package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.Guild;

public interface GuildDao {
	
	// 전체 길드 조회
	public List<Guild> selectAll();
	
	// 길드 생성
	public void insertGuild(Guild guild);
	
	// 길드명으로 길드 하나 정확히 찾기
	public Guild selectOneByGuildName(String guildName);
	
	// 특정 키워드가 들어간 길드명을 보유한 길드명 목록
	public List<Guild> searchByGuildName(String Keyword);
	
	// 특정 키워드가 들어간 태그를 보유한 길드명 목록
	public List<Guild> searchByGuildTag(String Keyword);
	
	// 길드 정보 수정(parameterType 확정 후 매퍼 수정 필요)
	// public void updateGuild();
	
	// 길드 삭제
	public void deleteGuild(String guildName);
	

}
