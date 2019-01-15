<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%
	String type = request.getParameter("type");
%>
<!DOCTYPE html>
<html>
	<head>
		<title>汇总页面</title>
		<%@ include file="../../common/jsp/header.jsp"%>
	</head>
	<style>
	th{text-align:center} 
	</style>
	<body>
		<div class="wrapper wrapper-content animated fadeInRight">
			<div>
				<div class="col-sm-4"><input type="button" value="返回上一页" class="btn btn-success" onclick="javascript:history.back();"/></div>
			</div>
			<div class="ibox float-e-margins">
				<div>
					<div class="alert alert-success" role="alert" >干部职工补贴发放汇总表</div>
				</div>
				<form action="${path }/subsidy/tabulate.do" method="post" class="form-horizontal" role="form">
				<div class="col-sm-12">
				<!-- ------------按钮组 start------------ -->
	               <div class="col-sm-6">
	                	<span style="font-size:20px">补贴类型：</span>     
						<input type="radio" value="1" name="type" ${entity.type == 1?"checked":"" }>
						<span style="font-size:15px">物业补贴</span> 
						<input type="radio" value="2" name="type" ${entity.type == 2?"checked":"" }>
						<span style="font-size:15px">供暖补贴</span>
	              </div>
	              <div class="col-sm-3">
	              	<input class="form-control" id="search1" name="month" value="<zhg:date times="${entity.month }"/>" type="datetime" placeholder="查询单月信息 回车搜索"/>
	              </div>
	              <div class="col-sm-3">
		             <button type="button" class="btn btn-primary" data-toggle="modal" id="tabulate" name="subsidy/tabulate.do ">
			             <i class="glyphicon glyphicon-plus" aria-hidden="true"></i>统计
			         </button>   
		             <button type="button" class="btn btn-info" data-toggle="modal" id="export" name="subsidy/exportword.do">
		                 <i class="glyphicon glyphicon-book" aria-hidden="true"></i>导出
		             </button> 
	              </div>
	            </div>
	            <hr color=#ffffff width="1280" size="10">
	            <div align="center">
	            	<div class="col-sm-12">
	         			<p>
	         				<span style="font-size:30px">办公厅干部职工补贴发放汇总表</span>
	         			</p>
         			</div>
         			<br>
       				<div class="col-sm-12">
	       				<div class="col-sm-6">
	       					<span style="font-size:15px">部门:</span>
		             	</div>
	       				<div class="col-sm-4">
	       					<span style="font-size:15px">
	       					<zhg:date times="${entity.month }" format="yyyy"/>年
	       					<zhg:date times="${entity.month }" format="MM"/>月
	       					<zhg:date times="${entity.month }" format="dd"/>日</span>
		             	</div>
       				</div>
       				<table name="f1" height="200" width="680" border="1" cellspacing="0" cellpadding="0">
       					<tr >
       						<th width="170"><span style="font-size:15px">项目</span></th>
       						<th colspan="3">
       							<span style="font-size:15px">${entity.type == 1?"物业":"供暖" }补贴</span>
       						</th>
       					</tr>
       					<tr>
       						<th  width="170"><span style="font-size:15px">人员性质</span></th>
       						<th colspan="3"><span style="font-size:15px">退休干部</span></th>
       					</tr>
       					<tr>
       						<th  width="170"><span style="font-size:15px">发放时间</span></th>
       						<th colspan="3">
       							<span style="font-size:15px">
       							<zhg:date times="${entity.month }"/>
       							</span>
       						</th>
       					</tr>
       					<tr>
       						<th  width="170"><span style="font-size:15px">发放人数</span></th>
       						<th width="170">${count}</th>
       						<th>
       							<span style="font-size:15px">发放金额合计</span>
       						</th>
       						<th width="170">${sum}</th>
       					</tr>
       					<tr>
       						<th  width="170"><span style="font-size:15px">备注</span></th>
       						<th colspan="3"></th>
       					</tr>
       				</table>
       				<div>
	       				<div style="margin-right:150px; margin-left:350px; float:left;">
	       					<span style="font-size:15px">经办人:</span>
		             	</div>
		             	<div style="margin-right:150px;float:left;">
	       					<span style="font-size:15px">部门负责人:</span>
		             	</div>
							<div style="float: left;">
								<span style="font-size: 15px">财务负责人:</span>
							</div>
						</div>
       			</div>
	         </form>
	    </div>
    </div>
</body>
	<script type="text/javascript" src="${path }/static/js/plugins/bootstrap-switch/bootstrap-switch.min.js"></script>
	<script type="text/javascript">
	$(function(){
		$('#tabulate').click(function(){
			$('form').submit();
		})
	})
	</script>
</html>