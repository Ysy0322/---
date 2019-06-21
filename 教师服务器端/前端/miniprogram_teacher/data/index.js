    function ifnull(txt) {
        if (txt.length == 0) {
            return true;
        }
        var $reg = /\s+/;
        return $reg.test(txt);
    }

$("#username").blur(function(){
    if(ifnull($(this).val())){
        $("#username_msg").html("用户名不能为空").css("color", "red");
    }else{
        $("#username_msg").html("")
    }
});

//在id为password的元素失去焦点时进行密码的验证
$("#password").blur(function(){
    if(ifnull($(this).val())){
        $("#password_msg").html("密码不能为空").css("color", "red");
    }else{
        $("#password_msg").html("");
    }
});

function checkForm() {
    //验证用户名
    if (ifnull($("#username").val())) {
        $("#username_msg").html("请填写用户名哦！").css("color", "red");
        return false;
    }

    //验证密码
    if (ifnull($("#password").val())) {
        $("#password_msg").html("请填写密码哦！").css("color", "red");
        return false;
    }

    $.ajax({
        type:"POST",
        url: "http://localhost:8080/teacher/login",
        data:JSON.stringify({email:$("#username").val(),password:$("#password").val()}),
        async:false,
        cache:false,
        dataType: 'json',//dataType:"json",使得返回来的数据格式为json 如果不添加该条属性，则返回来的为字符串
        contentType: 'application/json;charset=UTF-8',
        success:function(result){
            // alert(result.email+result.password);
            if(result.status===1){
                console.log('true');
                console.log(result.teacherID);
                $.cookie('teacherID',result.teacherID);
                alert("登陆成功！");

                $("#login_form").attr('action','blog.html');

            }else{
                alert("登陆失败：用户名或密码错误！");
                return false;
            }
        },
            error: function (result) {
                alert("error：请求错误！");
                console.log("error");
            }
    });
    return true;
}