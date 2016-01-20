<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/views/common/includejs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<table>
	<tbody>
		<tr>
			<div class="searchBar_type2">



				<p class="sch_txt">
					<img src="${contextPath}/resources/images/searchBar/txt_search.png" alt="search" />
				</p>
				<div class="sch_bar">
					<p class="selected">
						<span class="txt"></span> <span class="btn"><img class
							src="${contextPath}/resources/images/searchBar/btn_type2_arr_off.gif" alt="리스트보기" /></span>
					</p>
					<ul>
						<li>통합검색</li>
						<li>게시판</li>
						<li>지식샘</li>
						<li>커뮤니티</li>
						<li>전자도서관</li>
					</ul>
					
					<input class="sch_input" type="text" value="검색어를 입력하세요." /> 
					<span class="sch_btn">
						<img src="${contextPath}/resources/images/searchBar/btn_type2_sch.gif" alt="검색" /></span>
				</div>
				<!-- sch_bar -->

				<br> <br>

				<div class="sch_bar2">
					&nbsp;&nbsp;<input type="checkbox" id="research" /><label
						for="research">결과내 검색</label>
				</div>


				<dl>
					<dt>
						<img src="${contextPath}/resources/images/searchBar/icon_keyword.png" alt="키워드" />
					</dt>
					<dd>검색어01</dd>
					<dd>검색어02</dd>
					<dd>검색어03</dd>
					<dd class="none_bg">검색어04</dd>
				</dl>


			</div>
			<!-- searchBar_type2-->
		</tr>
	</tbody>
</table>