package com.opensns.forumn.service.util;

import com.opensns.forumn.common.Encoder;
import com.opensns.forumn.service.vo.SearchParameterVO;

public class SearchQueryMaker {

	public String makeSearchQuery(SearchParameterVO param, String coreUrl) {
		StringBuffer searchQuery = new StringBuffer(coreUrl + "select?");

		String pQuery = makePQuery(param); // complete
		String sortQuery = makeSortQuery(param); // complete
		String startNRowQuery = makeStartRowQuery(param); // TODO
		String highlightQuery=makeHighlightQuery(param);
		String flQuery=getFlColumList();

		if (pQuery != null) {
			searchQuery.append(pQuery);
		}
		if (sortQuery != null) {
			searchQuery.append(sortQuery);
		}
		if (startNRowQuery != null) {
			searchQuery.append(startNRowQuery);
		}
		if(flQuery!=null){
			searchQuery.append(flQuery);
		}
		if(highlightQuery!=null){
			searchQuery.append(highlightQuery);
		}
		searchQuery.append("&wt=json&indent=true");

		return searchQuery.toString();
	}

	private String makeHighlightQuery(SearchParameterVO param) {
		String field=param.getField();
		String query;
		query=getHlQuery(field);
		
		
		return query;
	}

	private String makeStartRowQuery(SearchParameterVO param) {
		int page=param.getPage();
		int row=param.getRow();
		int start=row*(page-1);
		
		String startNRowQuery="&start="+start+"&rows="+row;
		
		
		return startNRowQuery;
	}

	private String makeSortQuery(SearchParameterVO param) {
		StringBuffer sortQuery = new StringBuffer("&sort=");

		String sort_field = param.getSort_field();
		String sort_type = param.getSort_type();
		sortQuery.append(sort_field + "+" + sort_type);

		return sortQuery.toString();
	}

	private String makePQuery(SearchParameterVO param) {

		StringBuffer qQuery = new StringBuffer("q=");

		String field = param.getField();
		String express = param.getExpression();
		String forumId = param.getForum_id();
		String sDate = param.getsDate();
		String eDate = param.geteDate();

		
		if ("all".equals(field)) {
			qQuery.append("(post_text");
			qQuery.append(Encoder.encodingQueryToUTF8(":" + express));
			qQuery.append("+" + Encoder.encodingQueryToUTF8("||") + "+");
			qQuery.append("post_subject");
			qQuery.append(Encoder.encodingQueryToUTF8(":" + express));
			qQuery.append(")");
		} else {
			qQuery.append(field);
			qQuery.append(Encoder.encodingQueryToUTF8(":" + express));
		}
		
		if(param.getResearch().equals("y")){
			qQuery.append(makingResearchQuery(param));
		}
		

		if (forumId != null && !"".equals(forumId.trim())) {
			qQuery.append("+" + Encoder.encodingQueryToUTF8("&&") + "+");
			qQuery.append("parent_forum_id" + Encoder.encodingQueryToUTF8(":")
					+ forumId);
		}

		if (!param.getPeriod().toLowerCase().equals("total")) {
			qQuery.append("+" + Encoder.encodingQueryToUTF8("&&") + "+");
			qQuery.append("post_time" + Encoder.encodingQueryToUTF8(":["));
			qQuery.append(sDate + "+TO+" + eDate);
			qQuery.append(Encoder.encodingQueryToUTF8("]"));
		}
		

		return qQuery.toString();
	}

	// //////////////////////////////////

	private String makingResearchQuery(SearchParameterVO param) {
		StringBuffer qQuery=new StringBuffer();
		String fields[]=param.getResearchField().split(",");
		String querys[]=param.getResearchQuery().split(",");
		
		System.out.println(querys.length);
		for(String q:querys){
			System.out.println(q);
		}
		for(int i=0;i<fields.length;i++){
			String field=fields[i];
			String express=querys[i];
			
			if ("all".equals(field)) {
				qQuery.append(Encoder.encodingQueryToUTF8("&&")+"(");
				qQuery.append("post_text");
				qQuery.append(Encoder.encodingQueryToUTF8(":" + express));
				qQuery.append("+" + Encoder.encodingQueryToUTF8("||") + "+");
				qQuery.append("post_subject");
				qQuery.append(Encoder.encodingQueryToUTF8(":" + express)+")");
			} else {
				qQuery.append(field);
				qQuery.append(Encoder.encodingQueryToUTF8(":" + express));
			}
		}
		
		return qQuery.toString();
	}

	public String getHlQuery(String field) {
		return "&hl=true&hl.fl=post_text,post_subject&hl.simple.pre=<b>&hl.simple.post=<%2Fb>";
	}

	/**
	 * 
	 */
	public String getFlColumList() {
		StringBuffer sb = new StringBuffer("&fl=");
		sb.append(Encoder.encodingQueryToUTF8(getBasicFlColumList()));
		return sb.toString();
	}

	/**
	 * �⺻���� fl column list
	 */
	public String getBasicFlColumList() {
		String flColumns = "post_id,forum_id,parent_forum_name,parent_post_subject,post_username,post_date,forum_name,post_text,score";
		return flColumns;
	}

	public static void main(String[] args) {
		SearchQueryMaker qMaker = new SearchQueryMaker();

		String coreUrl = "1.234.16.50:9000/solr/topic_posts/";
		SearchParameterVO param = new SearchParameterVO();
		param.setField("all");
		param.setExpression("��ȣ");
		//String url = qMaker.makeQuery(param, coreUrl);
		//System.out.println(url);
	}
}
