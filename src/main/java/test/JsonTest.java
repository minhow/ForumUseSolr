package test;

import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.opensns.forumn.common.DateUtil;
import com.opensns.forumn.search.SearchResult;
import com.opensns.forumn.search.Topic;

public class JsonTest {
	public static void main(String[] args) throws Exception {
		String url="http://1.234.16.50:9000/solr/topic_posts/select?q=*%3A*&wt=json&indent=true";
		getScdList(url);
		
	}
	public static SearchResult getScdList(String url){
		SearchResult respInfo=new SearchResult();
		
		try {
			URLConnection conn=new URL(url).openConnection();
			JSONParser parser=new JSONParser();						
			JSONObject jObj=(JSONObject) parser.parse(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			JSONObject resp=(JSONObject)jObj.get("response");
			
			respInfo.setTotalCnt((Long)resp.get("numFound"));
			respInfo.setStart((Long)resp.get("start"));
			respInfo.setScdList(getSCDList(resp));											
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return respInfo;
	}
	public static List<Topic> getSCDList(JSONObject resp) {
		JSONArray docs=(JSONArray)resp.get("docs");
		ArrayList<Topic> scdList=new ArrayList<Topic>();
		for(int i=0;i<docs.size();i++){
			Topic topic=new Topic();
			
			JSONObject doc=(JSONObject)docs.get(i);
		/*	
			topic.setPosterIp((String)doc.get("poster_ip"));
			topic.setPostSubject((String)doc.get("post_subject"));
			topic.setPosterId((Integer)doc.get("poster_id"));
			topic.setPostText((String)doc.get("post_text"));
			topic.setForumId((Integer)doc.get("forum_id"));
			topic.setTopicId((Integer)doc.get("topic_id"));*/
			
			topic.setPostId((Long)doc.get("post_id"));
			topic.setTopicId((Long)doc.get("topic_id"));
			topic.setForumId((Long)doc.get("forum_id"));
			topic.setPosterId((Long)doc.get("poster_id"));
			topic.setIconId((Long)doc.get("icon_id"));
			topic.setPosterIp((String)doc.get("poster_ip"));
			topic.setPostTime((Long)doc.get("post_time"));
			topic.setPostApproved((Long)doc.get("post_approved"));
			topic.setPostReported((Long)doc.get("post_reported"));
			topic.setEnableBbcode((Long)doc.get("enable_bbcode"));
						
			topic.setEnableSmilies((Long)doc.get("enable_smilies"));
			topic.setEnableMagicUrl((Long)doc.get("enable_magic_url"));
			topic.setEnableSig((Long)doc.get("enable_sig"));
			topic.setPostUsername((String)doc.get("post_username"));
			topic.setPostSubject((String)doc.get("post_subject"));
			topic.setPostText((String)doc.get("post_text"));
			topic.setPostChecksum((String)doc.get("post_checksum"));
			topic.setPostAttachment((Long)doc.get("post_attachment"));
			topic.setBbcodeBitfield((String)doc.get("bbcode_bitfield"));
			topic.setBbcodeUid((String)doc.get("bbcode_uid"));
						
			
			topic.setPostPostcount((Long)doc.get("post_postcount"));
			topic.setPostEdittime((Long)doc.get("post_edit_time"));
			topic.setPostEditReason((String)doc.get("post_edit_reason"));
			topic.setPostEditUser((String)doc.get("post_edit_user"));
			topic.setPostEditCount((Long)doc.get("post_edit_count"));
			topic.setPostEditLocked((Long)doc.get("post_edit_locked"));
			topic.setParentPostSubject((String)doc.get("parent_post_subject"));
			topic.setParentPostText((String)doc.get("parent_post_text"));
			topic.setParentPostUsername((String)doc.get("parent_post_username"));
			topic.setPostDate((String)doc.get("post_date"));
			
			System.out.println(topic);//20160120
			scdList.add(topic);
		}
		return scdList;
	}
}
