<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.SQLException" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB테스트</title>
</head>
<body>
<center><h2>DB테스트용 JSP Page</h2></center>
<table width="800" border="1" align="center">
<tr>
<th>번호</th>
<th>이름</th>
</tr>
<%
try{
	Class.forName("oracle.jdbc.driver.OracleDriver"); 
	conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##hr", "hr");
	pstmt = conn.prepareStatement(sql); 
	rs = pstmt.executeQuery(); 
	
	while(rs.next()){ 
	out.print("<tr>");
		out.print("<td>" + rs.getString("number") + "</td>");
		out.print("<td>" + rs.getString("name") + "</td>");

		out.print("</tr>");
	}
	
	rs.close();
	pstmt.close();
	conn.close();
}catch(Exception e){
	e.printStackTrace();
}finally{
	try{
	if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
	}catch(Exception e){
		e.printStackTrace();
	}
}
%>
</table>
</body>
</html>