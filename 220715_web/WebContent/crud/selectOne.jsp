<%@page import="dao.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	EmpDao ed = new EmpDao();
	ed.connect();
	
%>
<jsp:useBean id="emp" class="dto.EmpDto" scope="request"/>
<%
	emp.match(ed.getEmp(Integer.valueOf(request.getParameter("id"))));
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:getProperty property="employee_id" name="emp"/><br/>
<jsp:getProperty property="first_name" name="emp"/><br/>
<jsp:getProperty property="salary" name="emp"/><br/>
<jsp:getProperty property="email" name="emp"/>
</body>
</html>