<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
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
				<form action="${path }/subsidy/update.do" method="post" class="form-horizontal" role="form">
                    <fieldset>
						<legend>${entity.type==1?"物业":"供暖" }补贴</legend>
                        <div class="form-group">
                        	<input type="hidden" value="${entity.sid }" name="sid">
                        	<input type="hidden" value="${entity.type }" name="type">
                           <label for="disabledSelect" class="col-sm-2 control-label">姓名:</label>
                           <div class="col-sm-4">
                              <input type="text" name="pname" value="${entity.pe.pname }" class="form-control" readOnly/>
                           </div>
                        </div>
                        <div class="form-group">
                           <label for="disabledSelect" class="col-sm-2 control-label">身份证号:</label>
                           <div class="col-sm-4">
                              <input type="number" name="idcard" value="${entity.pe.idcard }" class="form-control" readOnly/>
                           </div>
                        </div>
                        <div class="form-group">
							<label for="disabledSelect" class="col-sm-2 control-label">金额:</label>
							<div class="col-sm-4">
								<input type="number" name="amount" value="${entity.amount }" class="form-control"/>
							</div>
                        </div>
                        <div class="form-group">
							<label for="disabledSelect" class="col-sm-2 control-label">更改原因:</label>
							<div class="col-sm-4">
								<input type="text" name="reason" value="${entity.reason }" class="form-control"/>
							</div>
                        </div>
                    </fieldset>
                    <fieldset>
                        <div class="form-group">
                        	<label class="col-sm-2 control-label" for="ds_host"></label>
                           <div class="col-sm-4">
                              <input type="submit" value="保存" class="btn btn-primary"/>
                           </div>
                        </div>
                    </fieldset>
                </form>
			</div>
		</div>
	</body>
<!-- 	<script type="text/javascript" src="./js/person.js"></script> -->
</html>