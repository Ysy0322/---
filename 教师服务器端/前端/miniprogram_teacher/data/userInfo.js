
var teacherID = $.cookie('teacherID');
console.log("当前教师id：",teacherID);


var userInfo = new Array();

$.ajax({
    type:"POST",
    url: "http://localhost:8080/teacher/teacherInfo",
    data:JSON.stringify({teacherID:teacherID}),
    async:false,
    cache:false,
    dataType: 'json',//dataType:"json",使得返回来的数据格式为json 如果不添加该条属性，则返回来的为字符串
    contentType: 'application/json;charset=UTF-8',
    success: function (data) {
        userInfo = data;
    },
    error: function (data) {
        console.log("error：请求出错！");
    }

});

var myInfo = new Vue({
    el: '#information',
    data: {
        //我的个人信息
        User: [userInfo]

    }
});

var myInfo = new Vue({
    el: '#modify',
    data: {
        //我的个人信息
        User: [userInfo]
    }
});

function Modify() {
    $.ajax({
        type:"POST",
        url: "http://localhost:8080/teacher/updateTeacher",
        data:JSON.stringify({teacherID:teacherID,techName:$("#name").val(),phone:$("#tel").val(),introduction:$("#message-text").val(),}),
        async:false,
        cache:false,
        dataType: 'json',//dataType:"json",使得返回来的数据格式为json 如果不添加该条属性，则返回来的为字符串
        contentType: 'application/json;charset=UTF-8',
        success: function (data) {
            if(data.status===1){
                console.log("修改成功！");
                alert("个人信息修改成功！");
            }
            else {
                alert("个人信息修改失败！");
            }

        },
        error: function (data) {
            console.log("error：请求出错！");
        }
    });

}



