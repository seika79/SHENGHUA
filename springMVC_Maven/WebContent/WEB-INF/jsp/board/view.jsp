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
			<td colspan="2" width="1000" height="300" valign="top" align="center"> 
				<br />
				<h1>一般掲示板詳細 </h1> 

				<table cellpadding="0" cellspacing="0" width="700">
				<tr>
					<th height="30" width="150" bgcolor="#BDBDBD">タイトル</th>
					<td width="550">${dto.title }</td>					
				</tr>
				<tr>
					<th height="30" width="150" bgcolor="#BDBDBD">作成者</th>
					<td width="550">${dto.writer }(${dto.loginId })</td>					
				</tr>	
				<tr>
					<th height="30" width="150" bgcolor="#BDBDBD">登録日</th>
					<td width="550">${dto.createDate }</td>					
				</tr>
				<tr>
					<th height="30" width="150" bgcolor="#BDBDBD">アクセス数</th>
					<td width="550">${dto.hit }</td>					
				</tr>	
				<tr>
					<th height="30" width="150" bgcolor="#BDBDBD">内容</th>
					<td width="550">
						<%request.setAttribute("n","\n");%>
						${fn:replace(dto.contents,n,"<br/>")}	</td>					
				</tr>					
				<tr>
					<th height="30" width="150" bgcolor="#BDBDBD">添付ファイル</th>
					<td width="550">
						<a href="javascript:down();">${dto.orgFileName }</a>	</td>					
				</tr>	
				<tr>
					<td height="30" >
						<input type="button" value="目次" onclick="javascript:boardList();" />
					</td>
					<td height="30">
						<input type="button" value="修正" onclick="javascript:boardModify();" />&nbsp;
						<input type="button" value="削除" onclick="javascript:boardDeleteAct();" />&nbsp;
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