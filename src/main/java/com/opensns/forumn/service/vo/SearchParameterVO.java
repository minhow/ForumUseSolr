package com.opensns.forumn.service.vo;

public class SearchParameterVO {
	//p 
	private String field;
	private String expression;
	private String forum_id;
	private int sDate;
	private int eDate;
	
	//sort
	private String sort_field;
	private String sort_type;
	
	//start,row
	private int page;
	private int row;
	
	public SearchParameterVO(){
		this.field="all";
		this.expression="*";
		this.forum_id="";
		
		this.sort_field="all";
		this.sort_type="desc";				
		
		this.page=1;
		this.row=10;		
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public String getForum_id() {
		return forum_id;
	}

	public void setForum_id(String forum_id) {
		this.forum_id = forum_id;
	}

	public int getsDate() {
		return sDate;
	}

	public void setsDate(int sDate) {
		this.sDate = sDate;
	}

	public int geteDate() {
		return eDate;
	}

	public void seteDate(int eDate) {
		this.eDate = eDate;
	}

	public String getSort_field() {
		return sort_field;
	}

	public void setSort_field(String sort_field) {
		this.sort_field = sort_field;
	}

	public String getSort_type() {
		return sort_type;
	}

	public void setSort_type(String sort_type) {
		this.sort_type = sort_type;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	@Override
	public String toString() {
		return "SearchParameterVO [field=" + field + ", expression="
				+ expression + ", forum_id=" + forum_id + ", sDate=" + sDate
				+ ", eDate=" + eDate + ", sort_field=" + sort_field
				+ ", sort_type=" + sort_type + ", page=" + page + ", row="
				+ row + "]";
	}
	
}
