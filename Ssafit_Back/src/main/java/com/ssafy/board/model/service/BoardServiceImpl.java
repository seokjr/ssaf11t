package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.SearchCondition;

@Service
public class BoardServiceImpl implements BoardService {

	private final BoardDao boardDao;

	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	// 전체 댓글 목록 받아오기
	@Override
	public List<Board> getBoardList() {
		return boardDao.selectAll();
	}
	
	// VideoId별 댓글 다 받아오기
	public List<Board> readBoardByVideoId(String videoId) {
		return boardDao.selectAllByVideo(videoId);
	}
	
	// UserId랑 RegDate로 댓글 상세보기
	@Override
	public Board readBoardByIdRegDate(String userId, String regDate) {
		boardDao.updateViewCnt(userId, regDate);
		return boardDao.selectOneByUserIdRegDate(userId, regDate);
	}

	// 댓글 작성하기
	@Transactional
	@Override // 완료
	public void writeBoard(Board board) {
		boardDao.insertBoard(board);
	}

	// 댓글 삭제하기
	@Transactional
	@Override
	public void removeBoard(String userId, String regDate) {
		boardDao.deleteBoard(userId, regDate);
	}

	// 게시글 수정할 수 있게 하기
	@Transactional
	@Override
	public void modifyBoard(Board board) {
		boardDao.updateBoard(board);
	}

	// Search를 통해서 댓글 검색하기
	@Override
	public List<Board> search(SearchCondition searchCondition) {
		return boardDao.search(searchCondition);
	}
	
	// UserId 로 모든 댓글 받아오기
	@Override
	public List<Board> readBoardAllByUserId(String userId) {
		return boardDao.selectAllByUserId(userId);
	}

}
