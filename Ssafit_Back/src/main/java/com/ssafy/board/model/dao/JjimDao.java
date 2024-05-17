package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.Jjim;

public interface JjimDao {
	// 찜 검색은 굳이 지금 필요해보이지 않아서 패스
//	public List<Jjim> search(SearchCondition searchCondition);
	
	// 찜 등록
	public void insertJjim(Jjim jjim);
	
	// 찜 삭제
	public void deleteJjim(String userId, String videoId);
	
	// 찜 목록 가져오기
	public List<Jjim> selectAllByUserId(String userId);
	
	// 찜 목록 하나 가져오기 (얘는 내가 찜했는지 여부를 영상 상세에서 확인할 수 있게 쓰는 용도)
	public Jjim selectOneJjimById(String userId, String videoId);
}