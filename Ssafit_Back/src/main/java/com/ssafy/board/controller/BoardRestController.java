package com.ssafy.board.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.SearchCondition;
import com.ssafy.board.model.service.BoardService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/review-api")
@Tag(name="BoardRestController", description = "리뷰 CRUD")
@CrossOrigin("*")
public class BoardRestController {
	private final BoardService boardService;

	public BoardRestController(BoardService boardService) {
		this.boardService = boardService;
	}

	// 게시글 전체 조회
//	@GetMapping("/board")
//	public ResponseEntity<?> list() {
//		List<Board> list = boardService.getBoardList(); // 전체 조회
//		
//		return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
//	}
	@GetMapping("/board/{videoId}")
	public ResponseEntity<List<Board>> detailByID(@PathVariable String videoId) {
		List<Board> board = boardService.readBoardByVideoId(videoId);
		// 가져왔는데 board가 null이면 예외처리를 해줘라 404처리 (직접해볼것)
		if (board != null) {
			return new ResponseEntity<List<Board>>(board, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Board>>(board, HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/comment/{userId}")
	public ResponseEntity<List<Board>> getUserReviewList(@PathVariable String userId) {
		List<Board> board = boardService.readBoardAllByUserId(userId);
		// 가져왔는데 board가 null이면 예외처리를 해줘라 404처리 (직접해볼것)
		if (board != null) {
			return new ResponseEntity<List<Board>>(board, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Board>>(board, HttpStatus.NO_CONTENT);
		}
	}
	
	// 게시글 전체 조회 (검색 포함)
	@GetMapping("/board")
	@Operation(summary="게시글 조회", description = "게시글 조건에 따른 조회 가능")
	public ResponseEntity<?> list(@Parameter(description = "검색조건") @ModelAttribute SearchCondition condition) {
		List<Board> list = boardService.search(condition); // 검색 조회
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
	}

	// 게시글 상세 보기
	@GetMapping("/board/{userId}&{regDate}")
	public ResponseEntity<Board> detail(@PathVariable String userId, @PathVariable String regDate) {
		Board board = boardService.readBoardByIdRegDate(userId, regDate);
		// 가져왔는데 board가 null이면 예외처리를 해줘라 404처리 (직접해볼것)
		if (board != null) {
			return new ResponseEntity<Board>(board, HttpStatus.OK);
		} else {
			return new ResponseEntity<Board>(board, HttpStatus.NO_CONTENT);
		}
	}

	// 게시글 등록 (Form 형식으로 넘어왔을 때) // 완료 안되었을 때 어떻게 처리할지 같은 건 아직 안했다. 이 부분은 해야할지도.
	@PostMapping("/board")
	public ResponseEntity<?> write(@RequestBody Board board) {
		boardService.writeBoard(board);
		return new ResponseEntity<Board>(board, HttpStatus.CREATED);
	}

	// 게시글 수정 (JSON 형태로 보낸다)
	@PutMapping("/board/{userId}&{regDate}")
	public ResponseEntity<Void> update(@PathVariable String userId, @PathVariable String regDate, @ModelAttribute Board board) {
		System.out.println(board);
		Board changeOne = boardService.readBoardByIdRegDate(userId, regDate);
		changeOne.setCommentContent(board.getCommentContent());
		boardService.modifyBoard(changeOne); // id를 따로 보내왔다면 바구니(DTO)에 넣어놓고 보내자
		return new ResponseEntity<Void>(HttpStatus.OK); // 조금 더 세밀하게 컨트롤할 수 있다.
	}

	// 게시글 삭제
	@DeleteMapping("/board/{userId}&{regDate}")
	public ResponseEntity<Void> delete(@PathVariable String userId, @PathVariable String regDate) {
		// 반환값에 따라서 실제로 지워졌는지 or 내가 없는 글을 지우려고 하지는 않는지 등의 상황에 따라
		// 응답 코드가 바뀌면 프론트에서 처리하기가 더욱 수월해지겠다.
		boardService.removeBoard(userId, regDate);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
