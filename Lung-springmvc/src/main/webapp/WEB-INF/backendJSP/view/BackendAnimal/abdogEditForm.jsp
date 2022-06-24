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
<title>Lung-Hi Peace認養管理系統</title>
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
                  <h4 class="card-title" >Edit Animal</h4>
                  
                  <form:form id="form" cssClass="forms-sample" action="saveAbDog" method="post" modelAttribute="abdogbean">
                    <form:hidden path="Id"></form:hidden>
                    
                    
                    
                    <div class="form-group">
                      <label for="abid">編號</label>
                      <form:input path="abid" cssClass="form-control" id="abid"/>
                    </div>
                    
                    <div class="form-group">
                      <label for="abname">姓名</label>
                      <form:input path="abname" cssClass="form-control" id="abname"/>
                    </div>
                    
                     <div class="form-group">
                      <label for="abphone">電話</label>
                      <form:input path="abphone" cssClass="form-control" id="abphone"/>
                    </div>
                    
                     <div class="form-group">
                      <label for="abemail">信箱</label>
                      <form:input path="abemail" cssClass="form-control" id="abemail"/>
                    </div>
                 
                    <div class="form-group">
                      <label for="abdogname">寵物名</label>
                      <form:input path="abdogname" cssClass="form-control" id="abdogname"/>
                    </div>
                 
                    <div class="form-group">
                      <label for="abimage">照片</label>
                      <form:input path="abimage" cssClass="form-control" id="abimage"/>
                    </div>
                    
                     <div class="form-group">
                      <label for="abaddress">住址</label>
                      <form:input path="abaddress" cssClass="form-control" id="abaddress"/>
                    </div>   
                    
                    
                    <div class="form-group">
                    <label for="abtype"> <span>動物類別</span> 
					<form:select path="abtype" cssClass="js-example-basic-single w-100 select2-hidden-accessible" id="abtype">
						<option value="貓">貓</option>
						<option value="狗">狗</option>
						<option value="鳥">鳥</option>
					</form:select>
					</label>
                    </div>
                    
                    
                    <div class="form-group">
                      <label for="abage">寵物年紀</label>
                      <form:input path="abage" cssClass="form-control" id="abage"/>
                    </div>
                    
                    
                    <div class="form-group">
                      <label for="abdate">時間</label>
                      <form:input path="abdate" cssClass="form-control" id="abdate"/>
                    </div>
                    
                    
                    <div class="form-group">
                      <label for="abremark">備註</label>
                      <form:input path="abremark" cssClass="form-control" id="abremark" />
                    </div>
                    
                    
                    
                    
                    <button type="button" class="btn btn-warning me-2" onclick="add();"><i class="bi bi-send"></i>送出</button>
                    <button type="button" class="btn btn-light" onclick="cancel();">Cancel</button>
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
	<script type="text/javascript">
	function cancel(){
		window.location.href = "./animallist"
	}

	function add(){
		var form = document.getElementById("form").value;
		var abid = document.getElementById("abid").value;
		var abname = document.getElementById("abname").value;
		var abphone = document.getElementById("abphone").value;
		var abemail = document.getElementById("abemail").value;
		
		var abdogname = document.getElementById("abdogname").value;
		var abimage = document.getElementById("abimage").value;
		var abaddress = document.getElementById("abaddress").value;
		var abtype = document.getElementById("abtype").value;
		var abage = document.getElementById("abage").value;
		var abdate = document.getElementById("abdate").value;
		var abremark = document.getElementById("abremark").value;

		
		
		if (abname == null || abname == ''){
			Swal.fire({
				  icon: 'error',
				  title: '請輸入聯絡人性名！！',
				})
			return;
		}
		if (abphone == null || abphone == ''){
			Swal.fire({
				  icon: 'error',
				  title: '請輸入電話！！',
				})
			return;
		}
		if (abemail == null || abemail == ''){
			Swal.fire({
				  icon: 'error',
				  title: '請輸入信箱！！',
				})
			return;
		}
		if (abdogname == null || abdogname == ''){
			Swal.fire({
				  icon: 'error',
				  title: '請輸入動物性名！！',
				})
			return;
		}
		
		if (abaddress == null || abaddress == ''){
			Swal.fire({
				  icon: 'error',
				  title: '請輸入來源！！',
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