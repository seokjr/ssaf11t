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

import com.ssafy.board.model.service.GuildBoardService;
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
	private final GuildBoardService guildBoardService;
	
	public GuildRestController(GuildService guildService, GuildUserService guildUserService,
			GuildBoardService guildBoardService) {
		this.guildService = guildService;
		this.guildUserService = guildUserService;
		this.guildBoardService = guildBoardService;
	}

	

}
