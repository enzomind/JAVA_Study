<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import = "board.Board"%>
<%@ page import = "board.BoardDao"%>	

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자유게시판</title>
</head>
<body>
	<table border="1" cellpadding="0" cellspacing="0">

		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성일자</th>

		</tr>
		<tbody>
			<%
				BoardDao bdao = new BoardDao();
				ArrayList<Board> list = bdao.getList();

				for (int i = 0; i < list.size(); i++) {
			%>
			<tr>
				<td><%=list.get(i).getBno()%></td>
				<td><%=list.get(i).getMid()%></td>
				<td><a href="boardFreeView.jsp?bno=<%=list.get(i).getBno()%>"><%=list.get(i).getTitle()%></td>
				<td><%=list.get(i).getWcontents()%></td>
				<td><%=list.get(i).getWdate()%></td>
			</tr>
			<%
				}
			%>


		</tbody>

	</table>
</body>
</html>