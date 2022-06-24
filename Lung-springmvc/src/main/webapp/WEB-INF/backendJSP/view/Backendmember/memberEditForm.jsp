<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<%@include file="/resources/includes/head.jsp"%>
<meta charset="UTF-8">
<title>Lung-Hi Peace會員管理系統</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css" rel="stylesheet">
</head>
<body>
	<!-- _navbar -->
	<%@include file="/resources/includes/navbar.jsp"%>
	<!-- partial -->
	<div class="container-fluid page-body-wrapper">
		<!-- partial:partials/_settings-panel.jsp -->
		<div id="right-sidebar" class="settings-panel">
			<i class="settings-close ti-close"></i>
			<ul class="nav nav-tabs border-top" id="setting-panel" role="tablist">
				<li class="nav-item"><a class="nav-link active" id="todo-tab"
					data-bs-toggle="tab" href="#todo-section" role="tab"
					aria-controls="todo-section" aria-expanded="true">TO DO LIST</a></li>
				<li class="nav-item"><a class="nav-link" id="chats-tab"
					data-bs-toggle="tab" href="#chats-section" role="tab"
					aria-controls="chats-section">CHATS</a></li>
			</ul>
		</div>
		<!-- partial -->
		<!-- partial:partials/_sidebar.jsp -->
		<%@include file="/resources/includes/sidebar.jsp"%>
		<!-- partial -->
		<!-- 顯示區域從這開始 -->
		<div class="main-panel">        
        <div class="content-wrapper">
          <div class="row">
            <div class="col-md-6 grid-margin stretch-card container">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title" >修改會員</h4>
                  <form:form id="form" cssClass="forms-sample" action="saveMember" method="post" modelAttribute="member" enctype='multipart/form-data' >                   
                    <div class="form-group">
						<img id="blah" src="<c:url value='/Backendmember/picture/${member.mi_no}'/>" style="display:block;width: 180px; height: 180px; margin:20px auto;border:2px solid #c0c3c4;border-radius:50%;background-color:#ebeff2;" />
						<label for="productImage">會員大頭貼</label>
                    	<form:input path="productImage" type='file' cssClass="form-control" id="mi_headshot" onchange="previewHeadshot(event)" accept="image/*"/>
                     </div>
                     
                    <form:hidden path="mi_no"></form:hidden>
                    <div class="form-group">
                      <label for="mi_no">會員編號</label>
                      <input type="text" class="form-control" value="<c:out value='${member.mi_no}'/>" disabled/>
                    </div>
                    
                     <div class="form-group">
                      <label for="mi_account">會員帳號</label>
                      <form:input path="mi_account" type="text" cssClass="form-control" id="mi_account" autocomplete="off"/>
                    </div>
                    <div class="form-group">
                      <label for="mi_password">會員密碼</label>
                      <form:input path="mi_password" type="password" cssClass="form-control" id="mi_password" autocomplete="off"/>
                    </div>
                   <div class="form-group">
                      <label for="mi_name">會員姓名</label>
                      <form:input path="mi_name" type="text" cssClass="form-control" id="mi_name" autocomplete="off" />
                    </div>
                   <div class="form-group">
                      <label for="mi_id">會員身分證</label>
                      <form:input path="mi_id" type="text" cssClass="form-control" id="mi_id" maxlength="10" autocomplete="off"/>
                    </div>
                    <div class="form-group">
                      <label for="mi_birth">會員生日</label>
                      <form:input path="mi_birth" type="Date" cssClass="form-control" id="mi_birth" max="3000-12-31" autocomplete="off" maxlength="10"/>
                    </div>
                     <div class="form-group">
                      <label for="mi_phone">會員電話</label>
                      <form:input path="mi_phone" type="text" cssClass="form-control" id="mi_phone" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')" maxlength="10" autocomplete="off"/>
                    </div>
                    <div class="form-group">
                      <label for="mi_email">會員Email</label>
                      <form:input path="mi_email" type="text" cssClass="form-control" id="mi_email" autocomplete="off"/>
                    </div>
                    <div class="form-group">
                      <label for="mi_address">會員地址</label>
                      <form:input path="mi_address" type="text" cssClass="form-control" id="mi_address" onblur="print()" autocomplete="off"/>
                    </div>
                    
                    <button type="button" class="btn btn-inverse-warning btn-fw btn-icon-text" onclick="cancel()"><i class="fa-solid fa-circle-arrow-left"></i> 返回</button>
                    <button type="reset" class="btn btn-inverse-warning btn-fw btn-icon-text"><i class="fa-solid fa-eraser"></i>清除輸入</button>
                    <button type="button" class="btn btn-inverse-warning btn-fw btn-icon-text" onclick="add();"><i class="fa-solid fa-check"></i>送出</button>
                  </form:form>
                		</div>
              		</div>
            	</div>
            </div>
		</div>
	</div>
	</div>
	<!-- partial:partials/_footer.jsp -->
	<%@include file="/resources/includes/footer.jsp"%>
	<!-- 主畫面結束 -->
	<!-- container-scroller -->
	
	<!-- Js匯入 -->
	<%@include file="/resources/includes/JavaScript.jsp"%>

	
	<script src="https://kit.fontawesome.com/ae6733f6ec.js" crossorigin="anonymous"></script>
	<script type="text/javascript">
	
	// 顯示選取的照片
	function previewHeadshot(event) {
		/*
		files = ['src'] 
		法一:
			const file = files[0] -> file = 'src'
		法二:
			const [file] = files -> file = 'src'
		*/
	  const [file] = document.getElementById("mi_headshot").files
	  if (file) {
		  document.getElementById("blah").src = URL.createObjectURL(file)
	  }
	}
	
	
	function cancel(){
		window.location.href = "./memberlist"
	}

	function add(){
		var form = document.getElementById("form").value;
		var mi_account = document.getElementById("mi_account").value;
		var mi_password = document.getElementById("mi_password").value;
		var mi_name = document.getElementById("mi_name").value;
		var mi_id = document.getElementById("mi_id").value;
		var mi_birth = document.getElementById("mi_birth").value;
		var mi_phone = document.getElementById("mi_phone").value;
		var mi_email = document.getElementById("mi_email").value;
		var mi_address = document.getElementById("mi_address").value;
		if (mi_account == null || mi_account == ''){
			Swal.fire({
				  icon: 'error',
				  title: '請輸入帳號！！',
				})
			return;
		}
		if (mi_password == null || mi_password == ''){
			Swal.fire({
				  icon: 'error',
				  title: '請輸入密碼！！',
				})
			return;
		}
		if (mi_name == null || mi_name == ''){
			Swal.fire({
				  icon: 'error',
				  title: '請輸入姓名！！',
				})
			return;
		}
		if (mi_id == null || mi_id == ''){
			Swal.fire({
				  icon: 'error',
				  title: '請輸入身分證字號！！',
				})
			return;
		}
		if (mi_birth == null || mi_birth == ''){
			Swal.fire({
				  icon: 'error',
				  title: '請輸入生日！！',
				})
			return;
		}
		if (mi_phone == null || mi_phone == ''){
			Swal.fire({
				  icon: 'error',
				  title: '請輸入電話！！',
				})
			return;
		}
		if (mi_email == null || mi_email == ''){
			Swal.fire({
				  icon: 'error',
				  title: '請輸入Email！！',
				})
			return;
		}
		if (mi_address == null || mi_address == ''){
			Swal.fire({
				  icon: 'error',
				  title: '請輸入地址！！',
				})
			return;
		}
		
			Swal.fire({
				  title: 'Are you sure?',
				  text: "您將修改一筆訂單",
				  icon: 'warning',
				  showCancelButton: true,
				  confirmButtonColor: '#3085d6',
				  cancelButtonColor: '#d33',
				  confirmButtonText: '修改!'
				}).then((result) => {
				  if (result.isConfirmed) {
				    Swal.fire(
				      '新增成功!',
				      '您已成功修改一筆訂單',
				      'success'
				    )
				    var timeoutID = window.setTimeout(( () =>  document.getElementById("form").submit() ), 1000);
				  }
				})
		
	}
	</script>
</body>
</html>