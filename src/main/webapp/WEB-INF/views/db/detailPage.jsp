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
		게시글 Id:${post.postId }<br>
		토픽ID:${post.topicId }<br>
		포럼ID;${post.forumId }<br>
		글쓴이IP:${post.posterIp }<br>
		작성자:${post.postUsername }<br>
		제목:${post.postSubject }<br>
		${post.postText }<br>
		-----------------------------------------------------------------------<br>
	</c:forEach>
</body>
</html>