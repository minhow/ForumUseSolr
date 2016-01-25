package com.opensns.forumn.service.util;

import com.opensns.forumn.common.Encoder;
import com.opensns.forumn.service.vo.SearchParameterVO;

public class SearchQueryMaker {

	public String makeQuery(SearchParameterVO param, String coreUrl) {
		StringBuffer searchQuery = new StringBuffer(coreUrl + "select?");

		String pQuery = makePQuery(param); // complete
		String sortQuery = makeSortQuery(param); // complete
		String startNRowQuery = makeStartRowQuery(param); // TODO

		System.out.println("sortQuery" + sortQuery);

		if (pQuery != null) {
			searchQuery.append(pQuery);
		}
		if (sortQuery != null) {
			searchQuery.append(sortQuery);
		}
		if (startNRowQuery != null) {
			searchQuery.append(startNRowQuery);
		}
		searchQuery.append("&wt=json&indent=true");

		return searchQuery.toString();
	}

	private String makeStartRowQuery(SearchParameterVO param) {
		int page=param.getPage();
		int row=param.getRow();
		int start=row*(page-1);
		
		String startNRowQuery="&start="+start+"&row="+row;
		
		
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
		int sDate = param.getsDate();
		int eDate = param.geteDate();

		if ("all".equals(field)) {
			qQuery.append("post_text");
			qQuery.append(Encoder.encodingQueryToUTF8(":" + express));
			qQuery.append("+" + Encoder.encodingQueryToUTF8("||") + "+");
			qQuery.append("post_subject");
			qQuery.append(Encoder.encodingQueryToUTF8(":" + express));
		} else {
			qQuery.append(field);
			qQuery.append(Encoder.encodingQueryToUTF8(":" + express));
		}

		if (forumId != null && !"".equals(forumId.trim())) {
			qQuery.append("+" + Encoder.encodingQueryToUTF8("&&") + "+");
			qQuery.append("forum_id" + Encoder.encodingQueryToUTF8(":")
					+ forumId);
		}

		if (sDate != 0 && eDate != 0) {
			qQuery.append("+" + Encoder.encodingQueryToUTF8("&&") + "+");
			qQuery.append("post_time" + Encoder.encodingQueryToUTF8(":["));
			qQuery.append(sDate + "+TO+" + eDate);
			qQuery.append(Encoder.encodingQueryToUTF8("]"));
		}

		return qQuery.toString();
	}

	// //////////////////////////////////

	public String getHlQuery() {
		return "&hl=true&hl.fl=post_text&hl.simple.pre=<em>&hl.simple.post=<%2Fem>";
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
		String flColumns = "forum_id,forum_name,poster_ip,post_time,post_id,post_date,post_subject,post_text,parent_post_username,parent_post_id,parent_post_text,parent_post_subject";
		return flColumns;
	}

	public static void main(String[] args) {
		SearchQueryMaker qMaker = new SearchQueryMaker();

		String coreUrl = "1.234.16.50:9000/solr/topic_posts/";
		SearchParameterVO param = new SearchParameterVO();
		param.setField("post_subject");
		param.setForum_id("8");
		String url = qMaker.makeQuery(param, coreUrl);
		System.out.println(url);
	}
}
