<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>人员添加页面</title>
		<%@ include file="../../common/jsp/header.jsp"%>
	</head>
	<body>
		<div class="wrapper wrapper-content animated fadeInRight">
			<div>
				<div class="col-sm-4"><input type="button" value="返回上一页" class="btn btn-success" onclick="javascript:history.back();"/></div>
			</div>
			<div class="ibox float-e-margins">
				<form action="${path }/person/create.do" method="post" class="form-horizontal" role="form">
                    <fieldset>
						<legend>人员详情表单</legend>
                        <div class="form-group">
                           <label for="disabledSelect" class="col-sm-2 control-label">名称</label>
                           <div class="col-sm-4">
                              <input type="text" name="pname" class="form-control"/>
                           </div>
                           <label for="disabledSelect" class="col-sm-2 control-label">证件</label>
                           <div class="col-sm-4">
                              <input type="number" name="idcard" class="form-control"/>
                           </div>
                        </div>
                        <div class="form-group">
							<label for="disabledSelect" class="col-sm-2 control-label">状态</label>
							<div class="col-sm-10">
								<zhg:select name="state" codeTp="person_state" def="true" cls="form-control"/>
							</div>
                        </div>
                        <div class="form-group">
							<label for="disabledSelect" class="col-sm-2 control-label">职级</label>
							<div class="col-sm-10">
								<zhg:select name="grade" codeTp="person_grade" def="true" cls="form-control"></zhg:select>
							</div>
                        </div>
                        <div class="form-group">
							<label for="disabledSelect" class="col-sm-2 control-label">起薪日期</label>
							<div class="col-sm-10">
								<input type="text" name="time" class="form-control"/>
							</div>
                        </div>
                        <div class="form-group">
							<label for="disabledSelect" class="col-sm-2 control-label">项目</label>
							<div class="col-sm-2">
								供暖<input type="checkbox" name="heating" value="1"/>
							</div>
							<div class="col-sm-2">
								物业<input type="checkbox" name="eatate" value="1"/>
							</div>
                        </div>
                        <div class="form-group">
							<label for="disabledSelect" class="col-sm-2 control-label">原因</label>
							<div class="col-sm-10">
								<input type="text" name="remarks" class="form-control"/>
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
	<script type="text/javascript" src="./js/person.js"></script>
</html>