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
<input type="hidden" name="seqNo" value="${dto.seqNo }" />
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
				<h1>フォト掲示板　詳細ページ </h1> 
				<table cellpadding="0" cellspacing="0" border="1" width="800">
				<tr>
					<th width="100" bgcolor="#BDBDBD" height="30">タイトル</th>
					<td colspan="3" width="700" height="30">${dto.title }</td>					
				</tr>
				<tr>
					<th width="100" bgcolor="#BDBDBD" height="30">作成者</th>
					<td colspan="3" width="700" height="30">${dto.writer }(${dto.loginId })</td>
				</tr>
				<tr>
					<th width="100" bgcolor="#BDBDBD" height="30">作成日</th>
					<td width="300" height="30">${dto.createDate }</td>
					<th width="100" bgcolor="#BDBDBD" height="30">アクセス数</th>
					<td width="300" height="30">${dto.hit }</td>											
				</tr>	
				<tr>
					<td colspan="4" width="700" height="30">
						<c:if test="${fn:trim(imgSavedFile) != null || fn:trim(imgSavedFile) != '' }">
							<img src="/file/photo/${dto.imgSavedFile }" border="0" /><br /><br />							
						</c:if>
						${dto.contents }
					</td>
				</tr>											
				</table>
				<table cellpadding="0" cellspacing="0" width="800" >
				<tr>
					<td width="200" height="30">
						<input type="button" value="目次" onclick="javascript:photoList();" />
					</td>
					<td width="400" height="30">&nbsp;</td>
					<td width="200" height="30">
						<c:if test="${fn:trim(sessionScope.loginInfo.loginId) == fn:trim(dto.loginId)}">
							<input type="button" value="修正" onclick="javascript:photoModify();" />&nbsp;
							<input type="button" value="削除" onclick="javascript:photoDeleteAct();" />&nbsp;
						</c:if>
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