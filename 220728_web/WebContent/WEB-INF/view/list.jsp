<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<html>
<head>
	<title>성적 조회</title>
</head>
<body>

<form action="write.do" method="post">
이름: <input type="text" name="studentName"> <br>
암호: <input type="password" name="password"> <br>
국어: <input type="text" name="korScore"> <br>
수학: <input type="text" name="mathScore"> <br>
영어: <input type="text" name="engScore"> <br>
평가: <textarea name="message" cols="30" rows="3"></textarea> <br>
<input type="submit" value="메시지 남기기" />
</form>
<hr>
<c:if test="${viewData.isEmpty()}">
등록된 성적 정보가 없습니다.
</c:if>

<c:if test="${!viewData.isEmpty()}">
<table border="1">
	<c:forEach var="message" items="${viewData.messageList}">
	<tr>
		<td>
		메시지 번호: ${message.id} <br/>
		학생 이름: ${message.studentName} <br/>
		국어 점수: ${message.korScore} <br/>
		수학 점수: ${message.mathScore} <br/>
		영어 점수: ${message.engScore} <br/>
		
		총점 점수: ${message.summury} <br/>
		평균 점수: ${message.avg} <br/>
		
		성적 평가: ${message.message} <br/>
		성적 순위: ${message.rank} <br/>
		<a href="confirmModify.jsp?messageId=${message.id}">[수정하기]</a>
		<a href="passcondel.do?messageId=${message.id}">[삭제하기]</a>
		</td>
	</tr>
	</c:forEach>
</table>

<c:forEach var="pageNum" begin="1" end="${viewData.pageTotalCount}">
<a href="list.do?page=${pageNum}">[${pageNum}]</a> 
</c:forEach>

</c:if>
</body>
</html>