package com.opensns.forumn.service;

import java.util.List;

import test.SearchingTest;

import com.opensns.forumn.search.SearchResult;
import com.opensns.forumn.search.Topic;
import com.opensns.forumn.service.util.SearchQueryMaker;
import com.opensns.forumn.service.util.SearchResultMaker;
import com.opensns.forumn.service.vo.SearchParameterVO;

/**
 * Solr �˻� �������� �帧�� �����ϴ� ����. �˻� ������ ������ ������ ����� Solr�� HTTP ��� �� ����� �ڵ鸵 ��, ���ǵ�
 * Domain Model�� �����Ͽ� ��ȯ�Ѵ�.
 * 
 * @author jaeho
 *
 */
public class SearchUsingSolrService {
	private static SearchUsingSolrService instance;
	
	private String url="http://1.234.16.50:9000/solr/";;
	private String core="topic_posts/";
	
	private SearchQueryMaker qMaker;
	private SearchResultMaker sMaker;
	
	//�ʱ�ȭ
	private SearchUsingSolrService(){
		qMaker=new SearchQueryMaker();
		sMaker=new SearchResultMaker();
	}
	
	//singleton
	public static SearchUsingSolrService getInstance(){
		if(instance == null){
			instance=new SearchUsingSolrService();
		}
		return instance;
	}
	
	public SearchResult getSearchResult(SearchParameterVO param)
	{
		String coreUrl=url+core;
		String url=qMaker.makeQuery(param, coreUrl);
		
		return sMaker.getScdList(url);
	}
	

	public static void main(String[] args) {
		SearchResultMaker maker=new SearchResultMaker();
		SearchQueryMaker qMaker=new SearchQueryMaker();
		
		
		
		//String url="http://1.234.16.50:9000/solr/topic_posts/select?q=post_text%3A%EC%A4%80%ED%98%B8%0A&wt=json&indent=true"+qMaker.getFlColumList()+qMaker.getHlQuery();
		//System.out.println(url);
		//SearchResult sResult=maker.getScdList(url);
		
		
		
		/*List<Topic> topic_list=sResult.getScdList();
		for(Topic topic:topic_list)
		{
			System.out.println(topic.getHlPostText());
		}
		System.out.println(url);*/
		
	}
}
