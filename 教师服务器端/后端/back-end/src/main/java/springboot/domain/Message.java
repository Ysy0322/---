package springboot.domain;

public class Message {

    private int messageID;
    private int teacherID;
    private int studentID;
    private String content;
    private String sendTime;
    private boolean sender;

    public Message(){}
    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public boolean getSender() {
        return sender;
    }

    public void setSender(boolean sender) {
        this.sender = sender;
    }
}
