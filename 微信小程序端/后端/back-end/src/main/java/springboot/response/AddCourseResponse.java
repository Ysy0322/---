package springboot.response;

public class AddCourseResponse {
    private int courseID;
    private int teacherID;
    private int studentID;
    private String studentNickName;

    public AddCourseResponse(){}

    public AddCourseResponse(int courseID,int teacherID,String studentNickName){//传入的参数
        this.courseID=courseID;
        this.teacherID=teacherID;
        this.studentNickName=studentNickName;
    }
    public AddCourseResponse(int courseID,int studentID,int teacherID){//返回的参数
        this.courseID=courseID;
        this.teacherID=teacherID;
        this.studentID=studentID;
    }

    public AddCourseResponse(int courseID,int studentID,int teacherID,String studentNickName){
        this.courseID=courseID;
        this.teacherID=teacherID;
        this.studentID=studentID;
        this.studentNickName=studentNickName;
    }



    public String getStudentNickName() {
        return studentNickName;
    }

    public void setStudentNickName(String studentNickName) {
        this.studentNickName = studentNickName;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }
}
