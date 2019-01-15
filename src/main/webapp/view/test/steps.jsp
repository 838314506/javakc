<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>测试添加页面</title>
<%@ include file="../../common/jsp/header.jsp"%>
<link href="<%=path%>static/css/plugins/steps/jquery.steps.css" rel="stylesheet">
<script type="text/javascript" src="<%=path%>static/js/plugins/steps/jquery.steps.js"></script>
<script type="text/javascript" src="<%=path%>static/js/plugins/validate/jquery.validate.min.js"></script>
</head>
<body>
	<div class="row">
		<div class="col-sm-12">
			<div class="ibox">
				<!-- 横向  -->
				<div class="ibox-content">
					<h2>添加员工向导</h2>
					<form id="form" action="" class="wizard-big">
						<h1>账户</h1>
						<fieldset>
							<h2>账户信息</h2>
							<div class="row">
								<div class="col-sm-8">
									<div class="form-group">
										<label>用户名 *</label> <input id="userName" name="userName"
											type="text" class="form-control required">
									</div>
									<div class="form-group">
										<label>密码 *</label> <input id="password" name="password"
											type="text" class="form-control required">
									</div>
									<div class="form-group">
										<label>确认密码 *</label> <input id="confirm" name="confirm"
											type="text" class="form-control required">
									</div>
								</div>
								<div class="col-sm-4">
									<div class="text-center">
										<div style="margin-top: 20px">
											<i class="fa fa-sign-in"
												style="font-size: 180px; color: #e5e5e5"></i>
										</div>
									</div>
								</div>
							</div>
						</fieldset>
						<h1>个人资料</h1>
						<fieldset>
							<h2>个人资料信息</h2>
							<div class="row">
								<div class="col-sm-6">
									<div class="form-group">
										<label>姓名 *</label> <input id="name" name="name" type="text"
											class="form-control required">
									</div>
									<div class="form-group">
										<label>电话 *</label> <input id="phone" name="phone" type="text"
											class="form-control required">
									</div>
								</div>
								<div class="col-sm-6">
									<div class="form-group">
										<label>Email *</label> <input id="email" name="email"
											type="text" class="form-control required email">
									</div>
									<div class="form-group">
										<label>地址 *</label> <input id="address" name="address"
											type="text" class="form-control">
									</div>
								</div>
							</div>
						</fieldset>
						<h1>警告</h1>
						<fieldset>
							<div class="text-center" style="margin-top: 120px">
								<h2>你是火星人 :-)</h2>
							</div>
						</fieldset>
						<h1>完成</h1>
						<fieldset>
							<h2>条款</h2>
							<input id="acceptTerms" name="acceptTerms" type="checkbox"
								class="required"> <label for="acceptTerms">我同意注册条款</label>
						</fieldset>
					</form>
				</div>
				
			</div>
		</div>
	</div>
	<script>
    $(document).ready(function () {
        $("#form").steps({
            bodyTag: "fieldset", onStepChanging: function (event, currentIndex, newIndex) {
                if (currentIndex > newIndex) {
                    return true
                }
                if (newIndex === 3 && Number($("#age").val()) < 18) {
                    return false
                }
                var form = $(this);
                if (currentIndex < newIndex) {
                    $(".body:eq(" + newIndex + ") label.error", form).remove();
                    $(".body:eq(" + newIndex + ") .error", form).removeClass("error")
                }
                form.validate().settings.ignore = ":disabled,:hidden";
                return form.valid()
            }, onStepChanged: function (event, currentIndex, priorIndex) {
                if (currentIndex === 2 && Number($("#age").val()) >= 18) {
                    $(this).steps("next")
                }
                if (currentIndex === 2 && priorIndex === 3) {
                    $(this).steps("previous")
                }
            }, onFinishing: function (event, currentIndex) {
                var form = $(this);
                form.validate().settings.ignore = ":disabled";
                return form.valid()
            }, onFinished: function (event, currentIndex) {
                var form = $(this);
                form.submit()
            }
        }).validate({
            errorPlacement: function (error, element) {
                element.before(error)
            }, rules: {confirm: {equalTo: "#password"}}
        });
        
        /*
		 * Translated default messages for the jQuery validation
		 * plugin. Locale: ZH (Chinese, 中文 (Zhōngwén), 汉语, 漢語)
		 */
		$.extend($.validator.messages, {
			required : "这是必填字段",
			remote : "请修正此字段",
			email : "请输入有效的电子邮件地址",
			url : "请输入有效的网址",
			date : "请输入有效的日期",
			dateISO : "请输入有效的日期 (YYYY-MM-DD)",
			number : "请输入有效的数字",
			digits : "只能输入数字",
			creditcard : "请输入有效的信用卡号码",
			equalTo : "你的输入不相同",
			extension : "请输入有效的后缀",
			maxlength : $.validator.format("最多可以输入 {0} 个字符"),
			minlength : $.validator.format("最少要输入 {0} 个字符"),
			rangelength : $.validator.format("请输入长度在 {0} 到 {1} 之间的字符串"),
			range : $.validator.format("请输入范围在 {0} 到 {1} 之间的数值"),
			max : $.validator.format("请输入不大于 {0} 的数值"),
			min : $.validator.format("请输入不小于 {0} 的数值")
		});
        
    });
</script>
</body>
</html>