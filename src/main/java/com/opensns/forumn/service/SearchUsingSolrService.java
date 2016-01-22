package com.opensns.forumn.service;

import java.util.List;

import com.opensns.forumn.search.SearchResult;
import com.opensns.forumn.search.Topic;
import com.opensns.forumn.service.util.SearchQueryMaker;
import com.opensns.forumn.service.util.SearchResultMaker;

/**
 * Solr 검색 전반적인 흐름을 제어하는 서비스. 검색 조건을 정보로 쿼리를 만들어 Solr와 HTTP 통신 및 결과를 핸들링 후, 정의된
 * Domain Model로 저장하여 반환한다.
 * 
 * @author jaeho
 *
 */
public class SearchUsingSolrService {
	private static SearchUsingSolrService instance;
	
	private String url="http://1.234.16.50:9000/solr/";;
	private String core="topic_posts/";
	
	//초기화
	private SearchUsingSolrService(){}
	
	//singleton
	public static SearchUsingSolrService getInstance(){
		if(instance == null){
			instance=new SearchUsingSolrService();
		}
		return instance;
	}
	
	public String makingQuery(/*검색파라미터 객체*/){
		String searchQuery="";
		
		return searchQuery;
	}
	
	
	public static void main(String[] args) {
		SearchResultMaker maker=new SearchResultMaker();
		SearchQueryMaker qMaker=new SearchQueryMaker();
		
		String url="http://1.234.16.50:9000/solr/topic_posts/select?q=post_text%3A%EC%A4%80%ED%98%B8%0A&wt=json&indent=true"+qMaker.getFlColumList()+qMaker.getHlQuery();
		//System.out.println(url);
		SearchResult sResult=maker.getScdList(url);
		
		
		
		List<Topic> topic_list=sResult.getScdList();
		for(Topic topic:topic_list)
		{
			System.out.println(topic.getHlPostText());
		}
		System.out.println(url);
		
	}
}
