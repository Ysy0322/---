 function ifnull(txt) {
        if (txt.length == 0) {
            return true;
        }
        var $reg = /\s+/;
        return $reg.test(txt);
    }

//在id为email的元素失去焦点时进行邮箱的验证
$("#email").blur(function () {
    if (ifnull($(this).val())) {
        $("#email_msg").html("邮箱不能为空").css("color", "red");
    } else {
        var $reg = /^[a-zA-Z1-9]\w{1,}@[a-zA-Z1-9]{2,}(\.(edu|com|cn|net)){1,2}$/;
        if (!$reg.test($("#email").val())) {
            $("#email_msg").html("邮箱格式错误！").css("color", "red");
        } else {
            $("#email_msg").html("√");
            $("#email_msg").css("color", "green");
        }
    }
});
//在id为username的元素失去焦点时进行用户名的验证
$("#username").blur(function () {
    if (ifnull($(this).val())) {
        $("#username_msg").html("用户名不能为空").css("color", "red");
    } else {
        var $reg = /^\w{3,}$/;
        if (!$reg.test($("#username").val())) {
            $("#username_msg").html("用户名至少3位以上字符或数字").css("color", "red");
        } else {
            $("#username_msg").html("√").css("color", "green");
        }
    }
});
//在id为password的元素失去焦点时进行密码的验证
$("#password").blur(function () {
    if (ifnull($(this).val())) {
        $("#password_msg").html("用户名不能为空").css("color", "red");
    } else {
        var $reg = /^\w{6,}$/;
        if (!$reg.test($("#password").val())) {
            $("#password_msg").html("密码至少要6位，至多12位哦").css("color", "red");
        } else {
            $("#password_msg").html("√").css("color", "green");
        }
    }
});

//在id为repassword的元素失去焦点时进行密码的验证
$("#password_confirm").blur(function () {
    if (ifnull($(this).val())) {
        $("#password_confirm_msg").html("请确认密码").css("color", "red");
    } else {
        if ($("#password").val() != $("#password_confirm").val()) {
            $("#password_confirm_msg").html("两次密码不一致").css("color", "red");
        } else {
            $("#password_confirm_msg").html("√").css("color", "green");
        }
    }
});

//验证表单
function checkForm() {
    //验证邮箱
    if (ifnull($("#email").val())) {
        $("#email_msg").html("邮箱不能为空！").css("color", "red");
        return false;
    } else {
        var $reg = /^[a-zA-Z1-9]\w{1,}@[a-zA-Z1-9]{2,}(\.(edu|com|cn|net)){1,2}$/;
        if (!$reg.test($("#email").val())) {
            $("#email_msg").html("邮箱格式错误！").css("color", "red");
            return false;
        }
    }
    //验证用户名
    if (ifnull($("#username").val())) {
        $("#username_msg").html("用户名不能为空！").css("color", "red");
        return false;
    } else {
        var $reg = /^\w{3,}$/;
        if (!$reg.test($("#username").val())) {
            $("#username_msg").html("用户名至少3位以上的字符或者数字哦！").css("color", "red");
            return false;
        }
    }
    //验证密码
    if (ifnull($("#password").val())) {
        $("#password_msg").html("密码不能为空！").css("color", "red");
        return false;
    } else {
        var $reg = /^\w{6,}$/;
        if (!$reg.test($("#password").val())) {
            $("#password_msg").html("密码至少6位,至多12位！").css("color", "red");
            return false;
        }
    }
    //确认密码是否为空
    if (ifnull($("#password_confirm").val())) {
        $("#password_confirm_msg").html("请确认密码").css("color", "red");
        return false;
    }

    //验证两次密码是否一致
    if ($("#password").val() !== $("#password_confirm").val()) {
        $("#password_confirm_msg").html("两次密码不一致").css("color", "red");
        return false;
    }

    $.ajax({
        type:"POST",
        url: "http://localhost:8080/teacher/register",
        data:JSON.stringify({techName:$("#username").val(),password:$("#password").val(),email:$("#email").val(),phone: ''}),
        async:false,
        cache:false,
        dataType: 'json',//dataType:"json",使得返回来的数据格式为json 如果不添加该条属性，则返回来的为字符串
        contentType: 'application/json;charset=UTF-8',
        success:function(result){
            if(result.status===1){
                console.log('true');
                alert("注册成功，去登陆吧！");
                $("#login_form").attr('action','index.html');
            }else{
                alert("邮箱已存在！请重新选择邮箱！");
                return false;
            }
        },
        error: function (result) {
            alert("error:请求错误！");
            console.log("error");
        }
    });
    return true;
}

//验证数据库中的用户名和密码
function checkPassword(){
    //Connection coon = ;
    //to do
}

