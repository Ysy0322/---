package springboot.response;

public class LoginResponse {
    private String email;
    private String password;
    private int teacherID;
    private int status;
    private String log;

    public LoginResponse(){}

    public LoginResponse(String email, String password, int teacherID, int status, String log) {
        this.email = email;
        this.password = password;
        this.teacherID = teacherID;
        this.status = status;
        this.log = log;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String username) {
        this.email = username;
    }
    public String getPassword(){return password;}

    public void setPassword(String password){
        this.password=password;
    }
    public String getLog(){return log;}

    public void setLog(String log){
        this.log=log;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

}
