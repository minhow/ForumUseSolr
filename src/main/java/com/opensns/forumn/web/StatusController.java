package com.opensns.forumn.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.opensns.forumn.common.PageUtil;
import com.opensns.forumn.search.SearchResult;
import com.opensns.forumn.service.StatusService;

@Controller
public class StatusController {
	@RequestMapping(value = "/getClusterStatus.do")
	public String home(HttpServletRequest request, ModelMap model) {
		StatusService statusService = new StatusService();
					
		return "clusterStatus";
	}
}
