package springboot.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;
import springboot.domain.Teacher;
import springboot.request.*;
import springboot.response.*;

import java.io.IOException;


@RestController
@RequestMapping("/teacher")
@CrossOrigin
public class TeacherController {

//    教师注册验证
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody
    Object register(@RequestBody TeacherRegister request) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        Teacher user = sqlSession.selectOne("resources.mapper.TeacherMapper.findTeacherRegister", request.getEmail());
        if (user != null) {
            sqlSession.close();
            return new MessageResponse(0, "注册失败！");
        } else {
            sqlSession.insert("resources.mapper.TeacherMapper.addTeacher", new Teacher(request.getTechName(),
                    request.getPassword(), request.getEmail(), request.getPhone()));
            sqlSession.commit();
            sqlSession.close();
            return new MessageResponse(1, "注册成功！"); // use your generated token here.
        }
    }

//    教师登录验证
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    Object login(@RequestBody TeacherLogin loginRequest) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();

        Teacher teacher = sqlSession.selectOne("resources.mapper.TeacherMapper.findTeacherLogin", loginRequest);

        if (teacher != null) {
            sqlSession.close();
            return new LoginResponse(teacher.getEmail(), teacher.getPassword(), teacher.getTeacherID(), 1, "登陆成功");
        } else {
            sqlSession.close();
            return new LoginResponse(teacher.getEmail(), loginRequest.getPassword(), teacher.getTeacherID(), 0, "登陆失败");
        }
    }

//    根据ID获取教师个人信息
    @RequestMapping(value = "/teacherInfo", method = RequestMethod.POST)
    public @ResponseBody
    Object teacherOnline(@RequestBody TeacherInfo info) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        Teacher user = sqlSession.selectOne("resources.mapper.TeacherMapper.findTeacherByID", info);
//       System.out.println(info.getTeacherID());
        if (user != null) {
            sqlSession.close();
            return user;
        } else {
            sqlSession.close();
            return new ErrorResponse("用户不存在");
        }
    }

//    更新教师个人信息
    @RequestMapping(value = "/updateTeacher", method = RequestMethod.POST)
    public @ResponseBody
    Object updateInfo(@RequestBody TeacherModify teacherModify) throws IOException {
        SqlSession sqlSession = SqlSessionLoader.getSqlSession();
        int rs =sqlSession.update("resources.mapper.TeacherMapper.updateTeacher", teacherModify);
        sqlSession.commit();
        if (rs == 1) {
            sqlSession.close();
            return new MessageResponse(1,"修改成功！");
        } else {
            sqlSession.close();
            return new MessageResponse(0,"修改失败！");
        }
}

}
