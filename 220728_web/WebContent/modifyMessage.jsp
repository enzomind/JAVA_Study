<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="guestbook.model.Message" %>
<%@ page import="guestbook.service.ModifyMessageService" %>


<jsp:useBean id="message" class="guestbook.model.Message">
	<jsp:setProperty name="message" property="id" />
	<jsp:setProperty name="message" property="studentName" />
	<jsp:setProperty name="message" property="korScore" />
	<jsp:setProperty name="message" property="mathScore" />
	<jsp:setProperty name="message" property="engScore" />
	<jsp:setProperty name="message" property="message" />
</jsp:useBean>

<%
	ModifyMessageService mdService = ModifyMessageService.getInstance();
	mdService.modify(message);
%>
<html>
<head>
	<title>방명록 메시지 수정</title>
</head>
<body>
수정이 완료되었습니다.
<br/>
<a href="list.jsp">[목록 보기]</a>
</body>
</html>