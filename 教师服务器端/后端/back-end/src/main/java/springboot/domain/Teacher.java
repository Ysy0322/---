package springboot.domain;

public class Teacher {
    private int teacherID;
    private String techName;
    private String password;
    private String email;
    private String phone;
    private String Introduction;

    public Teacher(){}

    public Teacher(int teacherID, String techName, String password, String email, String phone) {
        this.teacherID = teacherID;
        this.techName = techName;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public Teacher(String techName, String password, String email, String phone) {
        this.techName = techName;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public Teacher(String techName, String email, String phone) {
        this.techName = techName;
        this.email = email;
        this.phone = phone;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public String getTechName() {
        return techName;
    }

    public void setTechName(String techName) {
        this.techName = techName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIntroduction() {
        return Introduction;
    }

    public void setIntroduction(String Introduction) {
        this.Introduction = Introduction;
    }
}
