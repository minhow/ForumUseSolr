package com.opensns.forumn.service.util;

import java.io.ObjectInputStream.GetField;

import com.opensns.forumn.common.Encoder;

public class SearchQueryMaker {
	
	public String getHlQuery(){
		return "&hl=true&hl.fl=post_text&hl.simple.pre=<em>&hl.simple.post=<%2Fem>";
	}
	/**
	 * 
	 */
	public String getFlColumList(){
		StringBuffer sb=new StringBuffer("&fl=");
		sb.append(Encoder.encodingQueryToUTF8(getBasicFlColumList()));
		return sb.toString();
	}
	/**
	 * 기본적인 fl column list
	 */
	public String getBasicFlColumList(){
		String flColumns="forum_id,forum_name,poster_ip,post_time,post_id,post_date,post_subject,post_text,parent_post_username,parent_post_id,parent_post_text,parent_post_subject";		
		return flColumns;
	}
	
	
	
	/**
	 * q 질의에 담긴 쿼리 정재
	 * @return
	 */
	public String getQuery(/*검색쿼리 객체*/){
		String query="";
		return query;
	}
	
	/**
	 * q 질의 이외의 질의에 담긴 쿼리 정재
	 * @return
	 */
	public String getAdditionalQuery(/*검색쿼리 객체*/){
		String query="";
		return query;
	}

	
/**************** 쿼리 만들기 ****************/
	
	/****** 정렬 **********/
	//유사도순
	public String sortBySimilarity(){
		String result="";
		return result;
	}
	//최신순
	public String sortByDate(){
		String result="";
		return result;
	}
	/****** 영역 **********/
	//전체(제목+본문)
	public String fieldScopeAll(){
		String result="";
		return result;
	}
	//제목
	public String fieldScopeTitle(){
		String result="";
		return result;
	}
	//본문
	public String fieldScopeContent(){
		String result="";
		return result;
	}
	
	/****** 기간 **********/	
	//1일
	public String dateScopeOneDay(){
		String result="";
		return result;
	}
	//1주
	public String dateScopeOneWeek(){
		String result="";
		return result;
	}
	//1개월
	public String dateScopeOneMonth(){
		String result="";
		return result;
	}
	//1년
	public String dateScopeOneYear(){
		String result="";
		return result;
	}
	//기간입력
	public String dateScopeTyping(){
		String result="";
		return result;
	}
	public static void main(String[] args) {
		
	}
}
