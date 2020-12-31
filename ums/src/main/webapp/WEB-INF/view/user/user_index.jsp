<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
	<link rel="stylesheet" type="text/css" href="../static/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="../static/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="../static/css/AdminLTE.min.css">
	<script type="application/javascript" src="../static/js/jquery-3.5.1.min.js"></script>
	<script type="application/javascript" src="../static/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-md-12">广告位招租：10086</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<nav class="navbar navbar-default" role="navigation">
				<div class="container-fluid">
					<div>
						<!--向左对齐-->
						<ul class="nav navbar-nav navbar-left">
							<li>
								<a href="user/index">
									<i class="fa fa-users"></i>&nbsp;
									用户信息
								</a>
							</li>
							<!-- 根据角色信息判断是否是超级管理员或者是管理员 -->
							<c:if test="${(sessionScope.user.role.id == 1) || (sessionScope.user.role.id == 2)}">
								<li>
									<a href="role/index">
										<i class="fa fa-key"></i>&nbsp;
										角色信息
									</a>
								</li>
							</c:if>

						</ul>
						<!--向右对齐-->
						<ul class="nav navbar-nav navbar-right">
							<li>
								<a href="user/${sessionScope.user.id}">
									<i class="fa fa-user"></i>&nbsp;
									${sessionScope.user.name}
								</a>
							</li>
							<li>
								<a href="user/logout">
									<i class="fa fa-sign-out"></i>&nbsp;
									退出
								</a>
							</li>
						</ul>
					</div>
				</div>
			</nav>
		</div>

	</div>
	<div class="row">
		<div class="col-md-12">
			<h1>
				<i class="fa fa-users"></i>&nbsp;
				用户信息
			</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<a href="#" class="btn btn-success">
				<i class="fa fa-plus"></i>&nbsp;
				新增用户信息
			</a>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>序号</th>
						<th>姓名</th>
						<th>手机号码</th>
						<th>身份</th>
						<th>状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<c:forEach var="user" items="${pageVO.list}" varStatus="s">
					<tr>
						<td>${(pageVO.pageNum - 1) * pageVO.pageSize + s.index + 1}</td>
						<td>${user.name}</td>
						<td>${user.cellphone}</td>
						<td>${user.role.name}</td>
						<td>
							<c:choose>
								<c:when test="${user.status eq 1}">启用</c:when>
								<c:otherwise>禁用</c:otherwise>
							</c:choose>
						</td>
						<td>
							<c:if test="${(sessionScope.user.role.id == 1) || (sessionScope.user.role.id == 2)}">
							<c:if test="${sessionScope.user.role.id == 1}">
								<a href="#" class="btn btn-warning btn-xs">
									<i class="fa fa-wrench"></i>&nbsp;
									修改
								</a>
							</c:if>
							<c:if test="${(sessionScope.user.role.id == 2) && (user.role.id != 1) && (user.role.id != 2)}">
							<a href="#" class="btn btn-warning btn-xs">
								<i class="fa fa-wrench"></i>&nbsp;
								修改
							</a>
							</c:if>
							<c:if test="${(sessionScope.user.role.id == 1) && (user.role.id != 1)}">
								<c:choose>
									<c:when test="${role.status eq 1}">
										<a href="#" class="btn btn-danger btn-sm">
											<i class="fa fa-toggle-off"></i>&nbsp;
											禁用
										</a>
									</c:when>
									<c:otherwise>
										<a href="#" class="btn btn-success btn-sm">
											<i class="fa fa-toggle-on"></i>&nbsp;
											启用
										</a>
									</c:otherwise>
								</c:choose>
							</c:if>

							<c:if test="${(sessionScope.user.role.id == 2) && (user.role.id != 1) && (user.role.id != 2)}">
								<c:choose>
									<c:when test="${role.status eq 1}">
										<a href="#" class="btn btn-danger btn-sm">
											<i class="fa fa-toggle-off"></i>&nbsp;
											禁用
										</a>
									</c:when>
									<c:otherwise>
										<a href="#" class="btn btn-success btn-sm">
											<i class="fa fa-toggle-on"></i>&nbsp;
											启用
										</a>
									</c:otherwise>
								</c:choose>
							</c:if>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
</body>
</html>
