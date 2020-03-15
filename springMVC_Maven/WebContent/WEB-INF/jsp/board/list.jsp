<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% response.setCharacterEncoding("UTF-8");  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>Insert title here</title>
<jsp:include page="/include/header.jsp"></jsp:include>
</head>
<body>
<form name="springForm" method="post">
<input type="hidden" name="pageNo" value="${pageNo }" />
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
				<h1>一般掲示板目次 </h1>
				<!-- <div><input type="text" name="searchText" id="searchText" value="<%=request.getParameter("searchText")%>"/><input type="button" value="検索" onclick="javascript:boardList();"/></div> -->
				<table cellpadding="0" cellspacing="0" width="700">
				<tr>
					<td width="100" height="30" bgcolor="#BDBDBD" align="center">番号</td>
					<td width="300" height="30" bgcolor="#BDBDBD" align="center">タイトル</td>
					<td width="50" height="30" bgcolor="#BDBDBD" align="center">ファイル</td> 
					<td width="100" height="30" bgcolor="#BDBDBD" align="center">作成者</td>
					<td width="150" height="30" bgcolor="#BDBDBD" align="center">登録日</td>
				</tr>
				<c:if test="${totalCnt <=0 }">
					<tr>
						<td colspan="4" width="700" align="center" height="30">
							*登録した内容はありません。 
						</td>
					</tr>
				</c:if>
				<c:if test="${totalCnt >0 }">
					<c:set var="no" value="${totalCnt-(pageNo-1)*numPerPage }" />				
					<c:forEach items="${boardList }" var="dto"> 
						<tr>
							<td height="30" align="center" style="border-bottom:dotted 1px #BDBDBD;">${no }</td>
							<td height="30" style="padding-left:3x;border-bottom:dotted 1px #BDBDBD;">
								<a href="javascript:boardView('${dto.seqNo }');">${dto.title }</a>
							</td>
							<td height="30" align="center" style="border-bottom:dotted 1px #BDBDBD;">
							<c:if test="${dto.fileYn == 'Y' }" >
								<img src="/img/icon_disk.gif"  border="0" />
							</c:if>
							<c:if test="${dto.fileYn != 'Y' }" >
								&nbsp;
							</c:if>							
							</td>							
							<td height="30" align="center" style="border-bottom:dotted 1px #BDBDBD;">${dto.writer }</td>
							<td height="30" align="center" style="border-bottom:dotted 1px #BDBDBD;">${dto.createDate }</td>
						</tr>
						<c:set var="no" value="${no-1 }" />	
					</c:forEach>
				</c:if>
				</table> 
				<!-- // 페이징 -->
				<table cellpadding="0" cellspacing="0" width="700">
				<tr>
					<td height="40" width="150">&nbsp;</td>
					<td height="40" width="400" align="center">${pageIndex }</td>
					<td height="40" width="150" align="right">
						<input type="button" value="作成" onclick="javascript:boardWrite();" />&nbsp;&nbsp;
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