<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="board.BoardDao" %>
<%@ page import="java.io.PrintWriter" %>

<%
	request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="bean" class="board.Board" scope="page" />
<jsp:setProperty name="bean" property="mid" />
<jsp:setProperty name="bean" property="mpw" />

<!DOCTYPE html> <!-- 꼭 써야되나 이해안감 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 처리</title>
</head>
<body>

<%

	BoardDao bdao = new BoardDao();
	PrintWriter script = response.getWriter();

	
	if(bean.getMid()==null && bean.getMpw()==null) {
		script.println("<script>");
		script.println("alert('아이디와 비밀번호를 입력하십시오.');");
		script.println("history.back()");
		script.println("</script>");
	}
	
	
	
	int result = bdao.login(bean.getMid(), bean.getMpw());
	
	System.out.println("입력 ID 로그 : " + bean.getMid());
	System.out.println("입력 PW 로그 : " + bean.getMpw());
	System.out.println("로그인 result 값 로그 : " + result);
	
	
	if(result == 1) {
		session.setAttribute("sessionId", bean.getMid());
		script.println("<script>");
		script.println("location.href='main.jsp'");
		script.println("</script>");
	}else if (result == 0) {  // 예외처리
		script.println("<script>");
		script.println("alert('비밀번호가 틀렸습니다.');");
		script.println("history.back()");
		script.println("</script>");
	}else if (result==-1) {
		script.println("<script>");
		script.println("alert('존재하지 않는 아이디입니다.');");
		script.println("history.back()");
		script.println("</script>");
	}else if (result==-2) {
		script.println("<script>");
		script.println("alert('서버 오류 발생. 관리자에게 문의하시기 바랍니다.');");
		script.println("history.back()");
		script.println("</script>");
	}
%>
</body>
</html>