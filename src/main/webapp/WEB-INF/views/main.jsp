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
						</div> <!-- tab_type1 -->
					</li>
				</ul>
			</div>
		</div>
	</div>

		<input type="hidden" id="whichPageSearch" value="total"/>
</body>
</html>