package springboot.response;

public class TeacherInfoResponse {
    private String username;
    private String email;
    private String phone;
    private String Introduction;

    public TeacherInfoResponse(String username, String email, String phone,String introduction) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.Introduction=introduction;
    }

    public String getIntroduction() {
        return Introduction;
    }

    public void setIntroduction(String introduction) {
        Introduction = introduction;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
