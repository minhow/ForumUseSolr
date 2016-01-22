package com.opensns.forumn;

import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.opensns.forumn.common.DateUtil;
import com.opensns.forumn.common.PageUtil;
import com.opensns.forumn.search.Topic;
import com.opensns.forumn.search.SearchResult;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ForumMainController {
	
	private static final Logger logger = LoggerFactory.getLogger(ForumMainController.class);
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request) {
		ModelAndView mav=new ModelAndView("home");
		
		String expression=request.getParameter("expression");
		String field=request.getParameter("field");
		
		//쿼리가 만들어질 StringBuffer 변수
		StringBuffer request_param=new StringBuffer();

		int page = modifyPageType(request);
		
				
		//query												
		String FieldQuery=makeFieldQuery(expression,field);
		String dateRangeQuery=makeDateRangeQuery(request,mav);
		//query!
		
		//부가적인 파라미터들
		String pageQuery = makePagingQuery(page);
		String sortQuery=makeSortQuery(request,mav);
		
	
		request_param.append(FieldQuery).append(dateRangeQuery).append(pageQuery).append(sortQuery);
		System.out.println(request_param.toString());
		String url=makingUrl(request_param.toString());
		System.out.println(url);
		
		
		//요청 url로 요청한 뒤 정보를 파싱한후 받아온다.
		SearchResult respInfo=getScdList(url);

		mav.addObject("expression", expression);
		mav.addObject("field",field);
		mav.addObject("scdList",respInfo.getScdList());
		mav.addObject("total",respInfo.getTotalCnt());
		mav.addObject("start",respInfo.getStart());
		mav.addObject("page",page);
		
		PageUtil.setPaging(mav, (int)respInfo.getTotalCnt(), 10, page);
					
		return mav;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView indexHome(HttpServletRequest request) {
		System.out.println("Call searchTotal");
		ModelAndView mav=new ModelAndView("searchTotal");
		
		String expression=request.getParameter("expression");
		String field=request.getParameter("field");
		
		//쿼리가 만들어질 StringBuffer 변수
		StringBuffer request_param=new StringBuffer();
		int page = modifyPageType(request);
		
				
		//query												
		String FieldQuery=makeFieldQuery(expression,field);
		String dateRangeQuery=makeDateRangeQuery(request,mav);
		//query!
		
		//부가적인 파라미터들
		String pageQuery = makePagingQuery(page);
		String sortQuery=makeSortQuery(request,mav);
		
	
		request_param.append(FieldQuery).append(dateRangeQuery).append(pageQuery).append(sortQuery);
		System.out.println(request_param.toString());
		String url=makingUrl(request_param.toString());
		System.out.println(url);
		
		
		//요청 url로 요청한 뒤 정보를 파싱한후 받아온다.
		SearchResult respInfo=getScdList(url);

		mav.addObject("expression", expression);
		mav.addObject("field",field);
		mav.addObject("scdList",respInfo.getScdList());
		mav.addObject("total",respInfo.getTotalCnt());
		mav.addObject("start",respInfo.getStart());
		mav.addObject("page",page);
		
		PageUtil.setPaging(mav, (int)respInfo.getTotalCnt(), 10, page);
					
		return mav;
	}
	
	@RequestMapping(value = "/searchTotal", method = RequestMethod.POST)
	public ModelAndView searchTotal(HttpServletRequest request) {
		System.out.println("Call searchTotal");
		ModelAndView mav=new ModelAndView("common/searchResult");
		
		String expression=request.getParameter("expression");
		String field=request.getParameter("field");
		
		//쿼리가 만들어질 StringBuffer 변수
		StringBuffer request_param=new StringBuffer();
		int page = modifyPageType(request);
		
				
		//query												
		String FieldQuery=makeFieldQuery(expression,field);
		String dateRangeQuery=makeDateRangeQuery(request,mav);
		//query!
		
		//부가적인 파라미터들
		String pageQuery = makePagingQuery(page);
		String sortQuery=makeSortQuery(request,mav);
		
	
		request_param.append(FieldQuery).append(dateRangeQuery).append(pageQuery).append(sortQuery);
		System.out.println(request_param.toString());
		String url=makingUrl(request_param.toString());
		System.out.println(url);
		
		
		//요청 url로 요청한 뒤 정보를 파싱한후 받아온다.
		SearchResult respInfo=getScdList(url);

		mav.addObject("expression", expression);
		mav.addObject("field",field);
		mav.addObject("scdList",respInfo.getScdList());
		mav.addObject("total",respInfo.getTotalCnt());
		mav.addObject("start",respInfo.getStart());
		mav.addObject("page",page);
		
		PageUtil.setPaging(mav, (int)respInfo.getTotalCnt(), 10, page);
					
		return mav;
	}

	private String makeFieldQuery(String expression, String field) {
		StringBuffer fieldQuery=new StringBuffer();
		if(expression==null || expression.trim().equals("")){
			fieldQuery.append("q=*:*");
		}
		else{
			fieldQuery.append("q="+field+":"+encodingQuery(expression));
		}
		return fieldQuery.toString();
	}



	private int modifyPageType(HttpServletRequest request) {
		int page;
		if(request.getParameter("page") == null || request.getParameter("page").trim().equals("")){
			page=1;
		}else{
			page=Integer.parseInt(request.getParameter("page"));
		}
		return page;
	}

	/**
	 * 
	 * @param request
	 * @return
	 * @description
	 * 페이지 파라미터를 만드는 메소드
	 */
	private String makePagingQuery(int page) {
		StringBuffer query=new StringBuffer();		
		
		query.append("&start="+10*(page-1));
		return query.toString();
	}
	
	/**
	 * @param request
	 * @param mav 
	 * @return
	 * @description
	 * 정렬 파라미터를 만드는 메소드
	 */

	private String makeSortQuery(HttpServletRequest request, ModelAndView mav) {
		StringBuffer query=new StringBuffer();
		
		if(request.getParameter("sort")!=null){
			String sort_type=request.getParameter("sort");
			mav.addObject("sort",sort_type);
			if(sort_type.equals("date")){
				query.append("&sort="+sort_type+"+desc");
			}
		}else{
			mav.addObject("sort","date");
			return "";
		}
		
		return query.toString();
	}

	/**
	 * 
	 * @param request
	 * @param mav 
	 * @return
	 * @description
	 * 시작일 값과 종료일 값을 받아와서 루씬 QueryParser에서 처리할 수 있는 쿼리를 만든다.
	 */
	private String makeDateRangeQuery(HttpServletRequest request, ModelAndView mav) {
		String parameter = "rank_idx_bc";
		StringBuffer Query=new StringBuffer();
		String startDate="";
		String endDate="";
		String sDate=request.getParameter("date");
		System.out.println("sDate : "+sDate);
		int date=11;
		if(sDate ==null || sDate.trim().equals("")){
			mav.addObject("date", date);
			return "";
		}else{			
			date=Integer.parseInt(sDate);
			mav.addObject("date", date);
			if(date==15){
				startDate=request.getParameter("startDate0");
				endDate=request.getParameter("endDate0");
				//startDate=changeDateFormat(request.getParameter("startDate0"));
				//endDate=changeDateFormat(request.getParameter("endDate0"));					
			}
			else if(date==11){ //전체 날짜 검색
				return "";
			}
			else{
				switch (date) {			
				case 12://1주 검색
					startDate=DateUtil.getCurrentDate();
					endDate=DateUtil.get7DayAgoDate();
					break;
				case 13://1개월 검색
					startDate=DateUtil.getCurrentDate();
					endDate=DateUtil.getMonthAgoDate();
					break;
				case 14://1년 검색
					startDate=DateUtil.getCurrentDate();
					endDate=DateUtil.get1YearAgoDate();
					break;
				default:
					break;
				}
			}
			Query.append("+AND+").append(parameter).append(encodingQuery(":[ ")).append(startDate).append("+TO+").append(endDate).append(encodingQuery(" ]"));
		}
		mav.addObject("startDate0",startDate);
		mav.addObject("endDate0",endDate);
		return Query.toString();
	}
	

	
	private String changeDateFormat(String parameter) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd");
		Date date = null;
		try {
			date = sdf.parse(parameter);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyyMMdd");
		return sdf2.format(date);
	}



	private String makingUrl(String request_param) {
		StringBuffer url=new StringBuffer("http://1.234.16.50:9000/solr/topic_posts");
		url.append("/select?");
		url.append(request_param);
		url.append("&wt=json&indent=true");
		return url.toString();
	}

	private String encodingQuery(String q){
		try {
			return URLEncoder.encode(q, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	private SearchResult getScdList(String url){
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



	private List<Topic> getSCDList(JSONObject resp) {
		JSONArray docs=(JSONArray)resp.get("docs");
		ArrayList<Topic> scdList=new ArrayList<Topic>();
		for(int i=0;i<docs.size();i++){
			Topic topic=new Topic();
			
			JSONObject doc=(JSONObject)docs.get(i);
			
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
			
			System.out.println(topic.getPostSubject());//20160120
			scdList.add(topic);
		}
		return scdList;
	}
	
}
