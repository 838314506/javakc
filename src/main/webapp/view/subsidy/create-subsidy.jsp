<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>菜单展示列表页面</title>
		<%@ include file="../../../common/jsp/header.jsp"%>
		<link href="<%=path%>static/css/plugins/treegrid/jquery.treegrid.css" rel="stylesheet">
	</head>
	<body>
		<div class="wrapper wrapper-content animated fadeInRight">
			<div class="ibox float-e-margins">
				<form id="searchForm" action="">
					<div class="col-sm-12">
						<table class="tree table table-striped table-bordered table-hover table-condensed">
							<thead>
					            <tr>
					                <th>选择</th>
					                <th>姓名</th>
					                <th>身份证</th>
					                <th>职级</th>
					            </tr>
					        </thead>
					        <tbody>
								<c:forEach var="m" items="${list }" varStatus="v">
									<tr class="treegrid-${m.pe.pid } treegrid-parent-${m.pe.pid }">
										<td>
											<input type="radio" name="pid" value="${m.pe.pid }" value1="${m.pe.pname }" value2="${m.pe.idcard }"/>
										</td>
										<td>${m.pe.pname }</td>
										<td>${m.pe.idcard }</td>
										<td><zhg:show value="${m.pe.grade }" codeTp="person_grade"/></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class="col-sm-8">
		                	<div class="btn-group" role="group">
			                	<button type="button" class="btn btn-primary" data-toggle="modal" id="ascertain">
		                            <i class="glyphicon glyphicon-plus" aria-hidden="true"></i>确定
		                        </button>
		                        <button type="button" class="btn btn-danger" data-toggle="modal" id="shutdo">
		                            <i class="glyphicon glyphicon-trash" aria-hidden="true"></i>关闭
		                        </button>
			                 </div>
		                </div>
					</div>
				</form>
			</div>
		</div>
		<script type="text/javascript" src="<%=path%>static/js/plugins/treegrid/jquery.treegrid.min.js"></script>
		<script type="text/javascript" src="<%=path%>static/js/plugins/treegrid/jquery.treegrid.bootstrap3.js"></script>
		<script type="text/javascript">
			$(function()
			{
				$('.tree').treegrid(
				{
					treeColumn: 1
				});
				
				var index = parent.layer.getFrameIndex(window.name);
				
				$('#ascertain').click(function()
				{
					var count = $('[name=pid]:checked').length;
					if(count == 0)
					{
						layer.msg('怎么着, 没有喜欢的?', {icon: 4});
						return;
					}
					else
					{
						var id = $('[name=pid]:checked').val();
						var name = $('[name=pid]:checked').attr('value1');
						var idcard = $('[name=pid]:checked').attr('value2');
						
						parent.$('#pid').val(id);
						parent.$('#pname').val(name);
						parent.$('#idcard').val(idcard);
					    parent.layer.close(index);
					}
				});
				
				$('#shutdo').click(function()
				{
					parent.layer.close(index);
				});
			});
		</script>
	</body>
</html>