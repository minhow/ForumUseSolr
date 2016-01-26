package com.opensns.forumn.service.vo;

public class SearchParameterVO {
	//p 
	private String field;
	private String expression;
	private String forum_id;
	private String sDate;
	private String eDate;
	private String period;
	private String researchQuery;
	private String researchField;
	private String research;

	
	//sort
	private String sort_field;
	private String sort_type;
	
	//start,row
	private int page;
	private int row;
	
	public SearchParameterVO(){
		this.period="total";
		this.field="all";
		this.expression="*";
		this.forum_id="";
		
		this.research="n";
		this.sort_field="score";
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

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getsDate() {
		return sDate;
	}

	public void setsDate(String sDate) {
		this.sDate = sDate;
	}

	public String geteDate() {
		return eDate;
	}

	public void seteDate(String eDate) {
		this.eDate = eDate;
	}

	public String getResearchQuery() {
		return researchQuery;
	}

	public void setResearchQuery(String researchQuery) {
		this.researchQuery = researchQuery;
	}

	public String getResearch() {
		return research;
	}

	public void setResearch(String research) {
		this.research = research;
	}

	public String getResearchField() {
		return researchField;
	}

	public void setResearchField(String researchField) {
		this.researchField = researchField;
	}

	@Override
	public String toString() {
		return "SearchParameterVO [field=" + field + ", expression="
				+ expression + ", forum_id=" + forum_id + ", sDate=" + sDate
				+ ", eDate=" + eDate + ", period=" + period
				+ ", researchQuery=" + researchQuery + ", researchField="
				+ researchField + ", research=" + research + ", sort_field="
				+ sort_field + ", sort_type=" + sort_type + ", page=" + page
				+ ", row=" + row + "]";
	}
	
}
