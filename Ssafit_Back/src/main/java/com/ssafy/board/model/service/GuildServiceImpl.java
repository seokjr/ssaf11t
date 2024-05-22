package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.GuildDao;
import com.ssafy.board.model.dto.Guild;

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
	public List<Guild> searchByGuildName(String Keyword) {
		return guildDao.searchByGuildName(Keyword);
	}

	@Override
	public List<Guild> searchByGuildTag(String Keyword) {
		return guildDao.searchByGuildTag(Keyword);
	}

	@Override
	public void closeGuild(String guildName) {
		guildDao.deleteGuild(guildName);
	}

}
