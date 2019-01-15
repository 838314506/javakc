<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>组织机构树页面</title>
		<%@ include file="../../common/jsp/header.jsp"%>
		<link rel="stylesheet" href="<%=path %>static/js/ztree/zTreeStyle.css">
		<script type="text/javascript" src="<%=path %>static/js/ztree/jquery.ztree.all.js"></script>
		<script type="text/javascript">
		$(function(){
			var treeObj;
			var setting = {
				data: {
					simpleData: {
						enable: true
					}				
				},
				view: {
					//设置查询节点背景颜色
					fontCss: getFontCss
				}
			};
			
			//使用ajax来加载树中的数据
			$.ajax({
				url:root+'/org/query.do',
				type:'post',
				//data:'路径中要带的参数',
				async:true,
				dataType:'json',
				success:function(zNodes){
					treeObj = $.fn.zTree.init($("#treeDemo"),setting,zNodes);
				},
				error:function(XMLHttpRequest,textStatus, errorThrown){
					alert(XMLHttpRequest.status);
				}
			});
			//异步加载树中的数据
// 			$.post(root+'/org/query.do',function(zNodes){
// 				treeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
// 			},'json');
			
			$('#query').click(function(){
				var orgName = $('#orgName').val();
				//按照此方法查询出的结果为一个节点{id:1,name:啦}
				var node = treeObj.getNodeByParam("name",orgName, null);
				node.highlight=true;
				//在对节点进行一个属性的修改后应更新一次树
				treeObj.updateNode(node);
				//设置为被选中
				treeObj.selectNode(node);
			});
			//修改
			$('#updateOrg').click(function(){
				var nodes = treeObj.getSelectedNodes();
				if(nodes.length != 1){
					alert("请选择一条数据！");
					return false;
				}
				var orgId = nodes[0].id;
				window.location="${path}/org/load.do?orgId="+orgId;
			});
			//删除
			$('#deleteOrg').click(function(){
				var nodes = treeObj.getSelectedNodes();
				if(nodes.length != 1){
					alert("请选择一条数据！");
					return false;
				}
				var orgId = nodes[0].id;
				alert(orgId);
				window.location="${path}/org/delete.do?orgId="+orgId;
			});
		})
		//设置被选中字体颜色的方法
		function getFontCss(treeId, treeNode) {
			return (!!treeNode.highlight) ? {color:"#A60000", "font-weight":"bold"} : {color:"#333", "font-weight":"normal"};
		}
		</script>
	</head>
	<body>
		<div class="wrapper wrapper-content animated fadeInRight">
			<div class="ibox float-e-margins">
				<form id="searchForm" action="">
				<div class="col-sm-12">
					<!-- ------------按钮组 start------------ -->
	                <div class="alert alert-success" role="alert">组织机构树信息</div>
	                <div class="col-sm-8">
	                	<div class="btn-group hidden-xs" role="group">
	                	
			               	  <button type="button" class="btn btn-primary" data-toggle="modal" id="query" name="">
		                           <i class="glyphicon glyphicon-plus" aria-hidden="true"></i>查询
		                      </button>
			               	  <button type="button" class="btn btn-primary" data-toggle="modal" id="create" name="myorg/create.jsp">
		                           <i class="glyphicon glyphicon-plus" aria-hidden="true"></i>添加
		                      </button>
	                    
		                      <button type="button" class="btn btn-success" data-toggle="modal" id="updateOrg" name="">
		                          <i class="glyphicon glyphicon-pencil" aria-hidden="true"></i>修改
		                      </button>
	                    
		                      <button type="button" class="btn btn-danger" data-toggle="modal" id="deleteOrg" name="person/delete.do">
		                          <i class="glyphicon glyphicon-trash" aria-hidden="true"></i>删除
		                      </button>
	                    
		                </div>
		                <div class="col-sm-4">
		                	<input class="form-control" id="orgName" name="orgName" value="" type="" placeholder="查询内容 回车搜索"/>
		                </div>
	                </div>
	                 <!-- ------------按钮组 end------------ -->
			     </div>
	                 <div class="col-sm-4">
						<ul id="treeDemo" class="ztree"></ul>
					 </div>
			     </form>
			</div>
		</div>
	</body>
<%-- 	<script type="text/javascript" src="${path }/view/person/js/person-create.js"></script> --%>
</html>