package com.ssafy.board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.Jjim;
import com.ssafy.board.model.service.JjimService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/jjim-api")
@Tag(name="JjimRestController", description = "Jjim조회")
@CrossOrigin("*")
public class JjimRestController {
	private final JjimService jjimService;

	public JjimRestController(JjimService jjimService) {
		this.jjimService = jjimService;
	}

//	@GetMapping("/jjim")
//	@Operation(summary="게시글 조회", description = "게시글 조건에 따른 조회 가능")
//	public ResponseEntity<?> list(@Parameter(description = "검색조건") @ModelAttribute SearchCondition con) {
//		List<Jjim> list = videoService.search(con); // 검색 조회
//		if (list == null || list.size() == 0) {
//			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<List<Jjim>>(list, HttpStatus.OK);
//	}
	
	// jjim 추가 완료 안됐을 때라던가 이런건 아직 추가하지 않음.
	@PostMapping("/jjim")
	public ResponseEntity<?> write(@RequestBody Jjim jjim) {
		jjimService.createJjim(jjim);
		return new ResponseEntity<Jjim>(jjim, HttpStatus.CREATED);
	}
	
	// jjim 삭제
	@DeleteMapping("/jjim")
	public ResponseEntity<Void> delete(@RequestBody Map<String, String> map) {
		// 반환값에 따라서 실제로 지워졌는지 or 내가 없는 글을 지우려고 하지는 않는지 등의 상황에 따라
		// 응답 코드가 바뀌면 프론트에서 처리하기가 더욱 수월해지겠다.
		jjimService.removeJjim(map.get("userId"), map.get("videoId"));
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// userId로 모든 jjim 다 가져오기
	@GetMapping("/jjim/{userId}")
	public ResponseEntity<?> list(@PathVariable String userId) {
		List<Jjim> list = jjimService.getAllJjims(userId);
		return new ResponseEntity<List<Jjim>>(list, HttpStatus.OK);
	}
	
	// UserId랑 videoId로 찜 한 개 가져오기
	@GetMapping("/jjim")
	public ResponseEntity<?> getOne(@RequestBody Map<String, String> map) {
		Jjim jjim = jjimService.getOneById(map.get("userId"), map.get("videoId"));
		return new ResponseEntity<Jjim>(jjim ,HttpStatus.OK);
	}
	
}
