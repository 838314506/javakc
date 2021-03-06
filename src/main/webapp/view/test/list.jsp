<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>测试展示列表页面</title>
		<%@ include file="../../common/jsp/header.jsp"%>
	</head>
	<body>
		<div class="wrapper wrapper-content animated fadeInRight">
			<div class="ibox float-e-margins">
				<form id="searchForm" action="">
				<div class="col-sm-12">
					<!-- ------------按钮组 start------------ -->
	                <div class="alert alert-success" role="alert">测试详细信息</div>
	                <div class="col-sm-8">
	                	<div class="btn-group hidden-xs" role="group">
		                	<button type="button" class="btn btn-primary" data-toggle="modal" id="create" name="test/create.jsp">
	                            <i class="glyphicon glyphicon-plus" aria-hidden="true"></i>添加
	                        </button>
	                        <button type="button" class="btn btn-success" data-toggle="modal" id="update" name="test/view.do">
	                            <i class="glyphicon glyphicon-pencil" aria-hidden="true"></i>修改
	                        </button>
	                        <button type="button" class="btn btn-danger" data-toggle="modal" id="delete" name="test/delete.do">
	                            <i class="glyphicon glyphicon-trash" aria-hidden="true"></i>删除
	                        </button>
	                        <button type="button" class="btn btn-info" data-toggle="modal" id="export" name="test/export.do">
	                            <i class="glyphicon glyphicon-book" aria-hidden="true"></i>导出
	                        </button>
	                        <div class="btn-group">
							    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
							    	导入
							    	<span class="caret"></span>
							    </button>
							    <ul class="dropdown-menu">
							        <li><a href="${path}/test/download.do">下载模板</a></li>
							        <li><a href="#">上传模板</a></li>
							    </ul>
						    </div>
		                 </div>
	                </div>
	                <div class="col-sm-4">
	                	<input class="form-control" id="search" name="testName" value="${entity.testName }" type="text" placeholder="查询内容 回车搜索"/>
	                </div>
	                 <!-- ------------按钮组 end------------ -->
						<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
						<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		                 <table class="table table-striped table-bordered table-hover table-condensed">
					        <thead>
					            <tr>
					                <th><input type="checkbox" id="checkall"/></th>
					                <th>测试主键</th>
					                <th>创建日期</th>
					                <th>测试类型</th>
					            </tr>
					        </thead>
					        <tbody>
					        	<c:forEach var="e" items="${page.list }" varStatus="v">
						            <tr>
						                <th><input type="checkbox" name="ids" value="${e.testId }"/></th>
						                <th>${e.testName }</th>
						                <th><zhg:date times="${e.testTime }" format="yyyy-MM-dd"></zhg:date></th>
						                <th><zhg:show value="${e.testLevel }" codeTp="level"></zhg:show></th>
						            </tr>
					            </c:forEach>
					        </tbody>
					    </table>
				    <div class="page">${page}</div>
			     </div>
			     </form>
			</div>
		</div>
	</body>
</html>