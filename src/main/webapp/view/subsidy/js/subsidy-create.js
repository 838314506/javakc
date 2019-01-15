$(function()
{
	//设置 菜单状态 选择开关
	//$("[name='menuState']").bootstrapSwitch();
	var index;
	//选择父类触发事件
	$('#pname').click(function()
	{
		var type = $('#type').val();
		index = layer.open({
		  type: 2,
		  title: '选择人员',
		  shadeClose: true,
		  shade: 0.8,
		  area: ['65%', '65%'],
		  content: root+'/subsidy/createsubsidy.do?type='+type
		}); 
	});
	

});