
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<title>Title</title>
		<link rel="stylesheet" type="text/css" href="../../static/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="../../static/css/font-awesome.min.css">
		<script type="application/javascript" src="../../static/js/jquery-3.5.1.min.js"></script>
		<script type="application/javascript" src="../../static/js/bootstrap.min.js"></script>
		<script type="application/javascript" src="../../static/js/jquery.validate.min.js"></script>
		<script type="application/javascript">
			jQuery.validator.addMethod("isCellphone", function (value,element){
				var cellphoneRegex = /^1[0-9]{10}$/;
				return cellphoneRegex.test(value);
			});



			$(function () {
				$("#saveUser").validate({
					submitHandler:function (){
						//异步提交
						var formData = $("#saveUser").serialize();
						$.ajax({
							url: "../save",
							type: "post",
							data: formData,
							dataType: "json",
							success: function (data) {
								if (data) {
									alert("添加成功");
								}else {
									alert("添加失败");
								}
								//跳转到列表页面
								parent.openFrame("user/index");
							}
						})


					},
					rules: {
						name: {required: true},
						cellphone: {required: true,isCellphone: true,
							remote: {
								url: "../cellphone",
								type: "post",
								data: {
									cellphone: function () {
										return $("#cellphone").val();
									}
								},
								dataType: "json"
							}
							},
						password: {required: true,minlength: 6},
						confirmPassword: {required: true,equalTo: "#password"}


					},
					messages: {
						name: {required: "请填写用户姓名"},
						cellphone: {required: "请填写用户手机号码",isCellphone: "请填写正确的手机号码",remote: "该手机号码已被使用"},
						password: {required: "请填写用户登录密码",minlength: "请填写至少6位登录密码"},
						confirmPassword: {required: "请再次确认您的密码",equalTo: "两次密码输入不一致"}


					}
				});
			});
		</script>
	</head>

	<body>
		<form id="saveUser" role="form">
			<table>
				<tr>
					<td>用户姓名：</td>
					<td>
						<input type="text" name="name" placeholder="请填写用户姓名"/>
					</td>
					<td style="padding: 0px 5px;">
						<label class="error" for="name" style="color: red;"></label>
					</td>
				</tr>
				<tr>
					<td>手机号码：</td>
					<td>
						<input type="text" id="cellphone" name="cellphone" placeholder="请填写用户手机号码"/>
					</td>
					<td style="padding: 0px 5px;">
						<label class="error" for="cellphone" style="color: red;"></label>
					</td>
				</tr>
				<tr>
					<td>登录密码：</td>
					<td>
						<input type="password" id="password" name="password" placeholder="请填写用户登录密码"/>
					</td>
					<td style="padding: 0px 5px;">
						<label class="error" for="password" style="color: red;"></label>
					</td>
				</tr>
				<tr>
					<td>确认密码：</td>
					<td>
						<input type="password" name="confirmPassword" placeholder="请再次确认密码"/>
					</td>
					<td style="padding: 0px 5px;">
						<label class="error" for="confirmPassword" style="color: red;"></label>
					</td>
				</tr>
				<tr>
					<td>用户角色：</td>
					<td>
						<select name="roleId">
							<c:forEach items="${roleList}" var="role">
								<option value="${role.id}">${role.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="submit">保存用户</button>

					</td>
				</tr>


			</table>
		</form>

	</body>
</html>
