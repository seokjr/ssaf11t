package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.SearchCondition;

public interface BoardService {
	//댓글 전체 조회
	public List<Board> getBoardList();
	
	//댓글 전체조회 byVideoId
	public List<Board> readBoardByVideoId(String videoId);
	
	//댓글 상세조회byID, 날짜
	//Dao -> 뷰카운트 +1 / 게시글 조회 
	public Board readBoardByIdRegDate(String userId, String regDate); 

	// UserId 별로 모든 댓글 가져오기
	public List<Board> readBoardAllByUserId(String userId);
	
	//댓글 작성 (완료)
	public void writeBoard(Board board);
	
	///댓글 삭제
	public void removeBoard(String userId, String regDate);
	
	//댓글 수정
	public void modifyBoard(Board board);
	
	//게시글 검색
	public List<Board> search(SearchCondition searchCondition);
}
