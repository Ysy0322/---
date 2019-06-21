package springboot.domain;

public class Course {
    private int courseID;
    private String courseName;
    private String instruction;
    private String courseImageURL;
    private String introduction;
    private int price;
    private String startTime;

    //背景图对象
    private Object courseBg;

    public Course() {}
    public Course(int courseID, String introduction) {
        this.courseID = courseID;
        this.introduction = introduction;
    }


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

    public Object getCourseBg() {
        return courseBg;
    }

    public void setCourseBg(Object courseBg) {
        this.courseBg = courseBg;
    }
}
