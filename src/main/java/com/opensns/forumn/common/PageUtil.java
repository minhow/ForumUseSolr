package com.opensns.forumn.common;

import org.springframework.web.servlet.ModelAndView;


public class PageUtil {
	public static void setPaging(ModelAndView mav, int totalDocCount, int pageViewCount, int page) {
		int tPage = 0 ;
		int cPage = page;
		int sPage;
		int ePage;
		if(totalDocCount % pageViewCount == 0)
			tPage = totalDocCount / pageViewCount;
		else 
			tPage = totalDocCount / pageViewCount + 1;
		
		if(cPage % pageViewCount != 0) {
			sPage = (cPage / pageViewCount) * pageViewCount + 1;
			ePage = (cPage / pageViewCount + 1) * pageViewCount;
		}
		else {
			sPage = (cPage / pageViewCount - 1) * pageViewCount + 1;
			ePage =  (cPage / pageViewCount ) * pageViewCount;
		}
		
		if(ePage > tPage)
			ePage = tPage;
		
		mav.addObject("tPage",tPage);
		mav.addObject("cPage",page);
		mav.addObject("sPage",sPage);
		mav.addObject("ePage",ePage);
		mav.addObject("totalCnt",totalDocCount);
	}	
}
