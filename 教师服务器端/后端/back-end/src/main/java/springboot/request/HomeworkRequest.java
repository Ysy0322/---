package springboot.request;

public class HomeworkRequest {
    private int homeworkID;
    private int studentID;
    private boolean done;
    private String homeworkName;
    private String details;
    private int courseID;

    public int getHomeworkID() {
        return homeworkID;
    }

    public void setHomeworkID(int homeworkID) {
        this.homeworkID = homeworkID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getHomeworkName() {
        return homeworkName;
    }

    public void setHomeworkName(String homeworkName) {
        this.homeworkName = homeworkName;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }
}
