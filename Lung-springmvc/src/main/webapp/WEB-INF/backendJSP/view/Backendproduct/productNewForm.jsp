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
<title>Lung-Hi Peace商品管理系統</title>
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
                  <h4 class="card-title" >New Product</h4>
                  <form:form id="form" cssClass="forms-sample" action="saveProduct" method="post" modelAttribute="product">
                    
                    <div class="form-group">
                    <label for="pd_items"> <span>品項</span> 
					<form:select path="pd_items" cssClass="js-example-basic-single w-100 select2-hidden-accessible" id="pd_items">
						<option value="食品">食品</option>
						<option value="衣飾">衣飾</option>
						<option value="玩具">玩具</option>
					</form:select>
					</label>
                    </div>
                    <div class="form-group">
                      <label for="pd_product_name">商品名稱</label>
                      <form:input path="pd_product_name" cssClass="form-control" id="pd_product_name"/>
                      </div>
                      
<!--                       <div> -->
<!--                       <label for=pd_image>商品圖片</label> -->
<%--                       <form:input type="file" path="pd_image" cssClass="form-control" id="pd_image" name="pd_image"/> --%>
<%-- 					<img id="blah" src="images/'${product.pd_image}'/>" style="width:200px" alt="choose one">				 --%>
<!--                       </div> -->
                      
                  
                    <div class="form-group">
                      <label for="pd_content">商品內容</label>
                      <form:input path="pd_content" cssClass="form-control" id="pd_content"/>
                    </div>
                    <div class="form-group">
                      <label for="pd_specification">商品規格</label>
                      <form:input path="pd_specification" cssClass="form-control" id="pd_specification"/>
                    </div>
                    <div class="form-group">
                      <label for="pd_quantity">商品數量</label>
                      <form:input path="pd_quantity" cssClass="form-control" id="pd_quantity" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')"/>
                    </div>
                    <div class="form-group">
                      <label for="pd_amount">商品價格</label>
                      <form:input path="pd_amount" cssClass="form-control" id="pd_amount" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')"/>
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
		window.location.href = "./productlist"
	}
	function add(){
		var form = document.getElementById("form").value;
		var pd_items = document.getElementById("pd_items").value;
		var pd_product_name = document.getElementById("pd_product_name").value;
// 		var pd_image = document.getElementById("pd_image").value;
		var pd_content = document.getElementById("pd_content").value;
		var pd_specification = document.getElementById("pd_specification").value;
		var pd_quantity = document.getElementById("pd_quantity").value;
		var pd_amount = document.getElementById("pd_amount").value;
		if (pd_items == null || pd_items == ''){
			Swal.fire({
				  icon: 'error',
				  title: '請輸入品項！！',
				})
			return;
		}
		if (pd_product_name == null || pd_product_name == ''){
			Swal.fire({
				  icon: 'error',
				  title: '請輸入商品名稱！！',
				})
			return;
		}
// 		if (pd_image == null || pd_image == ''){
// 			Swal.fire({
// 				  icon: 'error',
// 				  title: '請上傳照片！！',
// 				})
// 			return;
// 		}
		if (pd_content == null || pd_content == ''){
			Swal.fire({
				  icon: 'error',
				  title: '請輸入商品內容！！',
				})
			return;
		}
		if (pd_specification == null || pd_specification == ''){
			Swal.fire({
				  icon: 'error',
				  title: '請輸入商品規格！！',
				})
			return;
		}
		if (pd_quantity == null || pd_quantity == ''){
			Swal.fire({
				  icon: 'error',
				  title: '請輸入商品數量！！',
				})
			return;
		}
		if (pd_amount == null || pd_amount == ''){
			Swal.fire({
				  icon: 'error',
				  title: '請輸入商品金額！！',
				})
			return;
		}
		
			Swal.fire({
				  title: 'Are you sure?',
				  text: "您將新增一筆商品資料",
				  icon: 'warning',
				  showCancelButton: true,
				  confirmButtonColor: '#3085d6',
				  cancelButtonColor: '#d33',
				  confirmButtonText: '新增!'
				}).then((result) => {
				  if (result.isConfirmed) {
				    Swal.fire(
				      '新增成功!',
				      '您已成功新增一筆訂單',
				      'success'
				    )
				    var timeoutID = window.setTimeout(( () =>  document.getElementById("form").submit() ), 1000);
				  }
				})
		
	}
	</script>
	<script type="text/javascript">
	$("#form-btn").click(function(){
		let formData = new FormData($("#form")[0]);
		formData.append("file",$("#form")[0])
		$.ajax({
			type : 'POST',
			url : 'uploadImage',
			processData:false,
			contentType : false,
			data :formData,
			success:function(rs){
				console.log(rs)
			},
			error : function(e) {
				console.log(e)
			}
		});
	})</script>
</body>
</html>