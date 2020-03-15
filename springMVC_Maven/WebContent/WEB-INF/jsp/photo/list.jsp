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
<input type="hidden" name="pageNo" value="${pageNo }"/>
<input type="hidden" name="seqNo" value="" />
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
				<h1>フォト掲示板 </h1> <br />
				<table border="1" cellpadding="0" cellspacing="0" width="600">
				<c:if test="${totalCnt <=0 }">
					<tr>
						<td colspan="2" width="700" align="center" height="30">
							*登録された内容はありません。 
						</td>
					</tr>
				</c:if>
				<c:if test="${totalCnt >0 }">
					<c:set var="no" value="${totalCnt-(pageNo-1)*numPerPage }" />				
									
				<c:forEach items="${photoList }" var="dto">
					<tr>
						<td width="100" rowspan="2" height="90">
							<c:if test="${fn:trim(dto.thumbnail) != null && fn:trim(dto.thumbnail) != '' }">
								<a href="javascript:photoView('${dto.seqNo }');"><img src="/file/photo/${dto.thumbnail }" border="0" /></a>
							</c:if>
						</td>
						<td width="500" height="30">
						<span style="font-weight:bold;"><a href="javascript:photoView('${dto.seqNo }');">${dto.title }</a></span>
						</td>
					</tr>
					<tr>
						<td width="500" height="60"><a href="javascript:photoView('${dto.seqNo }');">${dto.contents }</a></td>
					</tr>
					<tr>
						<td colspan="2" width="600" style="border-bottom:dotted 1px #000000;"></td>
					</tr>
					<c:set var="no" value="${no-1 }" />			
				</c:forEach>
				</c:if>
				</table>
				<table cellpadding="0" cellspacing="0" width="600">
				<tr>
					<td width="100" height="50">&nbsp;</td>
					<td width="400" height="50" align="center">${pageIndex }</td>
					<td width="100" height="50" align="right">
					<c:if test="${sessionScope.loginInfo.loginId != null && sessionScope.loginInfo.loginId != '' }">
						<input type="button" value="글쓰기" onclick="javascript:photoWrite();" />&nbsp;
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