package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.board.model.dto.GuildBoard;
import com.ssafy.board.model.dao.GuildBoardDao;

@Service
public class GuildBoardServiceImpl implements GuildBoardService {

	private final GuildBoardDao guildBoardDao;

	public GuildBoardServiceImpl(GuildBoardDao guildBoardDao) {
		this.guildBoardDao = guildBoardDao;
	}

	@Override
	public List<GuildBoard> selectAll() {
		return guildBoardDao.selectAll();
	}

	@Override
	public void createBoard(GuildBoard guildBoard) {
		guildBoardDao.insertBoard(guildBoard);		
	}

	@Override
	public GuildBoard readBoard(GuildBoard guildBoard) {
		guildBoardDao.updateViewCnt(guildBoard);
		return guildBoardDao.selectOne(guildBoard);
	}

	@Override
	public List<GuildBoard> getListByGuildName(String GuildName) {
		return guildBoardDao.selectAllByGuildName(GuildName);
	}

	@Override
	public List<GuildBoard> getListByUserId(String userId) {
		return guildBoardDao.selectAllByUserId(userId);
	}

	@Override
	public List<GuildBoard> getListAllByGuildNameAndUserId(String GuildName, String userId) {
		return guildBoardDao.selectAllByGuildNameAndUserId(GuildName, userId);
	}

	@Override
	public void updateBoard(GuildBoard guildBoard) {
		guildBoardDao.updateBoard(guildBoard);
	}

	@Override
	public void deleteBoard(GuildBoard guildBoard) {
		guildBoardDao.deleteBoard(guildBoard);
	}

}
