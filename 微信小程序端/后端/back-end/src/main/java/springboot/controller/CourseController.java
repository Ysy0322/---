package springboot.controller;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;
import springboot.domain.Course;
import springboot.domain.Student;
import springboot.request.SqlSessionLoader;
import springboot.response.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/home")
//首页课程
public class CourseController {

    @RequestMapping(value = "/listAllCourse", method = RequestMethod.GET)
    public @ResponseBody
    Object listAllCourse() throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        List<CourseResponse> courses = sqlSession.selectList("resources.mapper.StudentMapper.listAllCourse");
        if (courses != null) {
            sqlSession.close();
            return courses;
        } else {
            sqlSession.close();
            return new ErrorResponse("没有课程信息"); // use your generated token here.
        }
    }
    //查询收藏的课程列表
    @RequestMapping(value = "/listCollectCourse", method = RequestMethod.POST)
    public @ResponseBody
    Object listCollectCourse(@RequestBody Student request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        Student student=sqlSession.selectOne("resources.mapper.StudentMapper.findStuByNickName", request.getStudentNickName());
        if(student==null)return new ErrorResponse("没有该学生");
        List<Course> courses = sqlSession.selectList("resources.mapper.StudentMapper.listCollectCourse",
                student.getStudentID());//request.getStudentNickName()改成student.getStudentID()
//        return new ErrorResponse("test"+request.getStudentID());
        if (courses != null) {
            sqlSession.close();
            return courses;
        } else {
            sqlSession.close();
            return new ErrorResponse("没有收藏的课程信息"+request.getStudentID()); // use your generated token here.
        }
    }
    //添加课程
    @RequestMapping(value = "/addCourse", method = RequestMethod.POST)
    public @ResponseBody Object addCourse(@RequestBody Course request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        Course course = sqlSession.selectOne("resources.mapper.StudentMapper.findCourseByName", request.getCourseName());
        if (course != null) {
            sqlSession.close();
            return new ErrorResponse("该课程已存在");
        } else {
            sqlSession.insert("resources.mapper.StudentMapper.addCourse", new Course(request.getCourseName(), request.getInstruction(), request.getCourseImageURL(), request.getIntroduction(), request.getPrice(), request.getStartTime()));
            sqlSession.commit();
            sqlSession.close();
            return new SuccessResponse("课程添加成功");
        }
    }

    //添加收藏课程
    @RequestMapping(value = "/addCollectCourse", method = RequestMethod.POST)
    public @ResponseBody Object addCollectCourse(@RequestBody StudentCollectResponse request) throws IOException {// course改成StudentCollectResponse
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        Course course = sqlSession.selectOne("resources.mapper.StudentMapper.findCourseByID", request.getCourseID());
        Student student=sqlSession.selectOne("resources.mapper.StudentMapper.findStuByNickName", request.getStudentNickName());
        Map<String,Integer> map=new HashMap();
        StudentCollectResponse collectCourse;
        int studentID;
        if(student!=null ){
            map.put("courseID",request.getCourseID());
            map.put("studentID",student.getStudentID());
            collectCourse=sqlSession.selectOne("resources.mapper.StudentMapper.findCollectCourseID", map);
            studentID=Integer.parseInt(String.valueOf(student.getStudentID()));
        }else {
            return new SuccessResponse("该学生不存在"+request.getStudentNickName());
        }
        if (course != null) {
            if(collectCourse!=null){//说明改学生已添加过课程
//                if(collectCourse.getStudentID()==studentID && collectCourse.getCourseID()==request.getCourseID()){
                  return new ErrorResponse("该课程已收藏过！！");
//                }
            }
            sqlSession.insert("resources.mapper.StudentMapper.addCollectCourse", new Course(
                    Integer.parseInt(String.valueOf(request.getCourseID())),studentID));
            sqlSession.commit();
            sqlSession.close();
            return new ErrorResponse("课程添加收藏成功"+course.getCourseID()+studentID);
        } else {
            return new SuccessResponse("该课程不存在"+request.getCourseID()+studentID);
        }
    }

    //添加已参与的课程
    @RequestMapping(value = "/addTokenCourse", method = RequestMethod.POST)
    public @ResponseBody Object addTokenCourse(@RequestBody AddCourseResponse request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        Course course = sqlSession.selectOne("resources.mapper.StudentMapper.findCourseByID", request.getCourseID());
        //找学生ID
        Student student=sqlSession.selectOne("resources.mapper.StudentMapper.findStuByNickName", request.getStudentNickName());

        Map<String,Integer> map=new HashMap();

        //查找是否已经添加过参与课程
        AddCourseResponse tokenCourse;
        int studentID;
        int teacherID= Integer.parseInt(String.valueOf(request.getTeacherID()));
        if(student!=null ){
            map.put("courseID",request.getCourseID());
            map.put("studentID",student.getStudentID());
            map.put("teacherID",request.getTeacherID());
            tokenCourse=sqlSession.selectOne("resources.mapper.StudentMapper.findTokenCourseID", map);
            studentID=Integer.parseInt(String.valueOf(student.getStudentID()));
        }else {
            return new SuccessResponse("该学生不存在"+request.getStudentNickName());
        }
        if (course != null) {
            if(tokenCourse!=null) return new ErrorResponse("该课程已经参与过，不能再添加了！");

            sqlSession.insert("resources.mapper.StudentMapper.addTokenCourse", new CourseResponse(
                    Integer.parseInt(String.valueOf(request.getCourseID())),studentID,teacherID));
            sqlSession.commit();
            sqlSession.close();
            return new ErrorResponse("课程添加课程成功"+course.getCourseID()+studentID);
        } else {
            return new SuccessResponse("该课程不存在"+request.getCourseID()+studentID);
        }
    }

    //查询学生已参与的课程
    //该学生已参与课程
    @RequestMapping(value = "/myCourse", method = RequestMethod.GET)
    public @ResponseBody Object myCourse(@Param("studentNickName") String studentNickName ) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
//        studentNickName="Jong Dae";
        List<CourseResponse> course = sqlSession.selectList("resources.mapper.StudentMapper.listMyCourse");
        List<CourseResponse> result=new LinkedList<CourseResponse>();
        for(int i=0;i<course.size();i++){
            if(course.get(i).getStudentNickName().equals(studentNickName)){
                result.add(course.get(i));
            }
        }
        if (course != null) {
        sqlSession.close();
        if(result.size()!=0) return result;
        return new ErrorResponse("没有参与课程nnn"+studentNickName);
    } else {
        sqlSession.close();
        return new ErrorResponse("没有参与课程da"+studentNickName);
    }
}
//    @RequestMapping(value = "/myCourse", method = RequestMethod.POST)
//    public @ResponseBody Object myCourse(@RequestBody Student request) throws IOException {
//        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
////        studentNickName="Jong Dae";
//        Student student=sqlSession.selectOne("resources.mapper.StudentMapper.findStuByNickName", request.getStudentNickName());
//
//        if(student!=null){
//            List<CourseResponse> course = sqlSession.selectList("resources.mapper.StudentMapper.listMyCourse",student.getStudentID());
//            if (course != null) {
//                sqlSession.close();
//                return course;
//            }else {
//                sqlSession.close();
//                return new ErrorResponse("没有参与课程da"+request.getStudentNickName());
//            }
//        }else {
//            sqlSession.close();
//            return new ErrorResponse("没有该学生"+request.getStudentNickName());
//        }
//    }

    //搜索课程---搜索框
    @RequestMapping(value = "/searchCourse", method = RequestMethod.POST)
    public @ResponseBody Object searchCourse(@RequestBody Course request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        Course course = sqlSession.selectOne("resources.mapper.StudentMapper.findCourseByName", request.getCourseName());
        if (course != null) {
            sqlSession.close();
            return course;
        } else {
            sqlSession.close();
            return new ErrorResponse("该课程不存在"+request.getCourseName());
        }
    }
    //搜索课程
    @RequestMapping(value = "/findCourse", method = RequestMethod.POST)
    public @ResponseBody Object searchCourseByID(@RequestBody Course request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        Course course = sqlSession.selectOne("resources.mapper.StudentMapper.findCourseByID", request.getCourseName());
        if (course != null) {
            sqlSession.close();
            return course;
        } else {
            sqlSession.close();
            return new ErrorResponse("该课程不存在");
        }
    }
}