package test;

import java.util.List;

import com.opensns.forumn.common.Encoder;
import com.opensns.forumn.search.SearchResult;
import com.opensns.forumn.search.Topic;
import com.opensns.forumn.service.SearchUsingSolrService;
import com.opensns.forumn.service.vo.SearchParameterVO;

public class SearchingTest {
	public static void main(String[] args) {
		SearchUsingSolrService service=SearchUsingSolrService.getInstance();
		SearchParameterVO vo=new SearchParameterVO();
		vo.setField("post_subject");
		vo.setExpression("¡ÿ»£");
		SearchResult result=service.getSearchResult(vo);
		
		List<Topic>resultList=result.getScdList();
		for(Topic topic:resultList)
		{
			System.out.println(topic);
		}
		
	}
}
