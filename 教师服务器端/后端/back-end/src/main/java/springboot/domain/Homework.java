package springboot.domain;

import java.lang.reflect.Array;

public class Homework {
    private int homeworkID;
    private String homeworkName;
    private int courseID;
    private String details;
    private Array studentList;

    public Array getStudentList() {
        return studentList;
    }

    public void setStudentList(Array studentList) {
        this.studentList = studentList;
    }



    public Homework(){}

    public int getHomeworkID() {
        return homeworkID;
    }

    public void setHomeworkID(int homeworkID) {
        this.homeworkID = homeworkID;
    }

    public String getHomeworkName() {
        return homeworkName;
    }

    public void setHomeworkName(String homeworkName) {
        this.homeworkName = homeworkName;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
