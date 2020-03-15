<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% %>
<% response.setCharacterEncoding("UTF-8");  %>
<tr>
			<td height="20" width="500">&nbsp;</td>
			<td height="20" width="500" align="right">
				<a href="javascript:goHome();">ホーム</a>&nbsp;&nbsp;			
			<c:choose>	
			<c:when test="${sessionScope.loginInfo.loginId == null || sessionScope.loginInfo.loginId == '' }">
				<a href="javascript:memberWrite();">会員登録</a>&nbsp;&nbsp;
				<a href="javascript:login();" >ログイン</a>&nbsp;&nbsp;
			</c:when>
			<c:otherwise>
				<a href="javascript:memberModify();">会員情報修正</a>&nbsp;&nbsp;
				<a href="javascript:logout();" >ログアウト</a>&nbsp;&nbsp;
			</c:otherwise>
			</c:choose>	
								
			</td>
</tr>
<tr>
			<td height="60" width="500" bgcolor="#0D3EA3" align="center">
				<a href="javascript:boardList();" style="font-size:20px;color:#FFFFFF;font-weight:bold;text-decoration:none;">一般掲示板</a>
				
			</td>
			<td height="60" width="500" bgcolor="#0D3EA3" align="center">
				<a href="javascript:photoList();" style="font-size:20px;color:#FFFFFF;font-weight:bold;text-decoration:none;">フォト掲示板</a>
				
			</td>			
</tr>