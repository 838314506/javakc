<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>补贴展示列表页面</title>
		<%@ include file="../../common/jsp/header.jsp"%>
	</head>
	<body>
		<div class="wrapper wrapper-content animated fadeInRight">
			<div class="ibox float-e-margins">
				<form id="searchForm" action="">
				<div class="col-sm-12">
					<!-- ------------按钮组 start------------ -->
	                <div class="alert alert-success" role="alert" >${entity.type==1?"物业":"供暖 " }详细信息</div>
	                <div class="col-sm-4">
	                	<div class="btn-group hidden-xs" role="group">
	                	<shiro:hasPermission name="subsidy:create">
			               	  <button type="button" class="btn btn-primary" data-toggle="modal" id="create" name="subsidy/create.jsp?type=${entity.type}">
		                           <i class="glyphicon glyphicon-plus" aria-hidden="true"></i>添加
		                      </button>
		                </shiro:hasPermission>
		                <shiro:hasPermission name="subsidy:update">
		                      <button type="button" class="btn btn-success" data-toggle="modal" id="update" name="subsidy/load.do">
		                          <i class="glyphicon glyphicon-pencil" aria-hidden="true"></i>修改
		                      </button>
		                </shiro:hasPermission>
		                <shiro:hasPermission name="subsidy:delete">
		                      <button type="button" class="btn btn-danger" data-toggle="modal" id="delete" name="subsidy/delete.do">
		                          <i class="glyphicon glyphicon-trash" aria-hidden="true"></i>删除
		                      </button>
		                </shiro:hasPermission>
		                <shiro:hasPermission name="subsidy:export">
	                        <button type="button" class="btn btn-info" data-toggle="modal" id="export" name="subsidy/export.do?type=${entity.type }">
	                            <i class="glyphicon glyphicon-book" aria-hidden="true"></i>导出
	                        </button>
	                    </shiro:hasPermission>
		             </div>
	              </div>
	                <div class="col-sm-4">
	                	<input type="hidden" value="${entity.type}" id="type" name="type">
	                	<input class="form-control" id="search" name="month" value="<zhg:date times="${entity.month }"/>" type="datetime" placeholder="查询单月信息 回车搜索"/>
	                </div>
	                <div class="col-sm-4">
	                	<input class="form-control" id="search1" name="pname" value="${entity.pe.pname }" type="" placeholder="查询信息 回车搜索"/>
	                </div>
	                 <!-- ------------按钮组 end------------ -->
						<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
						<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		                 <table class="table table-striped table-bordered table-hover table-condensed">
					        <thead>
					            <tr>
					                <th><input type="checkbox" id="checkall"/></th>
					                <th>序号</th>
					                <th>姓名</th>
					                <th>身份证</th>
					                <th>职级</th>
					                <th>金额</th>
					                <th>单位</th>
					                <th>月份</th>
					            </tr>
					        </thead>
					        <tbody>
					        	<c:forEach var="e" items="${page.list }" varStatus="v">
						            <tr>
						                <th><input type="checkbox" name="ids" value="${e.sid }"/></th>
						                <th>${v.count }</th>
						                <th>${e.pe.pname }</th>
						                <th>${e.pe.idcard }</th>
						                <th><zhg:show value="${e.pe.grade }" codeTp="person_grade"/></th>
						                <th>${e.amount }</th>
						                <th></th>
						                <th><zhg:date times="${e.month }"/></th>
						            </tr>
					            </c:forEach>
					        </tbody>
					    </table>
				    <div class="page">${pagestring }</div>
				    <div>综述:  <zhg:date times="${entity.month }" format="M"/>月份${entity.type==1?"物业":"供暖 "}补贴,共 ${count} 人,合计金额${sum }元</div>
			     </div>
			     </form>
			</div>
		</div>
	</body>
	<script type="text/javascript">
	$(function(){
		$('#search1').keydown(function(e){
			if(e.keyCode==13){
				 $('#searchForm').submit();
			}
		});
	});
	</script>
</html>