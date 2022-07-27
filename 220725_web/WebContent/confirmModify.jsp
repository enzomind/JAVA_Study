<%@ page contentType="text/html; charset=utf-8"%>

<html>
<head>
<title>수정 전 비밀번호 체크</title>
</head>
<body>

	<form action="modifyForm.jsp" method="post" accept-charset="utf-8">
		<input type="hidden" name="messageId" value="${param.messageId}">
		
		메시지를 수정하시려면 암호를 입력하세요:<br> 암호: <input type="password"
			name="password"> <br> <input type="submit"
			value="비밀번호 체크">
		
	</form>
</body>
</html>
