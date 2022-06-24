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
                  <h4 class="card-title" >Edit Order</h4>
                  <form:form id="form" cssClass="forms-sample" action="saveOrder" method="post" modelAttribute="order">
                    <form:hidden path="od_id"></form:hidden>
                    <div class="form-group">
                      <label for="od_name">商品名稱</label>
                      <form:input path="od_name" cssClass="form-control" id="od_name"/>
                    </div>
                    <div class="form-group">
                    <label for="od_catalogue"> <span>商品目錄</span> 
					<form:select path="od_catalogue" cssClass="js-example-basic-single w-100 select2-hidden-accessible" id="od_catalogue">
						<option value="貓">貓</option>
						<option value="狗">狗</option>
						<option value="鳥">鳥</option>
					</form:select>
					</label>
                    </div>
                    <div class="form-group">
                      <label for="od_content">訂單內容</label>
                      <form:input path="od_content" cssClass="form-control" id="od_content"/>
                    </div>
                    <div class="form-group">
                      <label for="od_amount">訂單規格</label>
                      <form:input path="od_amount" cssClass="form-control" id="od_amount"/>
                    </div>
                    <div class="form-group">
                      <label for="od_number">訂單數量</label>
                      <form:input path="od_number" cssClass="form-control" id="od_number" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')"/>
                    </div>
                    <div class="form-group">
                      <label for="od_money">訂單金額</label>
                      <form:input path="od_money" cssClass="form-control" id="od_money" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')"/>
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
		window.location.href = "./orderlist"
	}

	function add(){
		var form = document.getElementById("form").value;
		var od_name = document.getElementById("od_name").value;
		var od_catalogue = document.getElementById("od_catalogue").value;
		var od_content = document.getElementById("od_content").value;
		var od_amount = document.getElementById("od_amount").value;
		var od_number = document.getElementById("od_number").value;
		var od_money = document.getElementById("od_money").value;
		if (od_name == null || od_name == ''){
			Swal.fire({
				  icon: 'error',
				  title: '請輸入商品名稱！！',
				})
			return;
		}
		if (od_content == null || od_content == ''){
			Swal.fire({
				  icon: 'error',
				  title: '請輸入訂單內容！！',
				})
			return;
		}
		if (od_amount == null || od_amount == ''){
			Swal.fire({
				  icon: 'error',
				  title: '請輸入訂單規格！！',
				})
			return;
		}
		if (od_number == null || od_number == ''){
			Swal.fire({
				  icon: 'error',
				  title: '請輸入訂單數量！！',
				})
			return;
		}
		if (od_money == null || od_money == ''){
			Swal.fire({
				  icon: 'error',
				  title: '請輸入訂單金額！！',
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