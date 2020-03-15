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
<form name="springForm" method="post" enctype="multipart/form-data">
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
			<td colspan="2" width="1000" height="300" valign="top" align="center"> 
				<br />
				<h1>一般掲示板作成</h1> 

				<table cellpadding="0" cellspacing="0" width="700">

				<tr>
					<th width="150" height="30" bgcolor="#BDBDBD" align="center">タイトル</th>
					<td width="550" height="30" >
						<input type="text" name="title" style="width:500px;" />
					</td>
				</tr>
				<tr><td height="1" colspan="2" style="border-bottom:solid 1px #BDBDBD;"></td></tr>
				
				<tr>
					<th width="150" height="30" bgcolor="#BDBDBD" align="center">作成者</th>
					<td width="550" height="30" >
						<input type="text" name="writer" style="width:500px;" />
					</td>
				</tr>
				<tr><td height="1" colspan="2" style="border-bottom:solid 1px #BDBDBD;"></td></tr>

				<tr>
					<th width="150" height="30" bgcolor="#BDBDBD" align="center">ID</th>
					<td width="550" height="30" >
						<input type="text" name="loginId" style="width:500px;" />
					</td>
				</tr>	
				<tr><td height="1" colspan="2" style="border-bottom:solid 1px #BDBDBD;"></td></tr>

				<tr>
					<th width="150" height="80" bgcolor="#BDBDBD" align="center">内容</th>
					<td width="550" height="80" >
						<textarea style="width:500px;height:70px;"></textarea>
					</td>
				</tr>	
				<tr><td height="1" colspan="2" style="border-bottom:solid 1px #BDBDBD;"></td></tr>
				<tr>
					<th width="150" height="30" bgcolor="#BDBDBD" align="center">添付ファイル</th>
					<td width="550" height="30" >
						<input type="file" name="upload" style="width:500px;" />
					</td>
				</tr>	
				<tr><td height="1" colspan="2" style="border-bottom:solid 1px #BDBDBD;"></td></tr>

				<tr>
					<td colspan="2" height="30">
						<input type="button" value="保存" onclick="javascript:boardWriteAct();" />
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