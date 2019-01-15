$(function()
{
	$('form:eq(0)').bootstrapValidator({
    	message: '这个值是无效的',
    	//校验是显示图标
    	feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        //需要校验的name名称
        fields: {
            sname: {
                validators: {
                    notEmpty: {
                        message: '学生名称是必填项,不能为空!'
                    },
                    stringLength: {
                        min: 3,
                        max: 10,
                        message: '学生名称长度不能低于3不能高于10'
                    }
                }
            },
            sage: {
                validators: {
                    notEmpty: {
                        message: '学生年龄是必填项,不能为空!'
                    },
                   callback: {
                        message: '年龄不能超过指定',
                        callback: function(value, validator) {
                            // Get the selected options
                        	if( parseInt(value,10) > 200 ) 
                    		{
                        		return false;
                    		}
                            return true;
                        }
                    }
                }
            }
        }
    });

});