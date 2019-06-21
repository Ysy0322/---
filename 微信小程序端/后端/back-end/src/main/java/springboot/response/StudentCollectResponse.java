package springboot.response;

public class StudentCollectResponse {
    private int courseID;
    private int studentID;
    private String studentNickName;


    public StudentCollectResponse(){}
    public StudentCollectResponse(int courseID,String studentNickName){
        this.courseID=courseID;
        this.studentNickName=studentNickName;
    }
    public StudentCollectResponse(int courseID,int studentID){
        this.courseID=courseID;
        this.studentID=studentID;
    }
    public StudentCollectResponse(int courseID,int studentID,String studentNickName){
        this.courseID=courseID;
        this.studentID=studentID;
        this.studentNickName=studentNickName;
    }
    public String getStudentNickName() {
        return studentNickName;
    }

    public void setStudentNickName(String studentNickName) {
        this.studentNickName = studentNickName;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
       this.studentID = studentID;
    }
}
