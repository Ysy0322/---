package springboot.request;

public class CourseRequest {
    /**
     * id
     */
    private int courseID;
    /**
     * 课程名
     */
    private String courseName;

    /**
     * 课程简介
     */
    private String instruction;

    /**
     * 课程封面图
     */
    private String courseImageURL;

    /**
     * 课程详情
     */
    private String introduction;

    /**
     * 课程价格
     */
    private int price;
    /**
     * 课程开始时间
     */
    private String startTime;
    private int teacherID;



    public CourseRequest(String courseName,String instruction,String startTime,int price,String introduction){
        this.courseName = courseName;
        this.instruction = instruction;
        this.startTime = startTime;
        this.price = price;
        this.introduction = introduction;

    }
public CourseRequest(){}

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getCourseImageURL() {
        return courseImageURL;
    }

    public void setCourseImageURL(String courseImageURL) {
        this.courseImageURL = courseImageURL;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }
}
