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
<input type="text" name="seqNo" value="${dto.seqNo }" />
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
				<h1>フォト掲示板 - 修正ページ </h1> 
				<table cellpadding="0" cellspacing="0" border="1" width="600">
				<tr>
					<th width="100" bgcolor="#BDBDBD" height="30">タイトル</th>
					<td width="500">
						<input type="text" name="title" style="width:480px;" value="${dto.title }"/>
					</td>
				</tr>
				<tr>
					<th width="100" bgcolor="#BDBDBD" height="30">作成者</th>
					<td width="500">
						${dto.writer }(${dto.loginId })<input type="hidden" name="writer" value="${sessionScope.loginInfo.userName }" /><input type="hidden" name="loginId" value="${sessionScope.loginInfo.loginId }" />
					</td>
				</tr>
				<tr>
					<th width="100" bgcolor="#BDBDBD" height="30">内容</th>
					<td width="500">
						<textarea name="contents" style="width:480px;height:80px;">${dto.contents }</textarea>
					</td>
				</tr>								
				<tr>
					<th width="100" bgcolor="#BDBDBD" height="30">イメージファイル</th>
					<td width="500">
						${dto.imgOrgFile }<br /><input type="text" name="imgOrgFile" value="${dto.imgOrgFile }" /><input type="text" name="imgSavedFile" value="${dto.imgSavedFile}" />
						<input type="file" name="upload"  style="width:480px;"/>
					</td>
				</tr>	
				<tr>
					<td>
					<input type="button" value="目次" onclick="javascript:photoList();" />
					</td>
					<td  >
						<input type="button" value="修正" onclick="javascript:photoModifyAct();" />&nbsp;
						<input type="button" value="削除" onclick="javascript:photoDeleteAct();" />&nbsp;
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