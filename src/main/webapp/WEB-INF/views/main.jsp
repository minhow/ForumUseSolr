<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
</head>
<body>
	<div class="layout_type2_1_wrap">
		<div class="header">
			<%@ include file="/WEB-INF/views/common/header.jsp"%>
		</div>
		<div id="container" class="container">
			<div class="tab_type1">
				<!-- tab_type1 -->
				<ul>
					<li class="on">
						<div class="t_content">
							<!-- t_content통합검색 -->

							<!-- 프로젝트 -->

							<div class="jfloat">
								<iframe src="${contextPath }/intro" width="100%" height="1000px"></iframe>
							</div>
							<!-- 프로젝트 -->

							<div class="jfloat">
								<iframe src="http://1.234.16.50:5601/app/kibana#/dashboard/sample_dashboard_20160204?embed&_g=(refreshInterval:(display:Off,pause:!f,value:0),time:(from:now%2FM,mode:quick,to:now%2FM))&_a=(filters:!(),options:(darkTheme:!f),panels:!((col:1,id:artist_knm,panelIndex:1,row:5,size_x:12,size_y:4,type:visualization),(col:1,id:xtenhome_apache_log_ip,panelIndex:2,row:1,size_x:12,size_y:4,type:visualization)),query:(query_string:(analyze_wildcard:!t,query:'*')),title:sample_dashboard_20160204,uiState:())" height="890" width="100%"></iframe>
							</div>
						</div> <!-- tab_type1 -->
					</li>
				</ul>
			</div>
		</div>
	</div>

	<input type="hidden" id="whichPageSearch" value="total" />
</body>
</html>