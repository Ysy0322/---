var courseDetail = new Object();
var teacherName = new Object();
var courseChapter = new Object();
var courseComment = new Object();
var chapter = new Array();
var comment = new Array();
var students = new Array();
var homework = new Array();
var homeworkToken = new Array();

//从cookie中获取当前教师id
var teacherID = $.cookie('teacherID');
alert("当前教师id："+ teacherID);

//从url里获取当前课程id
function getCourseID() {
    var url = decodeURI(window.location.href);
    var argsIndex = url.split("?courseID=");
    var arg = argsIndex[1];
    console.log("urlllll",url);
    console.log("arggggg",arg);
    return arg;
}
var courseID = getCourseID();

//获取课程名字和课程价格/图片链接
function getNameAndPrice() {
    $.ajax({
        type: "post",
        data: JSON.stringify({courseID: courseID}),
        url: "http://localhost:8080/course/findCourseByID",
        dataType: 'json',//dataType:"json",使得返回来的数据格式为json 如果不 添加该条属性，则返回来的为字符串
        contentType: 'application/json;charset=UTF-8',
        success: function (data) {
            courseDetail = data;

        },
        error: function (data) {
            console.log("error");
        }

    });
}

//根据课程id查找教师
function getTeacher() {
    $.ajax({
        type: "post",
        data: JSON.stringify({courseID: courseID}),
        url: "http://localhost:8080/course/findTeacherNameByCourseID",
        dataType: 'json',//dataType:"json",使得返回来的数据格式为json 如果不 添加该条属性，则返回来的为字符串
        contentType: 'application/json;charset=UTF-8',
        success: function (data) {
            teacherName = data;
        },
        error: function (data) {
            console.log("error");
        }

    });
}

//根据课程id查找章节
function getChapter() {
    $.ajax({
        type: "post",
        data: JSON.stringify({courseID: courseID}),
        url: "http://localhost:8080/course/findChapterByCourseID",
        dataType: 'json',//dataType:"json",使得返回来的数据格式为json 如果不 添加该条属性，则返回来的为字符串
        contentType: 'application/json;charset=UTF-8',
        success: function (data) {
            chapter = data;
        },
        error: function (data) {
            console.log("error");
        }

    });
}

//根据课程id查找章节
function getComment() {
    $.ajax({
        type: "post",
        data: JSON.stringify({courseID: courseID}),
        url: "http://localhost:8080/course/findCommentByCourseID",
        dataType: 'json',//dataType:"json",使得返回来的数据格式为json 如果不 添加该条属性，则返回来的为字符串
        contentType: 'application/json;charset=UTF-8',
        success: function (data) {
            comment = data;
        },
        error: function (data) {
            console.log("error");
        }

    });
}

//根据课程id查找学生名单
function getStudents() {
    $.ajax({
        type: "post",
        data: JSON.stringify({courseID: courseID}),
        url: "http://localhost:8080/course/findStudentsByCourseID",
        dataType: 'json',//dataType:"json",使得返回来的数据格式为json 如果不 添加该条属性，则返回来的为字符串
        contentType: 'application/json;charset=UTF-8',
        success: function (data) {
            students = data;
        },
        error: function (data) {
            console.log("error");
        }

    });
}

//根据作业id查询学生名单和完成情况
function getHomeworkToken(homeworkID) {
    $.ajax({
        type: "post",
        data: JSON.stringify({homeworkID: homeworkID}),
        url: "http://localhost:8080/course/findHomeworkTokenByID",
        dataType: 'json',//dataType:"json",使得返回来的数据格式为json 如果不 添加该条属性，则返回来的为字符串
        contentType: 'application/json;charset=UTF-8',
        success: function (data) {
            homeworkToken = data;
        },
        error: function (data) {
            console.log("error");
        }

    });
}

//根据课程id查找作业列表
function getHomework() {
    $.ajax({
        type: "post",
        data: JSON.stringify({courseID: courseID}),
        url: "http://localhost:8080/course/findHomeworkByCourseID",
        dataType: 'json',//dataType:"json",使得返回来的数据格式为json 如果不 添加该条属性，则返回来的为字符串
        contentType: 'application/json;charset=UTF-8',
        success: function (data) {
            homework = data;
            for (var i = 0; i < data.length; i++) {
                getHomeworkToken(data[i].homeworkID);
                homework[i].studentList = homeworkToken;
            }
            console.log(homework);
        },
        error: function (data) {
            console.log("error");
        }

    });
}

//更新课程介绍
function updateIntroduction(id) {
    var introduction = document.getElementById(id).innerHTML;
    console.log(introduction);
    $.ajax({
        type: "post",
        data: JSON.stringify({courseID: courseID, introduction: introduction}),
        url: "http://localhost:8080/course/updateIntroduction",
        dataType: 'json',//dataType:"json",使得返回来的数据格式为json 如果不 添加该条属性，则返回来的为字符串
        contentType: 'application/json;charset=UTF-8',
        success: function (data) {
            alert("修改成功");
            //重新加载页面
            getNameAndPrice();
        },
        error: function (data) {
            alert("修改失败");
        }
    });
}

//更新章节
function updateChapter(id) {
    var newChapter = document.getElementById(id).innerHTML;
    console.log(newChapter);
    $.ajax({
        type: "post",
        data: JSON.stringify({courseID:courseID, chapterText:newChapter}),
        url: "http://localhost:8080/course/updateChapter",
        dataType: 'json',//dataType:"json",使得返回来的数据格式为json 如果不 添加该条属性，则返回来的为字符串
        contentType: 'application/json;charset=UTF-8',
        success: function (data) {
            alert("修改成功");
            //重新加载页面
        },
        error: function (data) {
            alert("修改失败");
        }
    });
}

//布置作业
function addHomework(homeworkNameID,detailsID) {

    var homeworkName = document.getElementById(homeworkNameID).value;
    var details = document.getElementById(detailsID).value;

    console.log(homeworkName);

    $.ajax({
        type: "post",
        data: JSON.stringify({courseID:courseID, homeworkName:homeworkName,details:details}),
        url: "http://localhost:8080/course/addHomework",
        dataType: 'json',//dataType:"json",使得返回来的数据格式为json 如果不 添加该条属性，则返回来的为字符串
        contentType: 'application/json;charset=UTF-8',
        success: function (data) {
            alert("作业布置完成QVQ");
            //重新加载页面
        },
        error: function (data) {
            alert("作业布置失败TAT");
        }
    });
}


//方法调用
getNameAndPrice();
getTeacher();
getChapter();
getComment();
getStudents();
getHomework();

alert("teacherName.teacherID"+teacherName.teacherID);
alert("teacherID"+teacherID);


var coursesDetail = new Vue({
    el: '#coursesDetail',
    data: {
        /**
         * 课程详情
         */

        //课程名字和价格
        courseDetail: courseDetail,
        teacherName: teacherName,
        courseChapter: courseChapter,
        courseComment: courseComment,
        chapter: chapter,
        comment: comment,
        students: students,
        homework: homework,
        homeworkToken: getHomeworkToken(),
        isMine: teacherName.teacherID==teacherID,

        //学生的消息
        message: [
            {
                studentID: 0,
                studentName: '小明',
                studentPhoto: 'images/img-1.jpg',
                messageContent: '老师我今天请假',
                messageTime: '2018-2-1'

            },
            {
                studentID: 1,
                studentName: '小红',
                studentPhoto: 'images/img-2.jpg',
                messageContent: '老师我今天请假',
                messageTime: '2018-2-1'
            },
            {
                studentID: 2,
                studentName: '小蓝',
                studentPhoto: 'images/img-3.jpg',
                messageContent: '老师我今天请假',
                messageTime: '2018-2-1'
            }
        ],

    }

});



