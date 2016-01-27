package com.opensns.forumn.db.vo;

public class PostVO {
	private int postId;
	private int topicId;
	private int forumId;
	private String posterIp;
	private String postUsername;
	private String postSubject;
	private String postText;

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public int getForumId() {
		return forumId;
	}

	public void setForumId(int forumId) {
		this.forumId = forumId;
	}

	public String getPosterIp() {
		return posterIp;
	}

	public void setPosterIp(String posterIp) {
		this.posterIp = posterIp;
	}

	public String getPostUsername() {
		return postUsername;
	}

	public void setPostUsername(String postUsername) {
		this.postUsername = postUsername;
	}

	public String getPostSubject() {
		return postSubject;
	}

	public void setPostSubject(String postSubject) {
		this.postSubject = postSubject;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	@Override
	public String toString() {
		return "PostVO [postId=" + postId + ", topicId=" + topicId
				+ ", forumId=" + forumId + ", posterIp=" + posterIp
				+ ", postUsername=" + postUsername + ", postSubject="
				+ postSubject + ", postText=" + postText + "]";
	}

}