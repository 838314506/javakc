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
            testName: {
                validators: {
                    notEmpty: {
                        message: '测试名称是必填项,不能为空!'
                    },
                    stringLength: {
                        min: 3,
                        max: 25,
                        message: '测试名称长度不能低于3不能高于12'
                    }
                }
            },
            testLevel: {
            	validators: {
                    callback: {
                        message: '请选择测试类别!',
                        callback: function(value, validator) {
                            // Get the selected options
                            var options = validator.getFieldElements('testLevel').val();
                            return value != 0;
                        }
                    }
                }
            },
            testPhoto: {
                validators: {
                    notEmpty: {
                        message: '测试文件是必填项,不能为空!'
                    },
                    file: {
                        extension: 'pdf',
                        type: 'application/pdf',
                        message: '只能上传PDF文件.'
                    }
                }
            }
        }
    });

	
	//初始化fileinput控件（第一次初始化）
    $('#inputfile').fileinput({
        language: 'zh', //设置语言
        uploadUrl: root+'test/upload.do', //上传的地址
        allowedFileExtensions : ['jpg', 'png','gif'],//接收的文件后缀,
        maxFileCount: 100,
        enctype: 'multipart/form-data',
        showUpload: true, //是否显示上传按钮
        showCaption: false,//是否显示标题
        browseClass: "btn btn-primary", //按钮样式             
        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>", 
        msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
    });
});