package com.opensns.forumn.service;

import java.util.List;

import com.opensns.forumn.search.SearchResult;
import com.opensns.forumn.search.Topic;
import com.opensns.forumn.service.util.SearchQueryMaker;
import com.opensns.forumn.service.util.SearchResultMaker;

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
	
	//�ʱ�ȭ
	private SearchUsingSolrService(){}
	
	//singleton
	public static SearchUsingSolrService getInstance(){
		if(instance == null){
			instance=new SearchUsingSolrService();
		}
		return instance;
	}
	
	public String makingQuery(/*�˻��Ķ���� ��ü*/){
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
