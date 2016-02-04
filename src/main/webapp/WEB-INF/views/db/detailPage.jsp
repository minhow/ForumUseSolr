<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp"%>	
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
</head>
<body>
	<form name="detailSub" id="detailSub" action="${contextPath }/searchForum" method="post">
		<input type="hidden" name="expression" id="express"/>
	</form>
	<div class="layout_type2_1_wrap">
		<div class="header">
			<%@ include file="/WEB-INF/views/common/header.jsp"%>
		</div>
		<div id="container" class="container">
			<div class="tab_type1">
				<!-- tab_type1 -->
				<ul>
					<li class="on">
						<p class="tab none_mar" id="detail">상세 페이지</p>
						<div class="t_content">
							<!-- t_content통합검색 -->

							<!-- 프로젝트 -->
							<c:forEach var="post" items="${postList }" varStatus="status">
								<div class="jfloat">
									<div class="mar_top50 ">
										<p class="line_type1"></p>
										<span class="txt_bold"> <img
											src="${contextPath}/resources/images/searchBar/btn_type3_arr_rgt.gif"
											alt="프로젝트" /> ${post.postId }. ${post.postSubject }
										</span>
										<p class="line_type2"></p>


										<ul class="list_type5">
											<li>
												<dl>
													<dd>
														<span class="bu_divi none_pl">작성자 :
															${post.postUsername }</span> <a><span>작성 아이피
																:${post.posterIp }</span></a>
													</dd>
													<dd class="desc">
														${post.postText }
													</dd>
												</dl>
											</li>
										</ul>
									</div>
								</div>
							</c:forEach>
							<!-- 프로젝트 -->
						</div> <!-- tab_type1 -->
					</li>
				</ul>
			</div>
		</div>
		
		<input type="hidden" id="whichPageSearch" value="detail"/>
</body>
</html>