layui.use(['form','notice'], function(){
    let form = layui.form;
    let notice = layui.notice;

    notice.options={
        positionClass:"toast-top-center",//弹出的位置,
    };

    // 表单验证
    form.verify({
        username: function (value,item) {
            if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
                return '用户名不能有特殊字符';
            }
            if(/(^\_)|(\__)|(\_+$)/.test(value)){
                return '用户名首尾不能出现下划线\'_\'';
            }
            if(/^\d+\d+\d$/.test(value)){
                return '用户名不能全为数字';
            }
        },
        password: function (value,item) {
            if(!new RegExp("^[\\S]{6,12}$").test(value)){
                return "密码必须6到12位，且不能出现空格";
            }
        }
    });



    form.on('submit(login)', function(data){
        $.ajax({
            url: CONTEXT_PATH + "/login",
            type: 'post',
            data: data.field,
            success:function (res) {
                console.info(res);
                if(res && parseInt(res.code) === 200){
                   notice.success("登录成功");
                   location.href=CONTEXT_PATH + '/index'
                }else {
                    notice.error(res.msg);
                }
            }
        });
        return false;
    });
});