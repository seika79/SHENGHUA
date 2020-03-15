　<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
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
			<td colspan="2" width="1000" height="300" valign="top">
				<br />
				<h1>ログイン </h1>
				${errMsg } 
				<table cellpadding="0" cellspacing="0" border="1" >
				<tr>
					<th width="150" height="30" bgcolor="#BDBDBD">ID</th>
					<td>
						<input type="text" name="loginId" style="width:600px;" />
					</td>
				</tr>
				<tr>
					<th width="150" height="30" bgcolor="#BDBDBD">パスワード</th>
					<td>
						<input type="text" name="pswd" style="width:600px;" />
					</td>
				</tr>	
				<tr>
					<td colspan="2" align="center">
						<input type="button" value="ログイン" onclick="javascript:loginAct();"/>
					</td>
				</tr>
				</table>
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