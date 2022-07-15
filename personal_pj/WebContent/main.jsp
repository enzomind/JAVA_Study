<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>



<%
if(session.getAttribute("sessionId") != null) {
%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인 메뉴</title>
</head>
<body>

<form method="post" action="board_notice.jsp">
<button>공지게시판</button>
</form>
<br/>


<form method="post" action="board_faq.jsp">
<button>FAQ</button>
</form>
<br/>


<form method="post" action="board_free.jsp">
<button>자유게시판</button>
</form>


<form method="post" action="logout.jsp">
접속 계정 : <%=session.getAttribute("sessionId")%>
<button>로그아웃</button>
</form>


</body>
</html>

<%
} else {
	PrintWriter script = response.getWriter();
	
	script.println("<script>");
	script.println("alert('로그인을 먼저 하셔야 합니다.');");
	script.println("location.href='login.jsp'");
	script.println("</script>");
}
%>
