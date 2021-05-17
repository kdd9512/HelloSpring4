package kdd9512.data.vo;

public class MemberVO {
    private String userid;
    private String passwd;
    private String name;
    private String grade;
    private String points;
    private String regdate;

    public String getUserid() {
        return userid;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public String  getPoints() {
        return points;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }
}
