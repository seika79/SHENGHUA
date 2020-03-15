<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% response.setCharacterEncoding("UTF-8");  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/style.css"/>
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script type="text/javascript">
	//중복확인창 띄우기 
	function idCheck(){
		var loginId = $("#loginId").val();
		//alert(loginId);
		if (loginId == null || loginId == ''){
			alert("チェックしようとするIDを入力してください。");
			return;
		}else{
		
			$.ajax({
				url: "/member/idCheck.do",
				type: "post",
				data: "loginId="+loginId,
				success: function(result){
					
					$("#resultStr").html(result);
				}
				
				
			});
		}		
	}
	
	function idUse(){
		var loginId = $("#loginId").val();
		var idUseYn = $("#idUseYn").val();
		alert("loginId : "+loginId+", idUseYn : "+idUseYn);
		if(idUseYn == null || idUseYn == '' || idUseYn == 'N'){
			alert("使用不可能なIDです。 \n もう一度確認してください。");
			return;
		}else{
			$("#loginId", opener.document).val(loginId);
			window.close();
		}
	}
</script>

</head>
<body>
<form name="springForm" method="post">
<table cellpadding="0" cellspacing="0" width="300" height="300">
<tr>
	<td align="center">
	
		<table cellpadding="0" cellspacing="0" border="0" width="300">
		<!-- // 내용 시작 -->
		<tr>
			<td width="100">
				아이디
			</td>
			<td width="200">
				<input type="text" name="loginId" id="loginId" style="width:100px;"/>&nbsp;
				<input type="button" value="重複確認" id="chkBtn" onclick="javascript:idCheck();" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<div id="resultStr" ></div><br /><br />
				<input type="button" value="ID使用" onclick="javascript:idUse();" />
			</td>
		</tr>

		<!-- // 내용 끝  -->
		</table>
	</td>
</tr>
</table>
</form>
</body>
</html>