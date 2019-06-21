package springboot.domain;

public class Chapter {
    private int chapterID ;
    private int courseID;
    private String chapterText;

    public Chapter(){}

    public Chapter(int chapterID,String chapterText){
        this.chapterID = chapterID;
        this.chapterText = chapterText;
    }

    public int getChapterID() {
        return chapterID;
    }

    public void setChapterID(int chapterID) {
        this.chapterID = chapterID;
    }


    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getChapterText() {
        return chapterText;
    }

    public void setChapterText(String chapterText) {
        this.chapterText = chapterText;
    }
}
