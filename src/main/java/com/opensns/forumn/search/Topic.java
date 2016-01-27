package com.opensns.forumn.search;

public class Topic {
	private String scd_rd_addr;
	private String scd_addr_term;
	private String poi_nm;
	private String xy_value;
	private String scd_tel_no_term;
	private long rank_idx_bc;
	
	private long postId;
	private long topicId;
	private long forumId;
	private long posterId;
	private long iconId;
	private String posterIp;
	private long postTime;
	private long postApproved;
	private long postReported;
	private long enableBbcode;
	
	private long enableSmilies;
	private long enableMagicUrl;
	private long enableSig;
	private String postUsername;
	private String postSubject;
	private String postText;
	private String postChecksum;
	private long postAttachment;
	private String bbcodeBitfield;
	private String bbcodeUid;			
	
	private long postPostcount;
	private long postEdittime;
	private String postEditReason;
	private String postEditUser;
	private long postEditCount;
	private long postEditLocked;
	private String parentPostSubject;
	private String parentPostText;
	private String parentPostUsername;
	private String postDate;
	
	private String forumName;
	private String parentForumName;
	private String hlPostText;
	private String hlPostSubject;
	private double score;
			
	public long getPostId() {
		return postId;
	}
	public void setPostId(long postId) {
		this.postId = postId;
	}
	public long getTopicId() {
		return topicId;
	}
	public void setTopicId(long topicId) {
		this.topicId = topicId;
	}
	public long getForumId() {
		return forumId;
	}
	public void setForumId(long forumId) {
		this.forumId = forumId;
	}
	public long getPosterId() {
		return posterId;
	}
	public void setPosterId(long posterId) {
		this.posterId = posterId;
	}
	public long getIconId() {
		return iconId;
	}
	public void setIconId(long iconId) {
		this.iconId = iconId;
	}
	public String getPosterIp() {
		return posterIp;
	}
	public void setPosterIp(String posterIp) {
		this.posterIp = posterIp;
	}
	public long getPostTime() {
		return postTime;
	}
	public void setPostTime(long postTime) {
		this.postTime = postTime;
	}
	public String getHlPostSubject() {
		return hlPostSubject;
	}
	public void setHlPostSubject(String hlPostSubject) {
		this.hlPostSubject = hlPostSubject;
	}
	public long getPostApproved() {
		return postApproved;
	}
	public void setPostApproved(long postApproved) {
		this.postApproved = postApproved;
	}
	public long getPostReported() {
		return postReported;
	}
	public void setPostReported(long postReported) {
		this.postReported = postReported;
	}
	public long getEnableBbcode() {
		return enableBbcode;
	}
	public void setEnableBbcode(long enableBbcode) {
		this.enableBbcode = enableBbcode;
	}
	public long getEnableSmilies() {
		return enableSmilies;
	}
	public void setEnableSmilies(long enableSmilies) {
		this.enableSmilies = enableSmilies;
	}
	public long getEnableMagicUrl() {
		return enableMagicUrl;
	}
	public void setEnableMagicUrl(long enableMagicUrl) {
		this.enableMagicUrl = enableMagicUrl;
	}
	public long getEnableSig() {
		return enableSig;
	}
	public void setEnableSig(long enableSig) {
		this.enableSig = enableSig;
	}
	public String getPostUsername() {
		return postUsername;
	}
	public void setPostUsername(String postUsername) {
		this.postUsername = postUsername;
	}
	public String getHlPostText() {
		return hlPostText;
	}
	public void setHlPostText(String hlPostText) {
		this.hlPostText = hlPostText;
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
	public String getPostChecksum() {
		return postChecksum;
	}
	public void setPostChecksum(String postChecksum) {
		this.postChecksum = postChecksum;
	}
	public long getPostAttachment() {
		return postAttachment;
	}
	public void setPostAttachment(long postAttachment) {
		this.postAttachment = postAttachment;
	}
	public String getBbcodeBitfield() {
		return bbcodeBitfield;
	}
	public void setBbcodeBitfield(String bbcodeBitfield) {
		this.bbcodeBitfield = bbcodeBitfield;
	}
	public String getBbcodeUid() {
		return bbcodeUid;
	}
	public void setBbcodeUid(String bbcodeUid) {
		this.bbcodeUid = bbcodeUid;
	}
	public long getPostPostcount() {
		return postPostcount;
	}
	public void setPostPostcount(long postPostcount) {
		this.postPostcount = postPostcount;
	}
	public long getPostEdittime() {
		return postEdittime;
	}
	public void setPostEdittime(long postEdittime) {
		this.postEdittime = postEdittime;
	}
	public String getPostEditReason() {
		return postEditReason;
	}
	public void setPostEditReason(String postEditReason) {
		this.postEditReason = postEditReason;
	}
	public String getPostEditUser() {
		return postEditUser;
	}
	public void setPostEditUser(String postEditUser) {
		this.postEditUser = postEditUser;
	}
	public long getPostEditCount() {
		return postEditCount;
	}
	public void setPostEditCount(long postEditCount) {
		this.postEditCount = postEditCount;
	}
	public long getPostEditLocked() {
		return postEditLocked;
	}
	public void setPostEditLocked(long postEditLocked) {
		this.postEditLocked = postEditLocked;
	}
	public String getParentPostSubject() {
		return parentPostSubject;
	}
	public void setParentPostSubject(String parentPostSubject) {
		this.parentPostSubject = parentPostSubject;
	}
	public String getParentPostText() {
		return parentPostText;
	}
	public void setParentPostText(String parentPostText) {
		this.parentPostText = parentPostText;
	}
	public String getParentPostUsername() {
		return parentPostUsername;
	}
	public void setParentPostUsername(String parentPostUsername) {
		this.parentPostUsername = parentPostUsername;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getParentForumName() {
		return parentForumName;
	}
	public void setParentForumName(String parentForumName) {
		this.parentForumName = parentForumName;
	}
	public String getForumName() {
		return forumName;
	}
	public void setForumName(String forumName) {
		this.forumName = forumName;
	}
	@Override
	public String toString() {
		return "Topic [postId=" + postId + ", topicId=" + topicId
				+ ", forumId=" + forumId + ", posterId=" + posterId
				+ ", iconId=" + iconId + ", posterIp=" + posterIp
				+ ", postTime=" + postTime + ", postApproved=" + postApproved
				+ ", postReported=" + postReported + ", enableBbcode="
				+ enableBbcode + ", enableSmilies=" + enableSmilies
				+ ", enableMagicUrl=" + enableMagicUrl + ", enableSig="
				+ enableSig + ", postUsername=" + postUsername
				+ ", postSubject=" + postSubject + ", postText=" + postText
				+ ", postChecksum=" + postChecksum + ", postAttachment="
				+ postAttachment + ", bbcodeBitfield=" + bbcodeBitfield
				+ ", bbcodeUid=" + bbcodeUid + ", postPostcount="
				+ postPostcount + ", postEdittime=" + postEdittime
				+ ", postEditReason=" + postEditReason + ", postEditUser="
				+ postEditUser + ", postEditCount=" + postEditCount
				+ ", postEditLocked=" + postEditLocked + ", parentPostSubject="
				+ parentPostSubject + ", parentPostText=" + parentPostText
				+ ", parentPostUsername=" + parentPostUsername + ", postDate="
				+ postDate + ", hlPostText=" + hlPostText + ", hlPostSubject="
				+ hlPostSubject + ", score=" + score + "]";
	}
	
}
