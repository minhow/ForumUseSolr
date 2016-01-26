package com.opensns.forumn.service.util;

import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.opensns.forumn.search.SearchResult;
import com.opensns.forumn.search.Topic;

public class SearchResultMaker {
	
	
	public SearchResult getScdList(String url) {
		SearchResult respInfo = new SearchResult();
		try {
			URLConnection conn = new URL(url).openConnection();
			JSONParser parser = new JSONParser();
			JSONObject jObj = (JSONObject) parser.parse(new InputStreamReader(
					conn.getInputStream(), "UTF-8"));
			JSONObject resp = (JSONObject) jObj.get("response");

			respInfo.setTotalCnt((Long) resp.get("numFound"));
			respInfo.setStart((Long) resp.get("start"));						
			
			respInfo.setScdList(getSCDList(jObj));
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respInfo;
	}

	private List<Topic> getSCDList(JSONObject jObj) {
		int wordCount =30;	//���̶����� �ȵ� ��� ���ڼ�
		
		JSONObject resp=(JSONObject)jObj.get("response");
		JSONArray docs = (JSONArray) resp.get("docs");
		ArrayList<Topic> scdList = new ArrayList<Topic>();
		for (int i = 0; i < docs.size(); i++) {
			Topic topic = new Topic();

			JSONObject doc = (JSONObject) docs.get(i);

			if(doc.get("post_id")!=null){
				topic.setPostId((Long) doc.get("post_id"));
			}
			if(doc.get("topic_id")!=null){
				topic.setTopicId((Long) doc.get("topic_id"));
			}
			if(doc.get("forum_id")!=null){
				topic.setForumId((Long) doc.get("forum_id"));
			}
			if(doc.get("poster_id")!=null){		
				topic.setPosterId((Long) doc.get("poster_id"));
			}
			if(doc.get("icon_id")!=null){
				topic.setIconId((Long) doc.get("icon_id"));
			}
			if(doc.get("poster_ip")!=null){
				topic.setPosterIp((String) doc.get("poster_ip"));
			}
			if(doc.get("post_time")!=null){
				topic.setPostTime((Long) doc.get("post_time"));
			}
			if(doc.get("post_approved")!=null){
				topic.setPostApproved((Long) doc.get("post_approved"));
			}
			if(doc.get("post_reported")!=null){
				topic.setPostReported((Long) doc.get("post_reported"));
			}
			if(doc.get("enable_bbcode")!=null){
				topic.setEnableBbcode((Long) doc.get("enable_bbcode"));
			}						
			
			
			if(doc.get("enable_smilies")!=null){
				topic.setEnableSmilies((Long) doc.get("enable_smilies"));
			}
			if(doc.get("enable_magic_url")!=null){
				topic.setEnableMagicUrl((Long) doc.get("enable_magic_url"));
			}
			if(doc.get("enable_sig")!=null){
				topic.setEnableSig((Long) doc.get("enable_sig"));
			}
			if(doc.get("post_username")!=null){
				topic.setPostUsername((String) doc.get("post_username"));
			}
			if(doc.get("post_subject")!=null){
				topic.setPostSubject((String) doc.get("post_subject"));
			}
			if(doc.get("post_text")!=null){
				String postText=(String) doc.get("post_text");
				topic.setPostText(postText);
				if(postText.length()>wordCount)
				{
					topic.setHlPostText(postText.substring(0, wordCount)+"...");
				}else{
					topic.setHlPostText(postText);
				}
				
			}
			if(doc.get("post_checksum")!=null){
				topic.setPostChecksum((String) doc.get("post_checksum"));
			}
			if(doc.get("post_attachment")!=null){
				topic.setPostAttachment((Long) doc.get("post_attachment"));
			}
			if(doc.get("bbcode_bitfield")!=null){
				topic.setBbcodeBitfield((String) doc.get("bbcode_bitfield"));
			}
			if(doc.get("bbcode_uid")!=null){
				topic.setBbcodeUid((String) doc.get("bbcode_uid"));
			}
			
			
			if(doc.get("post_postcount")!=null){
				topic.setPostPostcount((Long) doc.get("post_postcount"));
			}
			if(doc.get("post_edit_time")!=null){
				topic.setPostEdittime((Long) doc.get("post_edit_time"));
			}
			if(doc.get("post_edit_reason")!=null){
				topic.setPostEditReason((String) doc.get("post_edit_reason"));
			}
			if(doc.get("post_edit_user")!=null){
				topic.setPostEditUser((String) doc.get("post_edit_user"));
			}
			if(doc.get("post_edit_count")!=null){
				topic.setPostEditCount((Long) doc.get("post_edit_count"));
			}
			if(doc.get("post_edit_locked")!=null){
				topic.setPostEditLocked((Long) doc.get("post_edit_locked"));
			}
			if(doc.get("parent_post_subject")!=null){
				String postSubject=(String) doc.get("parent_post_subject");
				topic.setParentPostSubject((String) doc.get("parent_post_subject"));				
				topic.setHlPostSubject(postSubject);
			
				
			}
			if(doc.get("parent_post_text")!=null){
				topic.setParentPostText((String) doc.get("parent_post_text"));
			}
			if(doc.get("parent_post_username")!=null){
				topic.setParentPostUsername((String) doc.get("parent_post_username"));
			}
			if(doc.get("post_date")!=null){
				topic.setPostDate((String) doc.get("post_date"));
			}
			if(doc.get("score")!=null){
				topic.setScore((Double) doc.get("score"));
			}
			if(doc.get("parent_forum_name")!=null){
				topic.setParentForumName((String) doc.get("parent_forum_name"));
			}
			if(doc.get("forum_name")!=null){
				topic.setForumName((String) doc.get("forum_name"));
			}
			
			
			if(jObj.get("highlighting")!=null){							
				JSONObject hObj=(JSONObject)jObj.get("highlighting");				
				JSONObject hObj2=(JSONObject)hObj.get(Long.toString(topic.getPostId()));
				
				if(hObj2.get("post_text") !=null){
					JSONArray jArr=(JSONArray)hObj2.get("post_text");
					topic.setHlPostText((String)jArr.get(0));
				}
				if(hObj2.get("post_subject") !=null){
					JSONArray jArr=(JSONArray)hObj2.get("post_subject");
					topic.setHlPostSubject((String)jArr.get(0));
				}
				
			}else{
				System.out.println("null..");
			}
			
			
			scdList.add(topic);
		}
		return scdList;
	}
}
