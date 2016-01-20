package com.opensns.forumn.search;

public class Topic {
	private String scd_rd_addr;
	private String scd_addr_term;
	private String poi_nm;
	private String xy_value;
	private String scd_tel_no_term;
	private long rank_idx_bc;
	
	private String posterIp;
	private String postSubject;
	private int posterId;
	private String postText;
	private int forumId;
	private int topicId;
	private int postId;
	private String postUsername;
	private String postDate;
	private String postTime;
	private String userName;
	private int parentPostId;
	private int postPostCount;
	private int postAttachment;
	private String parentPostText;
	private String parentPostSubject;
	
	
	
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getParentPostId() {
		return parentPostId;
	}
	public void setParentPostId(int parentPostId) {
		this.parentPostId = parentPostId;
	}
	public int getPostPostCount() {
		return postPostCount;
	}
	public void setPostPostCount(int postPostCount) {
		this.postPostCount = postPostCount;
	}
	public int getPostAttachment() {
		return postAttachment;
	}
	public void setPostAttachment(int postAttachment) {
		this.postAttachment = postAttachment;
	}
	public String getParentPostText() {
		return parentPostText;
	}
	public void setParentPostText(String parentPostText) {
		this.parentPostText = parentPostText;
	}
	public String getParentPostSubject() {
		return parentPostSubject;
	}
	public void setParentPostSubject(String parentPostSubject) {
		this.parentPostSubject = parentPostSubject;
	}
	public String getPosterIp() {
		return posterIp;
	}
	public void setPosterIp(String posterIp) {
		this.posterIp = posterIp;
	}
	public String getPostSubject() {
		return postSubject;
	}
	public void setPostSubject(String postSubject) {
		this.postSubject = postSubject;
	}
	public int getPosterId() {
		return posterId;
	}
	public void setPosterId(int posterId) {
		this.posterId = posterId;
	}
	public String getPostText() {
		return postText;
	}
	public void setPostText(String postText) {
		this.postText = postText;
	}
	public int getForumId() {
		return forumId;
	}
	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getPostUsername() {
		return postUsername;
	}
	public void setPostUsername(String postUsername) {
		this.postUsername = postUsername;
	}
	public String getPostTime() {
		return postTime;
	}
	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}
}
