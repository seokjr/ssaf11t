package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.GuildUserDao;
import com.ssafy.board.model.dto.GuildUser;

@Service
public class GuildUserServiceImpl implements GuildUserService {

	private final GuildUserDao guildUserDao;

	public GuildUserServiceImpl(GuildUserDao guildUserDao) {
		this.guildUserDao = guildUserDao;
	}

	@Override
	public List<GuildUser> selectAll() {
		return guildUserDao.selectAll();
	}

	@Override
	public void addMasterToGuild(GuildUser guildUser) {
		guildUser.setStatus("master");
		guildUserDao.insertGuildUser(guildUser);
	}

	@Override
	public void joinGuild(GuildUser guildUser) {
		guildUser.setStatus("member");
		guildUserDao.insertGuildUser(guildUser);
	}

	@Override
	public List<GuildUser> getUsersByGuildName(String guildName) {
		return guildUserDao.selectUserByGuildName(guildName);
	}

	@Override
	public List<GuildUser> getGuildsByUserId(String userId) {
		return guildUserDao.selectGuildByUserId(userId);
	}

	@Override
	public GuildUser findByGuildNameAndUserId(GuildUser guildUser) {
		return guildUserDao.selectByGuildNameAndUserId(guildUser);
	}

	@Override
	public void updateStatus(GuildUser guildUser, String newStatus) {
		guildUser.setStatus(newStatus);
		guildUserDao.updateStatus(guildUser);
	}

	@Override
	public void leaveGuild(GuildUser guildUser) {
		guildUserDao.deleteGuildUser(guildUser);
	}

}
