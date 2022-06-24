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
<title>Lung-Hi Peace公告管理系統</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css" rel="stylesheet">
<!-- announcementFormCSS -->
<link href="${pageContext.request.contextPath}/URLToReachResourcesFolder/css/announcementForm.css" rel="stylesheet"/>
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
                  <h4 class="card-title" >Edit Announce</h4>
                  <form:form id="form" cssClass="forms-sample" action="saveAnnounce" method="post" modelAttribute="announce">
                    <form:hidden path="anNo"></form:hidden>
                    <div class="form-group">
                      <label for="anTitle">公告標題</label>
                      <form:input path="anTitle" cssClass="form-control" id="anTitle"/>
                    </div>
                    <div class="form-group">
                    <label for="anContent"> 公告內容:</label> 
					<form:textarea path="anContent" cssClass="form-textarea" id="anContent" />
                    </div>
                    <div class="form-group">
                      <label for="anType">公告類型</label>
                      <form:radiobutton  path="anType"  id="anType" value="新聞"/>新聞
                      <form:radiobutton  path="anType"  id="anType" value="教育"/>教育
                    </div>
                    <div class="form-group">
                      <label for="anEditor">編輯者</label>
                      <form:select path="anEditor" cssClass="js-example-basic-single w-100 select2-hidden-accessible" id="anEditor">
                      	<option value="亭妤">亭妤</option>
						<option value="鴻銘">鴻銘</option>
						<option value="毓蓉">毓蓉</option>
						<option value="容緯">容緯</option>
						<option value="奕成">奕成</option>
						<option value="鄭漢">鄭漢</option>
                      </form:select>
                    </div>
                    <div class="form-group">
                      <label for="anDate">公告日期</label>
                      <form:input type="Date" path="anDate" cssClass="form-control" id="anDate"/>
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
		window.location.href = "./announcelist"
	}
	function add(){
		var form = document.getElementById("form").value;
		var anTitle = document.getElementById("anTitle").value;
		var anContent = document.getElementById("anContent").value;
		var anType = document.getElementById("anType").value;
		var anEditor = document.getElementById("anEditor").value;
		var anDate = document.getElementById("anDate").value;
		if (anTitle == null || anTitle == ''){
			Swal.fire({
				  icon: 'error',
				  title: '請輸入公告標題！！',
				})
			return;
		}
		if (anContent == null || anContent == ''){
			Swal.fire({
				  icon: 'error',
				  title: '請輸入公告內容！！',
				})
			return;
		}
		if (anType == null || anType == ''){
			Swal.fire({
				  icon: 'error',
				  title: '請選擇公告類型！！',
				})
			return;
		}
		if (anEditor == null || anEditor == ''){
			Swal.fire({
				  icon: 'error',
				  title: '請選擇編輯者！！',
				})
			return;
		}
		if (anDate == null || anDate == ''){
			Swal.fire({
				  icon: 'error',
				  title: '請選擇日期！！',
				})
			return;	
		}
		
			Swal.fire({
				  title: 'Are you sure?',
				  text: "您將修改一筆公告",
				  icon: 'warning',
				  showCancelButton: true,
				  confirmButtonColor: '#3085d6',
				  cancelButtonColor: '#d33',
				  confirmButtonText: '修改!'
				}).then((result) => {
				  if (result.isConfirmed) {
				    Swal.fire(
				      '修改成功!',
				      '您已成功修改一筆公告',
				      'success'
				    )
				    var timeoutID = window.setTimeout(( () =>  document.getElementById("form").submit() ), 1000);
				  }
				})
		
	}
	</script>
</body>
</html>