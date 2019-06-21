package springboot.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;
import springboot.domain.*;
import springboot.request.*;
import springboot.response.MessageResponse;
import springboot.response.RegisterResponse;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/course")
@CrossOrigin
public class CourseController {

    //获取所有课程信息
    @RequestMapping(value = "/findAllCourse", method = RequestMethod.GET)
    public @ResponseBody
    Object listAll() throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        List<Course> courses = sqlSession.selectList("resources.mapper.CourseMapper.findAllCourse");
        if (courses.size() != 0) {
            sqlSession.close();
            return courses;
        } else {
            sqlSession.close();
            return new RegisterResponse("暂无任何课程信息");
        }
    }

    //根据id获取课程信息
    @RequestMapping(value = "/findCourseByID", method = RequestMethod.POST)
    public @ResponseBody
    Object findCourseByID(@RequestBody CourseRequest request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        Course course = sqlSession.selectOne("resources.mapper.CourseMapper.findCourseByID", request.getCourseID());
        if (course != null) {
            sqlSession.close();
            return course;
        } else {
            sqlSession.close();
            return new RegisterResponse("找不到具体信息~"); // use your generated token here.
        }
    }

    //根据课程id获取教师名字
    @RequestMapping(value = "/findTeacherNameByCourseID", method = RequestMethod.POST)
    public @ResponseBody
    Object findTeacherNameByCourseID(@RequestBody CourseRequest request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        Teacher teacher = sqlSession.selectOne("resources.mapper.CourseMapper.findTeacherNameByCourseID", request.getCourseID());
        if (teacher != null) {
            sqlSession.close();
            return teacher;
        } else {
            sqlSession.close();
            return new RegisterResponse("找不到教师名字~"); // use your generated token here.
        }
    }

    //根据课程id获取章节名称
    @RequestMapping(value = "/findChapterByCourseID", method = RequestMethod.POST)
    public @ResponseBody
    Object findChapterByCourseID(@RequestBody CourseRequest request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        Chapter chapter = sqlSession.selectOne("resources.mapper.CourseMapper.findChapterByCourseID", request.getCourseID());
        if (chapter != null) {
            sqlSession.close();
            return chapter;
        } else {
            sqlSession.close();
            return new RegisterResponse("找不到章节名字~"); // use your generated token here.
        }
    }

    //根据课程id获取评论
    @RequestMapping(value = "/findCommentByCourseID", method = RequestMethod.POST)
    public @ResponseBody
    Object findCommentByCourseID(@RequestBody CourseRequest request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        List<Comments> comments = sqlSession.selectList("resources.mapper.CourseMapper.findCommentByCourseID", request.getCourseID());
        if (comments != null) {
            sqlSession.close();
            return comments;
        } else {
            sqlSession.close();
            return new RegisterResponse("暂时没有人评论哦"); // use your generated token here.
        }
    }


    //根据课程id获取学生名单
    @RequestMapping(value = "/findStudentsByCourseID", method = RequestMethod.POST)
    public @ResponseBody
    Object findStudentsByCourseID(@RequestBody CourseRequest request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        List<Student> students = sqlSession.selectList("resources.mapper.CourseMapper.findStudentsByCourseID", request.getCourseID());
        if (students != null) {
            sqlSession.close();
            return students;
        } else {
            sqlSession.close();
            return new RegisterResponse("没有同学选这门课哦"); // use your generated token here.
        }
    }

    //根据课程id获取作业完成情况
    @RequestMapping(value = "/findHomeworkByCourseID", method = RequestMethod.POST)
    public @ResponseBody
    Object findHomeworkByCourseID(@RequestBody CourseRequest request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        List<Homework> homeworks = sqlSession.selectList("resources.mapper.CourseMapper.findHomeworkByCourseID", request.getCourseID());
        if (homeworks != null) {
            sqlSession.close();
            return homeworks;
        } else {
            sqlSession.close();
            return new RegisterResponse("尚未布置作业"); // use your generated token here.
        }
    }

    //根据作业id获取作业完成情况
    @RequestMapping(value = "/findHomeworkTokenByID", method = RequestMethod.POST)
    public @ResponseBody
    Object findHomeworkTokenByID(@RequestBody HomeworkRequest request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        List<HomeworkToken> homeworkTokens = sqlSession.selectList("resources.mapper.CourseMapper.findHomeworkTokenByID", request);
        if (homeworkTokens != null) {
            sqlSession.close();
            return homeworkTokens;
        } else {
            sqlSession.close();
            return new RegisterResponse("暂无完成情况~"); // use your generated token here.
        }
    }

    //根据学生id获取学生姓名
    @RequestMapping(value = "/findStudentNameByCourseID", method = RequestMethod.POST)
    public @ResponseBody
    Object findStudentNameByCourseID(@RequestBody StudentRequest request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        Student student = sqlSession.selectOne("resources.mapper.CourseMapper.findStudentNameByCourseID", request);
        if (student != null) {
            sqlSession.close();
            return student;
        } else {
            sqlSession.close();
            return new RegisterResponse("找不到该学生"); // use your generated token here.
        }
    }

    //根据教师id获取开课列表
    @RequestMapping(value = "/findCoursesByTeacherID", method = RequestMethod.POST)
    public @ResponseBody
    Object findCoursesByTeacherID(@RequestBody TeacherRequest request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        List<Course> courses = sqlSession.selectList("resources.mapper.CourseMapper.findCoursesByTeacherID", request);
        if (courses != null) {
            sqlSession.close();
            return courses;
        } else {
            sqlSession.close();
            return new RegisterResponse("未开课"); // use your generated token here.
        }
    }


    //UPDATE
    //根据课程id更新课程介绍
    @RequestMapping(value = "/updateIntroduction", method = RequestMethod.POST)
    public @ResponseBody
    Object updateIntroduction(@RequestBody CourseRequest request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        sqlSession.update("resources.mapper.CourseMapper.updateIntroduction", new Course(request.getCourseID(), request.getIntroduction()));
        sqlSession.commit();
        sqlSession.close();
        return new RegisterResponse("更新成功");
    }

    //根据课程id更新章节
    @RequestMapping(value = "/updateChapter", method = RequestMethod.POST)
    public @ResponseBody
    Object updateChapter(@RequestBody ChapterRequest request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();

        Chapter chapters = sqlSession.selectOne("resources.mapper.CourseMapper.findChaptersByCourseID", request);
        if (chapters == null){
            sqlSession.insert("resources.mapper.CourseMapper.addChapter", request);
            sqlSession.commit();
            sqlSession.close();
            return new MessageResponse(1,"插入成功");
        }
        else {
            sqlSession.update("resources.mapper.CourseMapper.updateChapter", request);
            sqlSession.commit();
            sqlSession.close();
            return new MessageResponse(0,"更新成功");
        }


    }


    //INSERT
    //开设新课程
    @RequestMapping(value = "/addCourse", method = RequestMethod.POST)
    public @ResponseBody
    Object addCourse(@RequestBody CourseRequest courRequest) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        sqlSession.insert("resources.mapper.CourseMapper.addCourse", courRequest);
        sqlSession.commit();
        sqlSession.close();
        return new RegisterResponse("开课成功~"); // use your generated token here.
    }


    @RequestMapping(value = "/addHomework", method = RequestMethod.POST)
    //布置新作业
    public @ResponseBody
    Object addHomework(@RequestBody HomeworkRequest request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        sqlSession.insert("resources.mapper.CourseMapper.addHomework", request);
        sqlSession.commit();
        sqlSession.close();
        return new RegisterResponse("布置完成~"); // use your generated token here.
    }
}
