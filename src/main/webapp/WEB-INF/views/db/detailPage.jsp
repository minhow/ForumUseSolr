<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="post" items="${postList }" varStatus="status">
		�Խñ� Id:${post.postId }<br>
		����ID:${post.topicId }<br>
		����ID;${post.forumId }<br>
		�۾���IP:${post.posterIp }<br>
		�ۼ���:${post.postUsername }<br>
		����:${post.postSubject }<br>
		${post.postText }<br>
		-----------------------------------------------------------------------<br>
	</c:forEach>
</body>
</html>