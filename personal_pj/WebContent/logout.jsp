<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그아웃 처리</title>
</head>
<body>
	<%
		session.invalidate();//접속한 회원의 세션을 빼앗음
	%>
	<script>
		location.href = 'index.jsp';
	</script>

</body>
</html>