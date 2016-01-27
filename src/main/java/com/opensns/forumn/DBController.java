package com.opensns.forumn;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.opensns.forumn.db.PostServiceImpl;
import com.opensns.forumn.db.vo.PostVO;

@Controller
public class DBController {
	@Autowired
	private PostServiceImpl postService;
	
	@RequestMapping(value = "/forumDB/detailPage", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request) {
		ModelAndView mav=new ModelAndView("db/detailPage");
		String topic_id=request.getParameter("topic_id");
		System.out.println(topic_id);
		HashMap<String, Object>	map=new HashMap<String, Object>();
		map.put("topic_id", Integer.parseInt(topic_id));
		
		
		
		List<PostVO> postList=postService.getPostList(map);
		
		System.out.println(postList.size());
		for(PostVO vo:postList)
		{
			System.out.println(vo);
		}
		
		mav.addObject("postList",postList);
		
					
		return mav;
	}
}
