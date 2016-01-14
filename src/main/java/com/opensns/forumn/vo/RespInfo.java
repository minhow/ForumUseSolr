package com.opensns.forumn.vo;

import java.util.List;

public class RespInfo {
	private List<SCDVo> scdList;
	private long totalCnt;
	private long start;

	public List<SCDVo> getScdList() {
		return scdList;
	}

	public void setScdList(List<SCDVo> scdList) {
		this.scdList = scdList;
	}

	public long getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(long totalCnt) {
		this.totalCnt = totalCnt;
	}

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}
}
