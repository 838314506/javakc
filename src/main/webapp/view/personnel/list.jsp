<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>人事处列表页面</title>
		<%@ include file="../../common/jsp/header.jsp"%>
	</head>
	<body>
		<div class="wrapper wrapper-content animated fadeInRight">
			<div class="ibox float-e-margins">
				<form id="searchForm" action="">
				<div class="col-sm-12">
					<!-- ------------按钮组 start------------ -->
	                <div class="alert alert-success" role="alert">人事处人员详细信息</div>
	                <div class="col-sm-8">
	                	<div class="btn-group hidden-xs" role="group">
	                	
	                	<shiro:hasPermission name="personnel:create">
			               	  <button type="button" class="btn btn-primary" data-toggle="modal" id="create" name="personnel/create.jsp">
		                           <i class="glyphicon glyphicon-plus" aria-hidden="true"></i>添加
		                      </button>
	                    </shiro:hasPermission>
	                    
	                    <shiro:hasPermission name="personnel:update">
		                      <button type="button" class="btn btn-success" data-toggle="modal" id="update" name="personnel/load.do">
		                          <i class="glyphicon glyphicon-pencil" aria-hidden="true"></i>修改
		                      </button>
	                    </shiro:hasPermission>
	                    
	                    <shiro:hasPermission name="personnel:delete">
		                      <button type="button" class="btn btn-danger" data-toggle="modal" id="delete" name="personnel/delete.do">
		                          <i class="glyphicon glyphicon-trash" aria-hidden="true"></i>删除
		                      </button>
	                    </shiro:hasPermission>
	                    
						<shiro:hasPermission name="personnel:export">
	                        <button type="button" class="btn btn-info" data-toggle="modal" id="export" name="personnel/export.do">
	                            <i class="glyphicon glyphicon-book" aria-hidden="true"></i>导出
	                        </button>
	                    </shiro:hasPermission>
	                    
	                    <shiro:hasPermission name="personnel:import">
	                        <div class="btn-group">
							    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
							    	导入
							    	<span class="caret"></span>
							    </button>
							    <ul class="dropdown-menu">
							        <li><a href="${path}/test/download.do">下载模板</a></li>
							        <li><input class="form-control" id="updatemodel" type="text" readonly placeholder="上传模板"/></li>
							    </ul>
						    </div>
						</shiro:hasPermission>
		                </div>
	                </div>
	                <div class="col-sm-4">
	                	<input class="form-control" id="search" name="pename" value="" type="" placeholder="查询内容 回车搜索"/>
	                </div>
	                 <!-- ------------按钮组 end------------ -->
						<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
						<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		                 <table class="table table-striped table-bordered table-hover table-condensed">
					        <thead>
					            <tr>
					                <th><input type="checkbox" id="checkall"/></th>
					                <th>名称</th>
					                <th>证件</th>
					                <th>职级</th>
					                <th>入职时间</th>
					                <th>状态</th>
					                <th>单位</th>
					                <th>发放工资项</th>
					                <th>创建日期</th>
					                <th>修改日期</th>
					                <th>创建人</th>
					                <th>修改人</th>
					            </tr>
					        </thead>
					        <tbody>
					        	<c:forEach var="e" items="${page.list }" varStatus="v">
						            <tr>
						                <th>
						                	<input type="checkbox" name="ids" value="${e.peid }"/>
						                </th>
						                <th>${e.pename }</th>
						                <th>${e.idcard }</th>
						                <th><zhg:show value="${e.grade }" codeTp="person_grade"/></th>
						                <th><zhg:date times="${e.time }"/></th>
						                <th>${e.state == 1?"在职":"休假" }</th>
						                <th></th>
						                <th>
											${e.te.heating ==1?"供暖":""}
											${e.te.eatate ==1?"物业":""}
											${e.te.car ==1?"车补":""}
											${e.te.hi ==1?"医保":""}
											${e.te.ei ==1?"养老保险":""}
											${e.te.unemp ==1?"养老失业":""}
											${e.te.oa ==1?"职业年金":""}
											${e.te.oibirth ==1?"工伤生育":""}
										</th>
						                <th><zhg:date times="${e.createDate }"/></th>
						                <th><fmt:formatDate value="${e.updateDate }" pattern="yyyy-MM-dd"/></th>
						                <th>${e.createUser.userName }</th>
						                <th>${e.updateUser.userName }</th>
						            </tr>
					            </c:forEach>
					        </tbody>
					    </table>
				    <div class="page">${page}</div>
			     </div>
			     </form>
			</div>
		</div>
		<!-- 用于上传文件的div -->
		<div id="fileUpload" class="wrapper wrapper-content animated fadeInRight" style="display:none;">
			<div class="ibox float-e-margins">
				<form action="${path }/personnel/import.do" method="post" id="myForm"  enctype="multipart/form-data">
					<input type="hidden"  name="sid" value="">
                    <fieldset>
						<legend>上传模板</legend>
                        <div class="form-group">
                           <label for="disabledSelect" class="col-sm-2 control-label">从本地上传模板</label>
                           <div class="col-sm-6">
                              <input type=file name="loadfile" class="form-control" id="loadfile"/>
                           </div>
                        </div>
                    </fieldset>
                    <fieldset>
                        	<div class="btn-group" role="group">
                        	<button type="button" class="btn btn-primary" data-toggle="modal" id="ascertain">
		                         <i class="glyphicon glyphicon-plus" aria-hidden="true"></i>确定
		                    </button> 
		                    <button type="button" class="btn btn-danger" data-toggle="modal" id="shutdo">
		                         <i class="glyphicon glyphicon-trash" aria-hidden="true"></i>关闭
		                    </button>
			                </div>
                    </fieldset>
                </form>

			</div>
		</div>
		
	</body>
	<script type="text/javascript" src="${path }/view/person/js/person-create.js"></script>
	<script type="text/javascript">
		$(function(){
			var index = parent.layer.getFrameIndex(window.name);
			$('#shutdo').click(function()
			{
				parent.layer.close(index);
			});
			$('#ascertain').click(function(){
				$("#myForm").submit();
			});
		});
	</script>
</html>