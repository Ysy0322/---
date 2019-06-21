use pj;

DROP TABLE IF EXISTS HomeworkToken;
DROP TABLE IF EXISTS Message;
DROP TABLE IF EXISTS CourseToken;
DROP TABLE IF EXISTS CollectCourse;
DROP TABLE IF EXISTS Chapter;
DROP TABLE IF EXISTS Homework;
DROP TABLE IF EXISTS Comments;
DROP TABLE IF EXISTS Course;
DROP TABLE IF EXISTS Student;
DROP TABLE IF EXISTS Teacher;


CREATE TABLE IF NOT EXISTS Teacher (
  teacherID INT(11) NOT NULL AUTO_INCREMENT,
  techName NVARCHAR(50) NOT NULL,
  password NVARCHAR(50) NOT NULL,
  email NVARCHAR(100) NOT NULL,
  phone NVARCHAR(20) DEFAULT NULL,
  introduction VARCHAR(10000),
  PRIMARY KEY (teacherID)
);

CREATE TABLE IF NOT EXISTS Course (
  courseID INT(11) NOT NULL AUTO_INCREMENT,  
  courseName NVARCHAR(100) NOT NULL,  
  instruction NVARCHAR(1000) DEFAULT NULL,
  courseImageURL NVARCHAR(100) DEFAULT NULL,
  introduction NVARCHAR(1000) DEFAULT NULL,
  price INT(4) NOT NULL,
  startTime NVARCHAR(500),
  teacherID INT(11),  
  PRIMARY KEY (courseID)
);

CREATE TABLE IF NOT EXISTS Student (
  studentID INT(11),
  studentName NVARCHAR(50) NOT NULL,
  studentNickName NVARCHAR(50),
  gender boolean NOT NULL,
  email NVARCHAR(100)DEFAULT NULL,
  avatarURL NVARCHAR(1000) DEFAULT NULL,  
  PRIMARY KEY (StudentID)
);

CREATE TABLE IF NOT EXISTS CourseToken (
  courseID INT(11) NOT NULL,  
  studentID INT(11) NOT NULL,  
  teacherID INT(11) NOT NULL
);

CREATE TABLE IF NOT EXISTS CollectCourse (
  courseID INT(11) NOT NULL,  
  studentID INT(11) NOT NULL
);


CREATE TABLE IF NOT EXISTS Chapter (
  chapterID INT(11) NOT NULL AUTO_INCREMENT,  
  chapterText NVARCHAR(10000),
  courseID INT(11) NOT NULL,  
  PRIMARY KEY (chapterID),
  FOREIGN KEY (courseID) references Course(courseID)
);
 
CREATE TABLE IF NOT EXISTS Homework (
  homeworkID INT(11) NOT NULL AUTO_INCREMENT,
  homeworkName NVARCHAR(100) NOT NULL,  
  courseID INT(11) NOT NULL,  
  details NVARCHAR(500) DEFAULT NULL,
  PRIMARY KEY (homeworkID),
  FOREIGN KEY(courseID)references Course(courseID)
);

CREATE TABLE IF NOT EXISTS Comments (
  commentID INT(11) NOT NULL AUTO_INCREMENT,
  courseID INT(11) NOT NULL,  
  studentID INT(11) NOT NULL,
  remark NVARCHAR(500) NOT NULL,
  PRIMARY KEY (commentID),
  FOREIGN KEY(courseID)references Course(courseID)
);

CREATE TABLE IF NOT EXISTS Message (
  messageID INT(11) NOT NULL AUTO_INCREMENT,
  sender boolean,
  teacherID INT(11),  
  studentID INT(11),
  content NVARCHAR(500) NOT NULL,
  sendTime NVARCHAR(500),
  PRIMARY KEY (messageID),
  FOREIGN KEY (studentID) references Student(studentID),
  FOREIGN KEY (teacherID) references Teacher(teacherID)
  );

CREATE TABLE IF NOT EXISTS HomeworkToken (
  homeworkID INT(11) NOT NULL,  
  studentID INT(11) NOT NULL,  
  done boolean
  );
  
insert Teacher value("1","闫老师","123456","16302010076@fudan.edu.cn","18700010002","专注于高级web研究");
insert Teacher value("2","董老师","123456","16302010079@fudan.edu.cn","18700020003","实验室研究方向：算法结构");
insert Teacher value("3","符老师","123456","16302010080@fudan.edu.cn","18700030004","当前研究方向：神经网络");
insert Teacher value("4","卢老师","123456","16302010075@fudan.edu.cn","18700040005","专注于机器学习研究");
  

insert Course value("1","高级web","Advanced web","images/img-1.jpg","适用人群:希望学习高级web的学员，需要基础web基础",99,"2019-3-10","1");
insert Course value("2","计算机系统基础","ICS","images/img-1.jpg","适用人群:希望学习计算机系统的学员，需要基础计算机知识",399,"2019-3-10","1");
insert Course value("3","数据库设计","Database Design","images/img-1.jpg","适用人群:希望学习数据库设计的学员，不需要基础",299,"2019-3-10","2");
insert Course value("4","数据结构","123456","images/img-1.jpg","适用人群:希望学习数据结构的学员，需要基本编程语言基础",199,"2019-3-10","3");


insert Student value("1","小闫","yan","0","16302010076@fudan.edu.cn","url");
insert Student value("2","小董","dong","0","16302010079@fudan.edu.cn","url");
insert Student value("3","小符","fu","0","16302010080@fudan.edu.cn","url");
insert Student value("4","小卢","lu","0","16302010075@fudan.edu.cn","url");

insert CourseToken value("1","1","1");
insert CourseToken value("1","2","1");
insert CourseToken value("1","3","1");
insert CourseToken value("1","4","1");
insert CourseToken value("2","1","2");
insert CourseToken value("2","2","2");
insert CourseToken value("3","3","3");
insert CourseToken value("4","3","4");
insert CourseToken value("4","4","4");
  
insert Message value("1","0","1","1","老师好，请问明天上课的内容是什么呢？","2019/05/24");
insert Message value("2","1","1","1","明天上课去机房上机实验。","2019/05/25");
insert Message value("3","0","1","2","老师好，本周作业的ddl是什么时候呢？","2019/05/27");
insert Message value("4","0","2","2","老师好，请问明天下午老师有空解答问题吗？","2019/05/05");
insert Message value("5","1","3","3","请注意查收本周作业。","2019/06/01");

insert Homework value("1","高级web一","1","给出实验报告");
insert Homework value("2","计算机系统基础作业一","2","给出实验报告");
insert Homework value("3","数据库作业一","3","给出实验报告");
insert Homework value("4","算法作业一","4","给出实验报告");
insert Homework value("5","高级web二","1","给出实验报告");

insert HomeworkToken value("1","1","1");
insert HomeworkToken value("2","2","0");
insert HomeworkToken value("3","3","1");
insert HomeworkToken value("4","4","0");

insert Chapter value("1","第一章：HTML","1");
insert Chapter value("2","第一章：MYSQL","2");
insert Chapter value("3","第一章：二叉树","3");
insert Chapter value("4","第一章：反码","4");

insert Comments value("1","1","1","上课效果较好");
insert Comments value("2","1","2","老师很nice");
insert Comments value("3","2","2","我觉得还行");
insert Comments value("4","3","3","我觉得不错");
insert Comments value("5","4","4","学到很多东西");


