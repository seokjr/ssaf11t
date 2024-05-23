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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.Guild;
import com.ssafy.board.model.dto.GuildUser;
import com.ssafy.board.model.dto.SearchCondition;
import com.ssafy.board.model.service.GuildService;
import com.ssafy.board.model.service.GuildUserService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/guild-api")
@Tag(name="GuildRestController", description = "길드 CRUD")
@CrossOrigin("*")
public class GuildRestController {
	private final GuildService guildService;
	private final GuildUserService guildUserService;
	
	public GuildRestController(GuildService guildService, GuildUserService guildUserService) {
		this.guildService = guildService;
		this.guildUserService = guildUserService;
	}
	
	// 길드 검색해서 가져오기 없으면 다 가져오기
	@GetMapping("/guild")
	public ResponseEntity<List<Guild>> guildList(@ModelAttribute SearchCondition condition) {
		List<Guild> guild = guildService.searchGuild(condition);
		if (guild != null) {
			return new ResponseEntity<List<Guild>>(guild, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Guild>>(guild, HttpStatus.NO_CONTENT);
		}
	}
	
	// 길드 생성
	@PostMapping("/guild/{userId}")
	public ResponseEntity<?> createGuild(@RequestBody Guild guild, @PathVariable("userId") String userId) {
		guildService.createGuild(guild);
		GuildUser guildUser = new GuildUser(guild.getGuildName(), userId);
		guildUserService.addMasterToGuild(guildUser);
		return new ResponseEntity<Guild>(guild, HttpStatus.CREATED);
	}
	// 길드 삭제
	@DeleteMapping("/guild/{guildName}")
	public ResponseEntity<Void> deleteGuild(@PathVariable String guildName) {
		System.out.println("여기 나옵니까?");
		guildService.closeGuild(guildName);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// 길드 가입취소
	@DeleteMapping("/guild/{userId}/{guildName}")
	public ResponseEntity<Void> deleteGuildRequest(@PathVariable("userId") String userId, @PathVariable("guildName") String guildName){
		GuildUser guildUser = new GuildUser(guildName, userId);
		guildUserService.leaveGuild(guildUser);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// 길드 가입 요청
	@PostMapping("/guild/{userId}/{guildName}")
	public ResponseEntity<?> insertGuildRequest(@PathVariable("userId") String userId, @PathVariable("guildName") String guildName) {
		GuildUser guildUser = new GuildUser(guildName, userId);
		guildUserService.joinGuild(guildUser);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	// guild_name으로 유저목록 가져오기
	@GetMapping("/guild/{guildName}/guildMember")
	public ResponseEntity<?> findGuildUserByName(@PathVariable String guildName) {
		List<GuildUser> guildUsers= guildUserService.getUsersByGuildName(guildName);
		return new ResponseEntity<List<GuildUser>>(guildUsers, HttpStatus.OK);
	}
	
	// guild_name으로 하나 가져오기
	@GetMapping("/guild/{guildName}")
	public ResponseEntity<?> findGuildByName(@PathVariable String guildName) {
		Guild guild= guildService.findByGuildName(guildName);
		return new ResponseEntity<Guild>(guild, HttpStatus.OK);
	}
	
	// 유저가 가입한 길드 다 가져오기
	@GetMapping("/myguild/{userId}")
	public ResponseEntity<?> findGuildsByUserId(@PathVariable("userId") String userId) {
		List<GuildUser> guilds = guildUserService.getGuildsByUserId(userId);
		return new ResponseEntity<List<GuildUser>>(guilds, HttpStatus.OK);
	}
}
