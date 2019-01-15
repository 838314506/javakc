$(function()
{
	//设置 菜单状态 选择开关
	//$("[name='menuState']").bootstrapSwitch();
	var index;
	//选择父类触发事件
	$('#updatemodel').click(function()
	{
		
		index = layer.open({
		  type: 1,
		  title: '文件上传',
		  shadeClose: true,
		  shade: 0.8,
		  area: ['50%', '50%'],
		  content: $('#fileUpload')
		}); 
	});
	
	$('#shutdo').click(function(){
		alert(index);
		layer.close(index);
	});
	
});