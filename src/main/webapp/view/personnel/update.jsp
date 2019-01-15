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
				<form action="${path }/personnel/update.do" method="post" class="form-horizontal" role="form">
                    <fieldset>
						<legend>人事处人员详情表单</legend>
                        <div class="form-group">
                           <label for="disabledSelect" class="col-sm-2 control-label">名称</label>
                           <div class="col-sm-4">
							  <input type="hidden" name="peid" value="${entity.peid }"/>
							  <input type="hidden" name="tid" value="${entity.te.tid }"/>
                              <input type="text" name="pename" value="${entity.pename }" class="form-control"/>
                           </div>
                           <label for="disabledSelect" class="col-sm-2 control-label">身份证号</label>
                           <div class="col-sm-4">
                              <input type="number" name="idcard" value="${entity.idcard }" class="form-control"/>
                           </div>
                        </div>
                        <div class="form-group">
							<label for="disabledSelect" class="col-sm-2 control-label">状态</label>
							<div class="col-sm-4">
								<select id="sel" name="state" class="form-control">
									<option value="0">请选择</option>
									<option value="1" ${entity.state == 1?"selected":"" }>在职</option>
									<option value="2" ${entity.state == 2?"selected":"" }>休假</option>
								</select>
							</div>
							<label for="disabledSelect" class="col-sm-2 control-label">职级</label>
							<div class="col-sm-4">
								<zhg:select name="grade" codeTp="person_grade" value="${entity.grade }" def="true" cls="form-control"></zhg:select>
							</div>
                        </div>
                        <div class="form-group">
							<label for="disabledSelect" class="col-sm-2 control-label">起薪日期</label>
							<div class="col-sm-10">
								<input type="text" name="time" value="<zhg:date times="${entity.time }" format="yyyy-MM-dd"/>" class="form-control"/>
							</div>
                        </div>
                        <div class="form-group">
							<label for="disabledSelect" class="col-sm-2 control-label">是否合同制
							</label>
							<div class="col-sm-6">
								<input type="radio" value="1" name="compact" ${entity.compact == 1?"checked":"" }/>是
								<input type="radio" value="2" name="compact" ${entity.compact == 2?"checked":"" }/>否
							</div>
                        </div>
                        <div class="form-group">
							<label for="disabledSelect" class="col-sm-2 control-label">项目</label>
							<div class="col-sm-10">
								车补<input type="checkbox" name="car" value="1" ${entity.te.car == 1?"checked":"" }/>
								供暖<input type="checkbox" name="heating" value="1" ${entity.te.heating == 1?"checked":"" }/>
								物业<input type="checkbox" name="eatate" value="1" ${entity.te.eatate == 1?"checked":"" }/>
								医保<input type="checkbox" name="hi" value="1" ${entity.te.hi == 1?"checked":"" }/>
								养老保险<input type="checkbox" name="ei" value="1" ${entity.te.ei == 1?"checked":"" }/>
								养老失业<input type="checkbox" name="unemp" value="1" ${entity.te.unemp == 1?"checked":"" }/>
								职业年金<input type="checkbox" name="oa" value="1" ${entity.te.oa == 1?"checked":"" }/>
								工伤生育<input type="checkbox" name="oibirth" value="1" ${entity.te.oibirth == 1?"checked":"" }/>
							</div>
                        </div>
                        <div class="form-group">
							<label for="disabledSelect" class="col-sm-2 control-label">原因</label>
							<div class="col-sm-10">
								<input type="text" name="reason" value="${entity.reason }" class="form-control"/>
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