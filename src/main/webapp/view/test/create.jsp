<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>测试添加页面</title>
		<%@ include file="../../common/jsp/header.jsp"%>
		<link href="${path }/static/css/plugins/file-input/fileinput.min.css" rel="stylesheet">
	</head>
	<body>
		<div class="wrapper wrapper-content animated fadeInRight">
			<div>
				<div class="col-sm-4"><input type="button" value="返回上一页" class="btn btn-success" onclick="javascript:history.back();"/></div>
			</div>
			<div class="ibox float-e-margins">
				<form action="${path }/test/create.do" method="post" enctype="multipart/form-data"
					class="form-horizontal" role="form">
                    <fieldset>
                        <legend>配置数据源</legend>
                       <div class="form-group">
                          <label class="col-sm-2 control-label" for="ds_host">主机名</label>
                          <div class="col-sm-4">
                             <input class="form-control" id="ds_host" type="text" placeholder="192.168.1.109"/>
                          </div>
                          <label class="col-sm-2 control-label" for="ds_name">数据库名</label>
                          <div class="col-sm-4">
                             <input class="form-control" id="ds_name" type="text" placeholder="orcl"/>
                          </div>
                       </div>
                       <div class="form-group">
                          <label class="col-sm-2 control-label" for="ds_username">用户名</label>
                          <div class="col-sm-4">
                             <input class="form-control" id="ds_username" type="text" placeholder="zhg"/>
                          </div>
                          <label class="col-sm-2 control-label" for="ds_password">密码</label>
                          <div class="col-sm-4">
                             <input class="form-control" id="ds_password" type="password" placeholder="zhg"/>
                          </div>
                       </div>
                    </fieldset>     
                    <fieldset>
						<legend>测试表单</legend>
                        <div class="form-group">
                           <label for="disabledSelect" class="col-sm-2 control-label">名称</label>
                           <div class="col-sm-10">
                              <input type="text" name="testName" class="form-control"/>
                           </div>
                        </div>
                        <div class="form-group">
                           <label for="disabledSelect" class="col-sm-2 control-label">级别</label>
                           <div class="col-sm-10">
                              <zhg:select name="testLevel" codeTp="level" def="true" cls="form-control"></zhg:select>
                           </div>
                        </div>
                        <div class="form-group">
							<label for="disabledSelect" class="col-sm-2 control-label">文件</label>
							<div class="col-sm-10">
								<input id="inputfile" name="testPhoto" type="file" class="file"/>
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
	<script type="text/javascript" src="${path }/static/js/plugins/file-input/fileinput.min.js"></script>
	<script type="text/javascript" src="./js/test.js"></script>
</html>