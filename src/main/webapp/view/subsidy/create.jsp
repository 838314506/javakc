<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%
	String type = request.getParameter("type");
%>
<!DOCTYPE html>
<html>
	<head>
		<title>物业补贴添加页面</title>
		<%@ include file="../../common/jsp/header.jsp"%>
	</head>
	<body>
		<div class="wrapper wrapper-content animated fadeInRight">
			<div>
				<div class="col-sm-4"><input type="button" value="返回上一页" class="btn btn-success" onclick="javascript:history.back();"/></div>
			</div>
			<div class="ibox float-e-margins">
				<form action="${path }/subsidy/create.do" method="post" class="form-horizontal" role="form">
                    <fieldset>
						<legend>补贴</legend>
                        <div class="form-group">
                           <label for="disabledSelect" class="col-sm-2 control-label">姓名:</label>
                           <div class="col-sm-4">
                           	  <input type="hidden" id="type" name="type" value="<%=type%>">
                           	  <input type="hidden" id="pid" name="pid" >
                              <input type="text" id="pname" name="pname" class="form-control"placeholder="点击选择人员" readOnly/>
                           </div>
                        </div>
                        <div class="form-group">
                           <label for="disabledSelect" class="col-sm-2 control-label">身份证号:</label>
                           <div class="col-sm-4">
                              <input type="text" id="idcard" name="idcard" class="form-control" readOnly/>
                           </div>
                        </div>
                        <div class="form-group">
							<label for="disabledSelect" class="col-sm-2 control-label">金额:</label>
							<div class="col-sm-4">
								<input type="text" name="amount" class="form-control"/>
							</div>
                        </div>
                        <div class="form-group">
							<label for="disabledSelect" class="col-sm-2 control-label">更改原因:</label>
							<div class="col-sm-4">
								<input type="text" name="reason" class="form-control"/>
							</div>
                        </div>
                    </fieldset>
                    <fieldset>
                        <div class="form-group">
                        	<label class="col-sm-2 control-label" for="ds_host"></label>
                           <div class="col-sm-4">
                              <input type="submit" id="btn" value="保存" class="btn btn-primary"/>
                           </div>
                        </div>
                    </fieldset>
                </form>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="${path }/static/js/plugins/bootstrap-switch/bootstrap-switch.min.js"></script>
	<script type="text/javascript" src="./js/subsidy-create.js"></script>
</html>