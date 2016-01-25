package com.opensns.forumn.search;

import java.util.List;

/**
 * 
 * @author jaeho
 *
 */
public class SearchResult {
	private List<Topic> scdList;
	private long totalCnt;
	private long start;

	public List<Topic> getScdList() {
		return scdList;
	}

	public void setScdList(List<Topic> scdList) {
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
