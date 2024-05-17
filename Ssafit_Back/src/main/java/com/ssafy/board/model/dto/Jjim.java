package com.ssafy.board.model.dto;

public class Jjim {
	private int jjimId;
	private String userId;
	private String videoId;
	private String videoTitle;
	private String channelName;
	private String publishTime; 
	private String imgSource;
	
	public Jjim() {
	}
	
	public Jjim(String userId, String videoId, String videoTitle, String channelName, String publishTime, String imgSource) {
		super();
		this.userId = userId;
		this.videoId = videoId;
		this.videoTitle = videoTitle;
		this.channelName = channelName;
		this.publishTime = publishTime;
		this.imgSource = imgSource;
	}

	public int getJjimId() {
		return jjimId;
	}

	public void setJjimId(int jjimId) {
		this.jjimId = jjimId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public String getVideoTitle() {
		return videoTitle;
	}

	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public String getImgSource() {
		return imgSource;
	}

	public void setImgSource(String imgSource) {
		this.imgSource = imgSource;
	}

	@Override
	public String toString() {
		return "Jjim [jjimId=" + jjimId + ", userId=" + userId + ", videoId=" + videoId + ", videoTitle=" + videoTitle
				+ ", channelName=" + channelName + ", publishTime=" + publishTime + ", imgSource=" + imgSource + "]";
	}
}
