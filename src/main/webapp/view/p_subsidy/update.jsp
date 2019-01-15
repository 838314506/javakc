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
				<form action="${path }/personnel_subsidy/update.do" method="post" class="form-horizontal" role="form">
                    <fieldset>
						<legend>补贴添加</legend>
                        <div class="form-group">
                           <label for="disabledSelect" class="col-sm-2 control-label">姓名:</label>
                           <div class="col-sm-4">
                           	  <input type="hidden" id="type" name="type" value="${entity.type }">
                           	  <input type="hidden" id="peid" name="peid" value="${entity.pe.peid }">
                              <input type="text" id="pename" name="pename" value="${entity.pe.pename }" class="form-control"placeholder="点击选择人员" readOnly/>
                           </div>
                        </div>
                        <div class="form-group">
                           <label for="disabledSelect" class="col-sm-2 control-label">身份证号:</label>
                           <div class="col-sm-4">
                              <input type="text" id="idcard" name="idcard" value="${entity.pe.idcard }" class="form-control" readOnly/>
                           </div>
                        </div>
                        <div class="form-group">
                           <label for="disabledSelect" class="col-sm-2 control-label">缴费基数:</label>
                           <div class="col-sm-4">
                              <input type="text" id="eb" name="eb" value="${entity.eb }" class="form-control" />
                           </div>
                        </div>
                        <div class="form-group">
                           <label for="disabledSelect" class="col-sm-2 control-label">缴费基率:</label>
                           <div class="col-sm-4">
                              <input type="text" id="rate" name="rate" value="${entity.rate }" class="form-control" />
                           </div>
                        </div>
                        <div class="form-group">
                           <label for="disabledSelect" class="col-sm-2 control-label">个人部分金额:</label>
                           <div class="col-sm-4">
                              <input type="text" id="m_amount" value="${entity.m_amount }" name="m_amount" class="form-control" />
                           </div>
                        </div>
                        <div class="form-group">
                           <label for="disabledSelect" class="col-sm-2 control-label">国家部分金额:</label>
                           <div class="col-sm-4">
                              <input type="text" id="c_amount" value="${entity.c_amount }" name="c_amount" class="form-control" />
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
                              <input type="submit" id="btn" value="保存" class="btn btn-primary"/>
                           </div>
                        </div>
                    </fieldset>
                </form>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="${path }/static/js/plugins/bootstrap-switch/bootstrap-switch.min.js"></script>
	<script type="text/javascript" src="./js/psubsidy-create.js"></script>
</html>