<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>机构树添加页面</title>
		<%@ include file="../../common/jsp/header.jsp"%>
		<link rel="stylesheet" href="<%=path %>static/js/ztree/zTreeStyle.css">
		<script type="text/javascript" src="<%=path %>static/js/ztree/jquery.ztree.all.js"></script>
		<script type="text/javascript">
		$(function(){
			var setting = {
					view: {
						dblClickExpand: false
					},
					data: {
						simpleData: {
							enable: true
						}
					},
					callback: {
						onClick: onClick
					}
				};
			
			var treeObj;
			
			//异步加载树中的数据
			$.post(root+'/org/query.do',function(zNodes){
				treeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
			},'json');
			
			function onClick(e, treeId, treeNode) {
				var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
				nodes = zTree.getSelectedNodes(),
				v = "";
				id = "";
				nodes.sort(function compare(a,b){return a.id-b.id;});
				for (var i=0, l=nodes.length; i<l; i++) {
					v += nodes[i].name + ",";
					id += nodes[i].id + ",";
				}
				if (v.length > 0 ) v = v.substring(0, v.length-1);
				if (id.length > 0 ) id = id.substring(0, id.length-1);
				var cityObj = $("#orgSel");
				var orgParentId = $("#orgParentId");
				cityObj.attr("value", v);
				orgParentId.attr("value", id);
			};
		
			
		})
			function showMenu() {
				var cityObj = $("#orgSel");
				var cityOffset = $("#orgSel").offset();
				$("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");

				$("body").bind("mousedown", onBodyDown);
			}
			function hideMenu() {
				$("#menuContent").fadeOut("fast");
				$("body").unbind("mousedown", onBodyDown);
			}
			function onBodyDown(event) {
				if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
					hideMenu();
				}
			}
		</script>
	</head>
	<body>
		<div class="wrapper wrapper-content animated fadeInRight">
			<div>
				<div class="col-sm-4"><input type="button" value="返回上一页" class="btn btn-success" onclick="javascript:history.back();"/></div>
			</div>
			<div class="ibox float-e-margins">
				<form action="${path }/org/create.do" method="post" class="form-horizontal" role="form">
				<input type="hidden" name="orgParentId" id="orgParentId"/>
                    <fieldset>
						<legend>机构树添加表单</legend>
                        <div class="form-group">
                           <label for="disabledSelect" class="col-sm-2 control-label">
                           <a id="menuBtn" href="#" onclick="showMenu(); return false;">选择</a>
                           </label>
                           <div class="col-sm-4">
                              <input id="orgSel" type="text" name="" class="form-control" readonly/>
                           </div>
                        </div>
                        <div class="form-group">
                        	<label for="disabledSelect" class="col-sm-2 control-label"></label>
	                        <div class="col-sm-4">
	                            <div id="menuContent" class="menuContent" style="display:none;">
	                       		<ul id="treeDemo" class="ztree"></ul>
	                        </div>
                           </div>
                        </div>
                        <div class="form-group">
                           <label for="disabledSelect" class="col-sm-2 control-label">名称</label>
                           <div class="col-sm-4">
                              <input type="text" name="orgName" class="form-control"/>
                           </div>
                        </div>
                        <div class="form-group">
							<label for="disabledSelect" class="col-sm-2 control-label">是否展开</label>
							<div class="col-sm-2">
								关闭<input type="checkbox" name="orgOpen" value="0"/>
							</div>
							<div class="col-sm-2">
								展开<input type="checkbox" name="orgOpen" value="1"/>
							</div>
                        </div>
                        <div class="form-group">
							<label for="disabledSelect" class="col-sm-2 control-label">节点等级</label>
							<div class="col-sm-4">
								<input type="text" name="orgLevel" class="form-control"/>
							</div>
                        </div>
                        <div class="form-group">
							<label for="disabledSelect" class="col-sm-2 control-label">节点排序</label>
							<div class="col-sm-4">
								<input type="text" name="orgOrder" class="form-control"/>
							</div>
                        </div>
                    </fieldset>
                    <fieldset>
                        <div class="form-group">
                        	<label class="col-sm-2 control-label" for="ds_host"></label>
                           <div class="col-sm-4">
                              <input type="submit" value="提交" class="btn btn-primary"/>
                              <input type="reset" value="重置" class="btn btn-danger"/>
                           </div>
                        </div>
                    </fieldset>
                </form>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="./js/person.js"></script>
</html>