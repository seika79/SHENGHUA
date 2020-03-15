// 게시판 첨부파일 다운로드
function down(){
	var form = document.springForm;
	form.action = "/board/download.do";
	form.submit();	
	
}

// 일반게시판 목록
function boardList(){
	var form = document.springForm;
	form.action = "/board/list.do";
	form.submit();		
}

// 일반게시판 글쓰기
function boardWrite(){
	var form = document.springForm;
	form.action = "/board/write.do";
	form.submit();		
}

//일반게시판 글쓰기처리
function boardWriteAct(){
	var form = document.springForm;
	
	if(form.title.value == ''){
		alert("タイトルを入力してください。");
		form.title.focus();
		return;
	}else{
		form.action = "/board/writeAct.do";
		form.submit();		
	}
	
}

// 게시판 상세
function boardView(seqNo){
	var form = document.springForm;
	form.seqNo.value = seqNo;
	form.action = "/board/view.do";
	form.submit();	
	
}

//게시판 수정페이지
function boardModify(){
	var form = document.springForm;
	form.action = "/board/modify.do";
	form.submit();	
	
}


//게시판 삭제
function boardDeleteAct(){
	var form = document.springForm;
	form.action = "/board/deleteAct.do";
	form.submit();	
	
}

// 페이지 이동 
function page(pageNo, menu){
	var form = document.springForm;
	form.pageNo.value = pageNo;
	
	if(menu == 'board'){
		form.action = "/board/list.do";		
	}else if(menu == 'photo'){
		form.action = "/photo/list.do";			
	}
	form.submit();		
}

// 회원가입 
function memberWrite(){
	var form = document.springForm;
	form.action = "/member/write.do";
	form.submit();
}

// 회원가입 처리
function memberWriteAct(){
	var form = document.springForm;
	
	if (form.userName.value==''){
		alert("名前を入力してください。");
		form.userName.focus();
		return;
	}else if(form.loginId.value == ''){
		alert("IDを入力してください。");
		form.loginId.focus();
		return;
	}else if(form.pswd.value == ''){
		alert("パスワードを入力してください。");
		form.pswd.focus();
		return;
	}else{
		if(confirm("会員登録しますか？")){
			form.action = "/member/writeAct.do";
			form.submit();	
		}
	}
	
}


// 로그인페이지로 이동
function login(){
	var form = document.springForm;
	form.action = "/member/login.do";
	form.submit();
}

// 로그인 
function loginAct(){
	var form = document.springForm;
	
	if(form.loginId.value == ''){
		alert("IDを入力してください。");
		form.loginId.focus();
		return;
	}else if(form.pswd.value == ''){
		alert("パスワードを入力してください。");
		form.pswd.focus();
		return;	
	}else{
		form.action = "/member/loginAct.do";
		form.submit();	
	}
}

function logout(){
	var form = document.springForm;
	
	if(confirm("ログアウトしますか？")){
		form.action = "/member/logout.do";
		form.submit();	
	}	
	
}

function goHome(){
	
	var form = document.springForm;
	form.action = "/main.do";
	form.submit();
}

// 사진게시판 목록
function photoList(){
	var form = document.springForm;
	form.action = "/photo/list.do";
	form.submit();
	
}

// 사진게시판 등록페이지
function photoWrite(){
	var form = document.springForm;
	form.action = "/photo/write.do";
	form.submit();
}

// 사진게시판 등록처리
function photoWriteAct(){
	var form = document.springForm;
	
	if(form.title.value == ''){
		alert("タイトルを入力咲いてください。");
		form.title.focus();
		return;
	}else {
		if(confirm("登録しますか？")){
			form.action = "/photo/writeAct.do";
			form.submit();			
		}
	}	
}

// 사진게시판 상세페이지
function photoView(seqNo){
	var form = document.springForm;
	form.seqNo.value = seqNo;
	form.action = "/photo/view.do";
	form.submit();
}

// 사진게시판 수정페이지
function photoModify(){
	var form = document.springForm;
	form.action = "/photo/modify.do";
	form.submit();	
}

//사진게시판 수정처리
function photoModifyAct(){
	var form = document.springForm;
	//alert(form.seqNo.value);
	if(confirm("修正しますか？")){
		form.action = "/photo/modifyAct.do";
		form.submit();	
	}
}
//사진게시판 삭제처리
function photoDeleteAct(){
	var form = document.springForm;
	//alert(form.seqNo.value);
	if(confirm("削除しますか？")){
		form.action = "/photo/deleteAct.do";
		form.submit();	
	}
}

