<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>公司修改页面</title>
		<%@ include file="../../common/jsp/header.jsp"%>
	</head>
	<body>
		<div class="wrapper wrapper-content animated fadeInRight">
			<div>
				<div class="col-sm-4"><input type="button" value="返回上一页" class="btn btn-success" onclick="javascript:history.back();"/></div>
			</div>
			<div class="ibox float-e-margins">
				<form action="${path }/company/update.do" method="post" class="form-horizontal" role="form">
					<input type="hidden" name="cid" value="${entity.cid }">
                    <fieldset>
						<legend>公司表单</legend>
                        <div class="form-group">
                           <label for="disabledSelect" class="col-sm-2 control-label">公司名称</label>
                           <div class="col-sm-10">
                              <input type="text" name="cname" value="${entity.cname }" class="form-control"/>
                           </div>
                        </div>
                        <div class="form-group">
                           <label for="disabledSelect" class="col-sm-2 control-label">公司地址</label>
                           <div class="col-sm-10">
                              <input type="text" name="address" value="${entity.address }" class="form-control"/>
                           </div>
                        </div>
                        <div class="form-group">
							<label for="disabledSelect" class="col-sm-2 control-label">公司电话</label>
							<div class="col-sm-10">
								<input type="text" name="tel" value="${entity.tel }" class="form-control"/>
							</div>
                        </div>
                        <div class="form-group">
                        	<label for="disabledSelect" class="col-sm-2 control-label"></label>
							<div class="col-sm-10">电话示例：（010-62970482）</div>
                        </div>
                        <div class="form-group">
							<label for="disabledSelect" class="col-sm-2 control-label">公司手机</label>
							<div class="col-sm-10">
								<input type="text" name="phone" value="${entity.phone }"  class="form-control"/>
							</div>
                        </div>
                        <div class="form-group">
							<label for="disabledSelect" class="col-sm-2 control-label">公司邮箱</label>
							<div class="col-sm-10">
								<input type="text" name="email" value="${entity.email }" class="form-control"/>
							</div>
                        </div>
                    </fieldset>
                    <fieldset>
                        <div class="form-group">
                        	<label class="col-sm-2 control-label" for="ds_host"></label>
                           <div class="col-sm-4">
                              <input type="submit" value="提交" class="btn btn-primary"/>
                           </div>
                           <label class="col-sm-2 control-label" for="ds_host"></label>
                           <div class="col-sm-4">
                              <input type="reset" value="重置" class="btn btn-danger"/>
                           </div>
                        </div>
                    </fieldset>
                </form>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="${path}/view/company/js/company.js"></script>
</html>