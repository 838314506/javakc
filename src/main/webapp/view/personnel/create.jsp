<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>人事处人员信息添加页面</title>
		<%@ include file="../../common/jsp/header.jsp"%>
	</head>
	<body>
		<div class="wrapper wrapper-content animated fadeInRight">
			<div>
				<div class="col-sm-4"><input type="button" value="返回上一页" class="btn btn-success" onclick="javascript:history.back();"/></div>
			</div>
			<div class="ibox float-e-margins">
				<form action="${path }/personnel/create.do" method="post" class="form-horizontal" role="form">
                    <fieldset>
						<legend>人事处人员详情表单</legend>
                        <div class="form-group">
                           <label for="disabledSelect" class="col-sm-2 control-label">名称</label>
                           <div class="col-sm-4">
                              <input type="text" name="pename" class="form-control"/>
                           </div>
                           <label for="disabledSelect" class="col-sm-2 control-label">身份证号</label>
                           <div class="col-sm-4">
                              <input type="number" name="idcard" class="form-control"/>
                           </div>
                        </div>
                        <div class="form-group">
							<label for="disabledSelect" class="col-sm-2 control-label">状态</label>
							<div class="col-sm-4">
								<select id="sel" name="state" class="form-control">
									<option value="0">请选择</option>
									<option value="1">在职</option>
									<option value="2">休假</option>
								</select>
							</div>
							<label for="disabledSelect" class="col-sm-2 control-label">职级</label>
							<div class="col-sm-4">
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
							<label for="disabledSelect" class="col-sm-2 control-label">是否合同制
							</label>
							<div class="col-sm-6">
								<input type="radio" value="1" name="compact" checked/>是
								<input type="radio" value="2" name="compact" />否
							</div>
                        </div>
                        <div class="form-group">
							<label for="disabledSelect" class="col-sm-2 control-label">项目</label>
							<div class="col-sm-10">
								车补<input type="checkbox" name="eatate" value="1"/>&nbsp&nbsp&nbsp
								供暖<input type="checkbox" name="heating" value="1"/>&nbsp&nbsp&nbsp
								物业<input type="checkbox" name="car" value="1"/>&nbsp&nbsp&nbsp
								医保<input type="checkbox" name="hi" value="1"/>&nbsp&nbsp&nbsp
								养老保险<input type="checkbox" name="ei" value="1"/>&nbsp&nbsp&nbsp
								养老失业<input type="checkbox" name="unemp" value="1"/>&nbsp&nbsp&nbsp
								职业年金<input type="checkbox" name="oa" value="1"/>&nbsp&nbsp&nbsp
								工伤生育<input type="checkbox" name="oibirth" value="1"/>
							</div>
                        </div>
                        <div class="form-group">
							<label for="disabledSelect" class="col-sm-2 control-label">原因</label>
							<div class="col-sm-10">
								<input type="text" name="reason" class="form-control"/>
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
	<script type="text/javascript" src="./js/personnel.js"></script>
</html>