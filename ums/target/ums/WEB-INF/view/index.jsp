<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
	<link rel="stylesheet" type="text/css" href="static/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="static/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="static/css/AdminLTE.min.css">
	<script type="application/javascript" src="static/js/jquery-3.5.1.min.js"></script>
	<script type="application/javascript" src="static/js/bootstrap.min.js"></script>
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
	</div>

</body>
</html>
