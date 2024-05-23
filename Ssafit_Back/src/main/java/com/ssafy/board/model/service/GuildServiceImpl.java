package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.GuildDao;
import com.ssafy.board.model.dto.Guild;
import com.ssafy.board.model.dto.SearchCondition;

@Service
public class GuildServiceImpl implements GuildService {

	private final GuildDao guildDao;

	public GuildServiceImpl(GuildDao guildDao) {
		this.guildDao = guildDao;
	}

	@Override
	public List<Guild> GuildList() {
		return guildDao.selectAll();
	}

	@Override
	public void createGuild(Guild guild) {
		guildDao.insertGuild(guild);
	}

	@Override
	public Guild findByGuildName(String guildName) {
		return guildDao.selectOneByGuildName(guildName);
	}

	@Override
	public List<Guild> searchGuild(SearchCondition searchCondition) {
		return guildDao.searchGuild(searchCondition);
	}

	@Override
	public void closeGuild(String guildName) {
		guildDao.deleteGuild(guildName);
	}

}
