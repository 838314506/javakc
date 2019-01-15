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
        cname: {
            validators: {
                notEmpty: {
                    message: '公司名称是必填项,不能为空!'
                },
                stringLength: {
                    min: 3,
                    max: 25,
                    message: '公司名称长度不能低于3不能高于25'
                }
            }
        },
        address: {
            validators: {
                notEmpty: {
                    message: '公司地址是必填项,不能为空!'
                },
                stringLength: {
                    min: 10,
                    max: 50,
                    message: '公司地址长度不能低于10不能高于50'
                }
            }
        },
        tel: {
            validators: {
                notEmpty: {
                    message: '公司电话是必填项,不能为空!'
                },
                stringLength: {
                    min: 8,
                    max: 13,
                    message: '公司电话长度不能低于8不能高于13'
                },
                regexp: {
                	regexp: /^0\d{2,3}-?\d{7,8}$/,
        			message: '请输入有效固话号码!'
        		}
            }
        },
        phone: {
            validators: {
                notEmpty: {
                    message: '公司手机是必填项,不能为空!'
                },
                regexp: {
                	regexp: /^1[3|4|5|7|8|9]\d{9}$/,
        			message: '请输入有效手机号码!'
        		}
            }
        },
        email: {
            validators: {
                notEmpty: {
                    message: '公司邮箱是必填项,不能为空!'
                },
                emailAddress: {
        			message: '请输入有效邮箱地址!'
        		}
            }
        }
    }
});