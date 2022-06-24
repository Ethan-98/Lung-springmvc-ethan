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
<title>Lung-Hi Peace訂單管理系統</title>
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
                  <h4 class="card-title" >Edit Activity</h4>
                  <form:form id="form" cssClass="forms-sample" action="saveActivity" method="post" modelAttribute="activity" enctype="multipart/form-data">
                    <form:hidden path="ac_id"></form:hidden>
                    <div class="form-group">
                      <label for="ac_name">活動名稱</label>
                      <form:input path="ac_name" cssClass="form-control" id="ac_name"/>
                    </div>
                     <div class="form-group">
                     <label for="productImage"> <span>活動照片</span> 
 					<form:input type="file" path="productImage" cssClass="form-control" id="ac_image" onchange="previewImage(event)" accept="image/*"/> 
					<img id="blah" src="<c:url value='/Backendactivity/picture/${activity.ac_id}'/>" style="width:200px" alt="choose one">
					</label>
                    </div>
                    <div class="form-group">
                      <label for="ac_date">活動日期</label>
                      <form:input type="date" path="ac_date" cssClass="form-control" id="ac_date"/>
                    </div>
                    <div class="form-group">
                      <label for="ac_participant">參加對象</label>
                      <form:input path="ac_participant" cssClass="form-control" id="ac_participant"/>
                    </div>
                    <div class="form-group">
                      <label for="ac_venue">活動地點</label>
                      <form:input path="ac_venue" cssClass="form-control" id="ac_venue"/>
                    </div>
                    <div class="form-group">
                      <label for="ac_quota">活動名額</label>
                      <form:input path="ac_quota" cssClass="form-control" id="ac_quota" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')"/>
                    </div>
                    <div class="form-group">
                      <label for="ac_waitlist_quota">候補名額</label>
                      <form:input path="ac_waitlist_quota" cssClass="form-control" id="ac_waitlist_quota" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')"/>
                    </div>
                    <div class="form-group">
                      <label for="ac_fee">報名費用</label>
                      <form:input path="ac_fee" cssClass="form-control" id="ac_fee" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')"/>
                    </div>
                    <div class="form-group">
                      <label for="ac_organizer">主辦單位</label>
                      <form:input path="ac_organizer" cssClass="form-control" id="ac_organizer"/>
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
		window.location.href = "./activitylist"
	}
	
	function previewImage(event) {
		const[file] = document.getElementById("ac_image").files
	    if (files) {
	        document.getElementById("blah").src = URL.createObjectURL(file)
	    }
	}
	
	function add(){
		var form = document.getElementById("form").value;
		var ac_name = document.getElementById("ac_name").value;
// 		var ac_image = document.getElementById("ac_image").value;
		var ac_date = document.getElementById("ac_date").value;
		var ac_participant = document.getElementById("ac_participant").value;
		var ac_venue = document.getElementById("ac_venue").value;
		var ac_quota = document.getElementById("ac_quota").value;
		var ac_waitlist_quota = document.getElementById("ac_waitlist_quota").value;
		var ac_fee = document.getElementById("ac_fee").value;
		var ac_organizer = document.getElementById("ac_organizer").value;
		if (ac_name == null || ac_name == ''){
			Swal.fire({
				  icon: 'error',
				  title: '請輸入活動名稱！！',
				})
			return;
		}
// 		if (ac_image == null || ac_image == ''){
// 			Swal.fire({
// 				  icon: 'error',
// 				  title: '請輸入活動照片！！',
// 				})
// 			return;
// 		}
		if (ac_date == null || ac_date == ''){
			Swal.fire({
				  icon: 'error',
				  title: '請輸入活動日期！！',
				})
			return;
		}
		if (ac_participant == null || ac_participant == ''){
			Swal.fire({
				  icon: 'error',
				  title: '請輸入參加對象！！',
				})
			return;
		}
		if (ac_venue == null || ac_venue == ''){
			Swal.fire({
				  icon: 'error',
				  title: '請輸入活動地點！！',
				})
			return;
		}
		if (ac_quota == null || ac_quota == ''){
			Swal.fire({
				  icon: 'error',
				  title: '請輸入活動名額！！',
				})
			return;
		}
		if (ac_waitlist_quota == null || ac_waitlist_quota == ''){
			Swal.fire({
				  icon: 'error',
				  title: '請輸入候補名額！！',
				})
			return;
		}
		if (ac_fee == null || ac_fee == ''){
			Swal.fire({
				  icon: 'error',
				  title: '請輸入報名費用！！',
				})
			return;
		}
		if (ac_organizer == null || ac_organizer == ''){
			Swal.fire({
				  icon: 'error',
				  title: '請輸入報名費用！！',
				})
			return;
		}
		
			Swal.fire({
				  title: 'Are you sure?',
				  text: "您將新增一筆活動",
				  icon: 'warning',
				  showCancelButton: true,
				  confirmButtonColor: '#3085d6',
				  cancelButtonColor: '#d33',
				  confirmButtonText: '新增!'
				}).then((result) => {
				  if (result.isConfirmed) {
				    Swal.fire(
				      '新增成功!',
				      '您已成功新增一筆活動',
				      'success'
				    )
				    var timeoutID = window.setTimeout(( () =>  document.getElementById("form").submit() ), 1000);
				  }
				})
		
	}
	</script>
</body>
</html>