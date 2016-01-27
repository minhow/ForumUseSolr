package com.opensns.forumn.web;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.opensns.forumn.common.PageUtil;
import com.opensns.forumn.search.SearchResult;
import com.opensns.forumn.service.StatusService;
import com.opensns.forumn.service.status.Collection;

@Controller
public class StatusController {
	@RequestMapping(value = "/getClusterStatus.do")
	public ResponseEntity<String> getClusterStatus(HttpServletRequest request, ModelMap model) {
		StatusService statusService = new StatusService();
		Collection collection = statusService.getClusterStatus();
		JSONObject statusJson =  collection.toCyElementsJson();
		System.out.println(statusJson.toJSONString());
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/json; charset=UTF-8");
		return new ResponseEntity<String>(statusJson.toJSONString(), responseHeaders, HttpStatus.OK);
	}
}
