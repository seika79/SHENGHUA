<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% response.setCharacterEncoding("UTF-8");  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<jsp:include page="/include/header.jsp"></jsp:include>
</head>
<body>
<form name="springForm" method="post">
<table cellpadding="0" cellspacing="0" width="100%">
<tr>
	<td align="center">
	
		<table cellpadding="0" cellspacing="0" border="0" width="1000">
		<!-- // 상단메뉴 시작  -->
		<jsp:include page="/include/top.jsp"></jsp:include>
		<!-- // 상단메뉴 끝 -->
		<tr><td colspan="2" width="1000" height="10"></td></tr>
			
		<!-- // 내용 시작 -->
		<tr>
			<td width="500" height="300" valign="top" align="center"> 
				<br/>
				
				<table cellpadding="0" cellspacing="0" width="300">
				<tr>
					<td width="220" align="left"><h3><a href="javascript:boardList();">一般掲示板</a></h3></td>
					<td width="80" align="right"><a href="javascript:boardList();">MORE</a></td>
				</tr>
				<tr>
					<td colspan="2" style="border-bottom:solid 2px #BDBDBD;"></td>
				</tr>
				<c:forEach items="${mainBoard }" var="boardDto">
					<tr>
						<td width="170" align="left"> - ${boardDto.title }</td>
						<td width="130" align="center">${boardDto.createDate }</td>
					</tr>				
				</c:forEach>

				</table>


			</td>
			<td width="500" height="300" valign="top" align="center"> 
		



			</td>			
		</tr>
		<!-- // 내용 끝  -->
		<tr><td colspan="2" width="1000" height="10"></td></tr>		
		<!-- // copyright 시작 -->
		<jsp:include page="/include/footer.jsp"></jsp:include>	
		<!-- // copyright 끝 -->		
		</table>
	</td>
</tr>
</table>
</form>
</body>
</html>