package com.ssafy.board.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "리뷰 DTO")
public class Board {
	private int reviewId; // review_id
	private String userId;  // user_id
	private String videoId; // video_id
	private String videoTitle; // video_title
	private String channelName; // channel_name
	private String commentContent; // comment_content
	private int viewCnt;    // view_cnt

	private String regDate; // reg_date

	public Board() {
	}

	public Board(String userId, String videoId, String videoTitle, String channelName,  String commentContent) {
		this.userId = userId;
		this.videoId = videoId;
		this.videoTitle = videoTitle;
		this.channelName = channelName;
		this.commentContent = commentContent;
	}

	public Board(String videoId, String userId,  String channelName, String commentContent, String regDate, int viewCnt) {
		this.userId = userId;
		this.videoId = videoId;
		this.channelName = channelName;
		this.commentContent = commentContent;
		this.regDate = regDate;
		this.viewCnt = viewCnt;
	}

	
	
	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getVideoTitle() {
		return videoTitle;
	}

	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	@Override
	public String toString() {
		return "Board [reviewId=" + reviewId + ", videoId=" + videoId + ", userId=" + userId + ", videoTitle="
				+ videoTitle + ", commentContent=" + commentContent + ", viewCnt="
				+ viewCnt + ", regDate=" + regDate + "]";
	}
}
