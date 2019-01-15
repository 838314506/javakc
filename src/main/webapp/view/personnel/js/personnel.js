$(function()
{
	$('form:eq(0)').bootstrapValidator({
		//全局校验，默认的bootstrap校验提示为英文
    	message: '这个值是无效的',
    	//校验是显示图标
    	feedbackIcons: {
    		//校验成功显示的图标
            valid: 'glyphicon glyphicon-ok',
            //校验失败显示的图标
            invalid: 'glyphicon glyphicon-remove',
            //校验过程中显示的图标
            validating: 'glyphicon glyphicon-refresh'
        },
      //需要字段名称
        fields: {
        	//每个字段之间要用,分隔最后一个不写
        	pename: {
                validators: {
                    notEmpty: {
                        message: '学生名称是必填项,不能为空!'
                    },
                    stringLength: {
                        min: 2,
                        max: 12,
                        message: '学生名称长度不能低于2不能高于12'
                    }
                }
            },
            idcard: {
	        	validators: {
	        		notEmpty: {
	        			message: '证件内容是必填项,不能为空!'
	        		},
	        		stringLength: {
	        			min: 18,
	        			max: 18,
	        			message: '证件内容必须是18位'
	        		}
//	        		,
//	        		regexp:{
//	        			regexp:正则,
//	        			message:
//	        		}
	        	}
	        },
	        state: {
                validators: {
                   callback: {
                        message: '状态是必选项!',
                        callback: function(value, validator) {
                        	//得到下拉选项中的值
//                        	var options = validator.getFieldElements('元素').val();
                            return value != 0;
                        }
                    }
                }
            },
            grade: {
            	 validators: {
	                   callback: {
	                        message: '职级是必选项!',
	                        callback: function(value, validator) {
	                            return value != 0;
	                        }
	                    }
	            	 }
                
            },
            time: {
            	validators: {
                       notEmpty: {
                     	 message: '起薪时间不能是空!'
                       }
            	}
            },
            compact: {
                validators: {
                   callback: {
                        message: '是否合同制是必选项!',
                        callback: function(value, validator) {
                            return value == 1 || value ==2;
                        }
                    }
                }
            }
        }
	});
});
