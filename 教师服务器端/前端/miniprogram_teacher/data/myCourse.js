//获取teacherID的方法
var teacherID = $.cookie('teacherID');
console.log("当前教师id：",teacherID);

var courses = new Array();

//获取课程名字和课程价格/图片链接
function getMyCourses() {
    $.ajax({
        type: "post",
        data: JSON.stringify({teacherID: teacherID}),
        url: "http://localhost:8080/course/findCoursesByTeacherID",
        dataType: 'json',//dataType:"json",使得返回来的数据格式为json 如果不 添加该条属性，则返回来的为字符串
        contentType: 'application/json;charset=UTF-8',
        success: function (data) {
            courses = data;
            for (var i = 0; i < data.length; i++) {
                var urlImg = courses[i].courseImageURL;
                courses[i].courseBg = {
                    backgroundImage: 'url('+ courses[i].courseImageURL + ')'
                }
            }
        },
        error: function (data) {
            console.log("error");
        }
    });
}



//开设新课程
function addCourse(courseNameID, instructionID, startTimeID, priceID,introductionID) {
    var courseName = document.getElementById(courseNameID).value;
    var instruction = document.getElementById(instructionID).value;
    var startTime = document.getElementById(startTimeID).value;
    var price = document.getElementById(priceID).value;
    var introduction = document.getElementById(introductionID).value;
    // var teacherID = teacherID;

    console.log("teacherID:",teacherID);

    $.ajax({
        type: "post",
        data: JSON.stringify({courseName:courseName, instruction:instruction,
            startTime:startTime, price:price,introduction:introduction,teacherID:teacherID}),
        url: "http://localhost:8080/course/addCourse",
        dataType: 'json',//dataType:"json",使得返回来的数据格式为json 如果不 添加该条属性，则返回来的为字符串
        contentType: 'application/json;charset=UTF-8',
        success: function (data) {
            alert('开课成功');
            console.log("开课成功");
        },
        error: function (data) {
            alert('开课失败');
            console.log("error");
        }
    });

}


getMyCourses();
console.log(courses);

var myCourse = new Vue({
    el: '#myCourse',
    data: {
        //我的课程列表
        courses: courses,
        // courses: [
        //     {
        //         href: 'blogCourse.html',
        //         image: 'images/img-1.jpg',
        //         course_name: 'Advanced Web',
        //         instruction: '高级web',
        //         note:{
        //             backgroundImage:"url(images/img-1.jpg)"
        //         }
        //     },

        // ]
        //选中的商品列表，用于计算总价
    }
});

