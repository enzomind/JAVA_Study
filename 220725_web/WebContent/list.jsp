<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="guestbook.model.Message"%>
<%@ page import="guestbook.service.MessageListView"%>
<%@ page import="guestbook.service.GetMessageListService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String pageNumberStr = request.getParameter("page");
	int pageNumber = 1;
	if (pageNumberStr != null) {
		pageNumber = Integer.parseInt(pageNumberStr);
	}

	GetMessageListService messageListService = GetMessageListService.getInstance();
	MessageListView viewData = messageListService.getMessageList(pageNumber);
%>
<c:set var="viewData" value="<%= viewData %>"/>
<html>
<head>
	<title>성적 조회</title>
</head>
<body>

<form action="writeMessage.jsp" method="post">
이름: <input type="text" name="studentName"> <br>
암호: <input type="password" name="password"> <br>
국어: <input type="text" name="korScore"> <br>
수학: <input type="text" name="mathScore"> <br>
영어: <input type="text" name="engScore"> <br>
평가: <textarea name="message" cols="30" rows="3"></textarea> <br>
<input type="submit" value="메시지 남기기" />
</form>
<hr>
<c:if test="${viewData.isEmpty()}">
등록된 성적 정보가 없습니다.
</c:if>

<c:if test="${!viewData.isEmpty()}">
<table border="1">
	<c:forEach var="message" items="${viewData.messageList}">
	<tr>
		<td>
		메시지 번호: ${message.id} <br/>
		학생 이름: ${message.studentName} <br/>
		국어 점수: ${message.korScore} <br/>
		수학 점수: ${message.mathScore} <br/>
		영어 점수: ${message.engScore} <br/>
		
		총점 점수: ${message.summury} <br/>
		평균 점수: ${message.avg} <br/>
		
		성적 평가: ${message.message} <br/>
		<a href="confirmModify.jsp?messageId=${message.id}">[수정하기]</a>
		<a href="confirmDeletion.jsp?messageId=${message.id}">[삭제하기]</a>
		</td>
	</tr>
	</c:forEach>
</table>

<c:forEach var="pageNum" begin="1" end="${viewData.pageTotalCount}">
<a href="list.jsp?page=${pageNum}">[${pageNum}]</a> 
</c:forEach>

</c:if>
</body>
</html>