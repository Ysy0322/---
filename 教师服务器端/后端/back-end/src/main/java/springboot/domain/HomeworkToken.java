package springboot.domain;

public class HomeworkToken {
    private int homeworkID;
    private int studentID;
    private boolean done;

    private String studentName;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

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
}
