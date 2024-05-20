package com.ssafy.board.controller;

import java.util.List;

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

import com.ssafy.board.model.dto.User;
import com.ssafy.board.model.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/user-api")
@Tag(name="UserRestController", description = "유저 CRUD")
@CrossOrigin("*")
public class UserRestController {
	private final UserService userService;

	public UserRestController(UserService userService) {
		this.userService = userService;
	}

	// 로그인 기능
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user, HttpSession session) {
		User tmp = userService.login(user.getId(), user.getPassword());
		if (tmp == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
		} else {
			session.setAttribute("loginUser", tmp.getId());
			return ResponseEntity.ok(tmp);
		}
	}

	// 로그아웃
	@GetMapping("/logout")
	public ResponseEntity<?> logout(HttpSession session) {
		session.invalidate();
		return ResponseEntity.ok("Logged out successfully");
	}

	// 사용자 등록 여기까지 잘됨
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody User user) {
		User alreadyUser = userService.chooseOneUserByEmail(user.getEmail());
		
		if (alreadyUser != null && alreadyUser.getEmail().equals(user.getEmail())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("이미 사용 중인 이메일입니다.");
		}
		
		alreadyUser = userService.chooseOneUser(user.getId());
		
		if (alreadyUser != null && alreadyUser.getId().equals(user.getId())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("이미 사용 중인 아이디입니다.");
		} else {
			userService.signup(user);
			return ResponseEntity.ok(user);
		}
	}

	// 모든 사용자들 가져오기 이건 지금 필요있나 모르겠음.
	@GetMapping("/users")
	public ResponseEntity<?> userList() {
		List<User> users = userService.getUserList();
		if (!users.isEmpty()) {
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	// 마이페이지 기능에 들어가는 애
	@GetMapping("/userInfo/{userId}")
	public ResponseEntity<?> getUserInfo(@PathVariable String userId) {
		User user = userService.chooseOneUser(userId);
		
		if (user == null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return ResponseEntity.ok(user);
		}
	}
	// 회원 정보 수정
	@PostMapping("/changeUserInfo")
	public ResponseEntity<?> changeUserInfo(@RequestBody User user) {
		try{
			userService.changeInfo(user);
			return ResponseEntity.ok(user);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("수정 불가");
		}
    }
	
	// 회원 탈퇴
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable String userId){
			userService.removeUser(userId);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	// 회원 검색
	@GetMapping("/userSearch/{key}/{word}")
    public ResponseEntity<?> searchUser(@PathVariable String key, @PathVariable String word) {
		try {
			return ResponseEntity.ok(userService.searchUser(key, word));
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
        
    }
	
	
}
