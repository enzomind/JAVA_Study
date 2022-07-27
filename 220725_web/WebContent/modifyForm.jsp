<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="guestbook.service.ModifyMessageService"%>
<%@ page import="guestbook.service.InvalidPassowrdException"%>

<%@ page import="guestbook.dao.MessageDao"%>
<%@ page import="guestbook.model.Message"%>

<%
	int messageId = Integer.parseInt(request.getParameter("messageId"));
	String password = request.getParameter("password");
	boolean rightPassowrd = true;
	try {
		
		ModifyMessageService modifyService = ModifyMessageService.getInstance();
		modifyService.check(messageId, password);		
		
		
	} catch (InvalidPassowrdException ex) {
		rightPassowrd = false;
	}	
%>
<html>
<head>
<title>방명록 메시지 수정</title>
</head>
<body>
	<%	
		if (rightPassowrd) {
			
			ModifyMessageService modifyService = ModifyMessageService.getInstance();
			Message mg = new Message();
			mg = modifyService.select(messageId);
	%>
	
	<form action="modifyMessage.jsp" method="post" accept-charset="utf-8">
		<input type="hidden" name="id" value="<%=mg.getId()%>">  
		이름:	<input type="text" name="studentName" value="<%=mg.getStudentName()%>"> <br> 
		국어:<input type="text" name="korScore" value="<%=mg.getKorScore()%>"> <br> 
		수학:<input type="text"	name="mathScore" value="<%=mg.getMathScore()%>"> <br> 
		영어:<input type="text"	name="engScore" value="<%=mg.getEngScore()%>"> <br> 
		평가:<textarea name="message" cols="30" rows="3"><%=mg.getMessage()%></textarea> <br> 
		
		<input type="submit" value="수정하기" />
	</form>

	<%
		} else {
	%>
	입력한 암호가 올바르지 않습니다. 암호를 확인해주세요.
	<%
		}
	%>
	<br />
	<a href="list.jsp">[돌아가기]</a>
</body>
</html>