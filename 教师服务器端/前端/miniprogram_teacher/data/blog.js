var list = new Array();

var teacherID = $.cookie('teacherID');
console.log("当前教师id：",teacherID);

function getCourseData() {
    $.ajax({
        type: "get",
        url: "http://localhost:8080/course/findAllCourse",
        dataType: 'json',//dataType:"json",使得返回来的数据格式为json 如果不 添加该条属性，则返回来的为字符串
        success: function (data) {
            list = data;
            courses = data;

        },
        error: function (data) {
            console.log("error");
        }

    });
}

getCourseData();

var courses = new Vue({
    el: '#courses',
    data: {
        courseList: list,
    },
});
