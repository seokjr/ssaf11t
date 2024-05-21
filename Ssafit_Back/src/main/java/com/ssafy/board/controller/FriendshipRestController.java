package com.ssafy.board.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.Friendship;
import com.ssafy.board.model.dto.User;
import com.ssafy.board.model.service.FriendshipService;
import com.ssafy.board.model.service.UserServiceImpl;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/friendship-api")
@Tag(name="FriendshipFRestController", description = "친구추가 CRUD")
@CrossOrigin("*")
public class FriendshipRestController {
	private final FriendshipService friendshipService;
	private final UserServiceImpl userServiceImpl;
	
	public FriendshipRestController(FriendshipService friendshipService, UserServiceImpl userServiceImpl) {
		this.friendshipService = friendshipService;
		this.userServiceImpl = userServiceImpl;
	}
	
	// friendship 중복 저장 방지 장치가 필요함!!!!
	
	// 전체 조회
	@GetMapping("/friend")
	public ResponseEntity<?> list() {
		List<Friendship> list = friendshipService.selectAll(); // 전체 조회
		return new ResponseEntity<List<Friendship>>(list, HttpStatus.OK);
	}
	
	// 친구 요청 넣음
	@PostMapping("/friend/insert")
	public ResponseEntity<?> write(@RequestBody Friendship friendship) {
		// 이미 친구인 사람이면(user2, user1, accepted) 친구 요청을 넣을 수 없어야 함.
		if(friendshipService.areFriends(friendship)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("이미 친구인 상대입니다.");
		}
		try {
			friendshipService.insertRequest(friendship);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("이미 친구 신청을 한 상대입니다.");
		}
		
	}
	
	// 친구 요청 수락
	@PostMapping("/friend/accept")
	public ResponseEntity<?> accept(@RequestBody Friendship friendship) {
		friendshipService.deleteFriendship(friendship);
		friendshipService.insertRequest(friendship);
		friendshipService.acceptRequest(friendship);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// 친구&친구 요청 삭제
	@PostMapping("/friend/delete")
	public ResponseEntity<?> delete(@RequestBody Friendship friendship) {
		friendshipService.deleteFriendship(friendship);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// 나에게 요청 넣은 사람들 목록
	@GetMapping("/friend/pending/{id}")
	public ResponseEntity<?> pendingList(@PathVariable String id) {
		List<Friendship> templist = friendshipService.selectPendingFriends(id);
		List<User> list = new ArrayList<User>();
		for(Friendship f : templist) {
			User user = new User(f.getUser1Id(), userServiceImpl.chooseOneUser(f.getUser1Id()).getNickname(), userServiceImpl.chooseOneUser(f.getUser1Id()).getProfileImage());
			list.add(user);
		}
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
	
	// 나와 친구인 사람들 목록
	@GetMapping("/friend/accept/{id}")
	public ResponseEntity<?> acceptedList(@PathVariable String id) {
		List<Friendship> templist = friendshipService.selectAcceptedFriends(id);
		List<User> list = new ArrayList<User>();
		for(Friendship f : templist) {
			User user;
			if(id.equals(f.getUser1Id())) {
				user = new User(f.getUser2Id(), userServiceImpl.chooseOneUser(f.getUser2Id()).getNickname(), userServiceImpl.chooseOneUser(f.getUser2Id()).getProfileImage());
			} else {
				user = new User(f.getUser1Id(), userServiceImpl.chooseOneUser(f.getUser1Id()).getNickname(), userServiceImpl.chooseOneUser(f.getUser1Id()).getProfileImage());
			}
			list.add(user);
		}
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
	
}