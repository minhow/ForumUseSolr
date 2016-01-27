<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<p class="pagging_type1 mar_top10">
		<c:if test="${cPage != 1 }">
			<span class="pre">
				<a href="#">				
					<img src="${contextPath}/resources/images/pagging/btn_first.gif" alt="첫페이지" />				
				</a>
			</span> 
		</c:if>
		<c:if test="${cPage - 1 > 0 }">
			<span class="pre">
				<a href="#">				
					<img src="${contextPath}/resources/images/pagging/btn_pre.gif" alt="이전페이지" />				
				</a>
			</span>
		</c:if>
			<c:forEach var="value" begin="${sPage }" end="${ePage }" step="1"> 			
				<c:choose>
					<c:when test="${cPage == value }">					
						<a href="#">${value}</a> 						
					</c:when>
					<c:otherwise>
						<span>
							<a href="javascript:movePage('${value}');">${value}</a>
						</span>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		<c:if test="${cPage + 1 <= tPage }">
			<span class="next">
				<a href="#">
					<img src="${contextPath}/resources/images/pagging/btn_next.gif" alt="다음페이지" />
				</a>
			</span>
		</c:if>
		<c:if test="${cPage != tPage && tPage != 0 }">
			<span class="next">
				<a href="#">
					<img src="${contextPath}/resources/images/pagging/btn_end.gif" alt="마지막페이지" />
				</a>
			</span>
		</c:if>
	</p>