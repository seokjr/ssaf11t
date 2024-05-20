package com.ssafy.board.model.dto;

public class User {
	private String id;
	private String password;
	private String nickname;
	private String name;
	private String email;
	
	public User() {
	}
	public User(String id, String password, String nickname, String name, String email) {
		this.id = id;
		this.password = password;
		this.nickname = nickname;
		this.name = name;
		this.email = email;
	}
	public User(String id, String nickname, String name, String email) {
		this.id = id;
		this.nickname = nickname;
		this.name = name;
		this.email = email;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", ninkname=" + nickname + ", name=" + name + ", email="
				+ email + "]";
	}
	
	
	
}
