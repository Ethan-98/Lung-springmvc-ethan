<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="vendors/mdi/css/materialdesignicons.min.css">

	<nav class="sidebar sidebar-offcanvas" id="sidebar">
        <ul class="nav">
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/index.jsp">
              <i class="mdi mdi-grid-large menu-icon"></i>
              <span class="menu-title">後台首頁</span>
            </a>
          </li>
          <li class="nav-item nav-category">管理項目</li>
          <!-- 會員sidebar -->
          <li class="nav-item">
            <a class="nav-link" data-bs-toggle="collapse" href="#member" aria-expanded="false" aria-controls="ui-basic">
              <i class="menu-icon mdi mdi-account"></i>
              <span class="menu-title">會員</span>
              <i class="menu-arrow"></i> 
            </a>
            <div class="collapse" id="member">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/Backendmember/memberlist">會員管理</a></li>
              </ul>
            </div>
          </li>
          <!-- 商品sidebar -->
          <li class="nav-item">
            <a class="nav-link" data-bs-toggle="collapse" href="#product" aria-expanded="false" aria-controls="ui-basic">
              <i class="menu-icon mdi mdi-shopping"></i>
              <span class="menu-title">商品</span>
              <i class="menu-arrow"></i> 
            </a>
            <div class="collapse" id="product">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/Backendproduct/productlist">商品管理</a></li>
              </ul>
            </div>
          </li>
          <!-- 訂單sidebar -->
          <li class="nav-item">
            <a class="nav-link" data-bs-toggle="collapse" href="#order" aria-expanded="false" aria-controls="ui-basic">
              <i class="menu-icon mdi mdi-cart"></i>
              <span class="menu-title">訂單</span>
              <i class="menu-arrow"></i> 
            </a>
            <div class="collapse" id="order">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/Backendorder/orderlist">訂單管理</a></li>
              </ul>
            </div>
          </li>
          <!-- 公告sidebar -->
          <li class="nav-item">
            <a class="nav-link" data-bs-toggle="collapse" href="#announce" aria-expanded="false" aria-controls="ui-basic">
              <i class="menu-icon mdi mdi-message"></i>
              <span class="menu-title">公告</span>
              <i class="menu-arrow"></i> 
            </a>
            <div class="collapse" id="announce">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/Backendannounce/announcelist">公告管理</a></li>
              </ul>
            </div>
          </li>
          <!-- 志工sidebar -->
          <li class="nav-item">
            <a class="nav-link" data-bs-toggle="collapse" href="#activity" aria-expanded="false" aria-controls="ui-basic">
              <i class="menu-icon mdi mdi-face-profile"></i>
              <span class="menu-title">志工</span>
              <i class="menu-arrow"></i> 
            </a>
            <div class="collapse" id="activity">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/Backendactivity/activitylist">志工管理</a></li>
              </ul>
            </div>
          </li>
          <!-- 認養sidbar -->
          <li class="nav-item">
            <a class="nav-link" data-bs-toggle="collapse" href="#abdog" aria-expanded="false" aria-controls="ui-basic">
              <i class="menu-icon mdi mdi-paw"></i>
              <span class="menu-title">認養/棄養</span>
              <i class="menu-arrow"></i> 
            </a>
            <div class="collapse" id="abdog">
              <ul class="nav flex-column sub-menu">              
                <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/BackendAnimal/animallist">棄養管理</a></li>
              </ul>
            </div>
          </li>
         </ul>
	</nav>

