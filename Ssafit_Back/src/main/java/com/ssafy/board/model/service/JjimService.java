package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.Jjim;

public interface JjimService {
//	public List<Jjim> search(SearchCondition searchCondition);
	
	// 찜 등록
	public void createJjim(Jjim jjim);
	
	// 찜 삭제
	public void removeJjim(String userId, String videoId);
	
	// 찜 목록 가져오기 UserId로
	public List<Jjim> getAllJjims(String userId);
	
	// 찜 목록 하나 가져오기 (얘는 내가 찜했는지 여부를 영상 상세에서 확인할 수 있게 쓰는 용도)
	public Jjim getOneById(String userId, String videoId);
}
