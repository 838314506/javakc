<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>公司展示列表页面</title>
		<%@ include file="../../common/jsp/header.jsp"%>
	</head>
	<body>
		<div class="wrapper wrapper-content animated fadeInRight">
			<div class="ibox float-e-margins">
				<form id="searchForm" action="">
				<div class="col-sm-12">
					<!-- ------------按钮组 start------------ -->
	                <div class="alert alert-success" role="alert">公司详细信息</div>
	                <div class="col-sm-8">
	                	<div class="btn-group hidden-xs" role="group">
	                		<shiro:hasPermission name="company:create">
			                	<button type="button" class="btn btn-primary" data-toggle="modal" id="create" name="company/create.jsp">
		                            <i class="glyphicon glyphicon-plus" aria-hidden="true"></i>添加
		                        </button>
	                        </shiro:hasPermission>
	                        <shiro:hasPermission name="company:update">
		                        <button type="button" class="btn btn-success" data-toggle="modal" id="update" name="company/view.do">
		                            <i class="glyphicon glyphicon-pencil" aria-hidden="true"></i>修改
		                        </button>
	                        </shiro:hasPermission>
	                        <shiro:hasPermission name="company:delete">
		                        <button type="button" class="btn btn-danger" data-toggle="modal" id="delete" name="company/delete.do">
		                            <i class="glyphicon glyphicon-trash" aria-hidden="true"></i>删除
		                        </button>
	                        </shiro:hasPermission>
		                 </div>
	                </div>
	                <div class="col-sm-4">
	                	<input class="form-control" id="search" name="cname" value="${entity.cname }" type="text" placeholder="查询内容 回车搜索"/>
	                </div>
	                <!-- ------------按钮组 end------------ -->
	                
						<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
						<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		                 <table class="table table-striped table-bordered table-hover table-condensed">
					        <thead>
					            <tr>
					                <th><input type="checkbox" id="checkall"/></th>
					                <th>名称</th>
					                <th>地址</th>
					                <th>电话</th>
					                <th>手机</th>
					                <th>邮箱</th>
					                <th>性质</th>
					            </tr>
					        </thead>
					        <tbody>
					        	<c:forEach var="e" items="${page.list }" varStatus="v">
						            <tr>
						                <th><input type="checkbox" name="ids" value="${e.cid }"/></th>
						                <th>${e.cname }</th>
						                <th>${e.address }</th>
						                <th>${e.tel }</th>
						                <th>${e.phone }</th>
						                <th>${e.email }</th>
						                <th><zhg:show value="1" codeTp="property"></zhg:show></th>
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