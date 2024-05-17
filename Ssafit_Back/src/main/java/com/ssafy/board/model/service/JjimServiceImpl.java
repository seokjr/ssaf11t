package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.JjimDao;
import com.ssafy.board.model.dto.Jjim;

@Service
public class JjimServiceImpl implements JjimService{
	
	private final JjimDao jjimDao;
	
	public JjimServiceImpl(JjimDao jjimDao) {
		this.jjimDao = jjimDao;
	}

//	@Override
//	public List<Jjim> search(SearchCondition searchCondition) {
//		return jjimDao.search(searchCondition);
//	}

	@Override
	public void createJjim(Jjim jjim) {
		jjimDao.insertJjim(jjim);
		
	}

	@Override
	public void removeJjim(String userId, String videoId) {
		jjimDao.deleteJjim(userId, videoId);
	}

	@Override
	public List<Jjim> getAllJjims(String userId) {
		return jjimDao.selectAllByUserId(userId);
	}

	@Override
	public Jjim getOneById(String userId, String videoId) {
		return jjimDao.selectOneJjimById(userId, videoId);
	}
}
