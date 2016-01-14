package com.opensns.forumn.vo;

public class SCDVo {
	private String scd_rd_addr;
	private String scd_addr_term;
	private String poi_nm;
	private String xy_value;
	private String scd_tel_no_term;
	
	
	private long rank_idx_bc;

	public String getScd_rd_addr() {
		return scd_rd_addr;
	}

	public void setScd_rd_addr(String scd_rd_addr) {
		this.scd_rd_addr = scd_rd_addr;
	}

	public String getScd_addr_term() {
		return scd_addr_term;
	}

	public void setScd_addr_term(String scd_addr_term) {
		this.scd_addr_term = scd_addr_term;
	}

	public String getPoi_nm() {
		return poi_nm;
	}

	public void setPoi_nm(String poi_nm) {
		this.poi_nm = poi_nm;
	}

	public String getXy_value() {
		return xy_value;
	}

	public void setXy_value(String xy_value) {
		this.xy_value = xy_value;
	}

	public String getScd_tel_no_term() {
		return scd_tel_no_term;
	}

	public void setScd_tel_no_term(String scd_tel_no_term) {
		this.scd_tel_no_term = scd_tel_no_term;
	}

	public long getRank_idx_bc() {
		return rank_idx_bc;
	}

	public void setRank_idx_bc(long rank_idx_bc) {
		this.rank_idx_bc = rank_idx_bc;
	}

	@Override
	public String toString() {
		return "SCDVo [scd_rd_addr=" + scd_rd_addr + ", scd_addr_term="
				+ scd_addr_term + ", poi_nm=" + poi_nm + ", xy_value="
				+ xy_value + ", scd_tel_no_term=" + scd_tel_no_term
				+ ", rank_idx_bc=" + rank_idx_bc + "]";
	}

}
