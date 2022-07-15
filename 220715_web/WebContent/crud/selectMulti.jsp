<%@page import="dao.*"%>
<%@page import="dto.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	EmpDao ed = new EmpDao();
	ed.connect();
	int start = ed.selectMin();
	int stop = ed.selectMax();
%>
<jsp:useBean id="emp" class="dto.EmpDto" scope="request"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" cellpadding="0" cellspacing="0">
<%
	for (int i=start; i <= stop; i++) {
		Employees em = ed.getEmp(i);
		if (em != null) {
			emp.match(em);
		%>
		<tr>
		<td><jsp:getProperty property="employee_id" name="emp"/></td>
		<td><jsp:getProperty property="first_name" name="emp"/></td>
		<td><jsp:getProperty property="salary" name="emp"/></td>
		<td><jsp:getProperty property="email" name="emp"/></td>
		</tr>
<% 		}
	}	
%>
</table>
</body>
</html>