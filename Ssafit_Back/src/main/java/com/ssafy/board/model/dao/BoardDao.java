package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.SearchCondition;

public interface BoardDao {
	
	// 전체 댓글들을 다 나오게
	public List<Board> selectAll();
	
	// videoId 별로 댓글 모두 가져오기
	public List<Board> selectAllByVideo(String videoId);

	// userId와 등록일자에 해당하는 게시글 하나 가져오기
	public Board selectOneByUserIdRegDate(String userId, String regDate);

	// userId에 해당하는 게시글 전체 가져오기
	public List<Board> selectAllByUserId(String userId);
	
	// 댓글 등록(완료)
	public void insertBoard(Board board);

	// 댓글 삭제
	public void deleteBoard(String userId, String regDate);

	// 댓글 수정
	public void updateBoard(Board board);

	// 조회수 증가
	public void updateViewCnt(String userId, String regDate);
	
	// 검색 기능
	public List<Board> search(SearchCondition searchCondition);

}
