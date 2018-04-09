package silly.h1024h.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class User {
    private int uId;
    private String uName = "";
    private String uPassword = "";
    private String uDspName = "";
    private int uSex = 0;
    private String uPhone = "";
    private String uEmail = "";
    private int uVip = 0;
    private String uCreateTime = "";
    private String uToken = "";

    @Id
    @Column(name = "u_id", nullable = false)
    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    @Basic
    @Column(name = "u_name", nullable = true, length = 50)
    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    @Basic
    @Column(name = "u_password", nullable = true, length = 50)
    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    @Basic
    @Column(name = "u_dsp_name", nullable = true, length = 50)
    public String getuDspName() {
        return uDspName;
    }

    public void setuDspName(String uDspName) {
        this.uDspName = uDspName;
    }

    @Basic
    @Column(name = "u_sex", nullable = false)
    public int getuSex() {
        return uSex;
    }

    public void setuSex(int uSex) {
        this.uSex = uSex;
    }

    @Basic
    @Column(name = "u_phone", nullable = true, length = 20)
    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    @Basic
    @Column(name = "u_email", nullable = true, length = 100)
    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    @Basic
    @Column(name = "u_vip", nullable = false)
    public int getuVip() {
        return uVip;
    }

    public void setuVip(int uVip) {
        this.uVip = uVip;
    }

    @Basic
    @Column(name = "u_create_time", nullable = true, length = 20)
    public String getuCreateTime() {
        return uCreateTime;
    }

    public void setuCreateTime(String uCreateTime) {
        this.uCreateTime = uCreateTime;
    }

    @Basic
    @Column(name = "u_token", nullable = true, length = 40)
    public String getuToken() {
        return uToken;
    }

    public void setuToken(String uToken) {
        this.uToken = uToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return uId == user.uId &&
                uSex == user.uSex &&
                uVip == user.uVip &&
                Objects.equals(uName, user.uName) &&
                Objects.equals(uPassword, user.uPassword) &&
                Objects.equals(uDspName, user.uDspName) &&
                Objects.equals(uPhone, user.uPhone) &&
                Objects.equals(uEmail, user.uEmail) &&
                Objects.equals(uCreateTime, user.uCreateTime) &&
                Objects.equals(uToken, user.uToken);
    }

    public User() {
    }

    public User(int uId, String uName, String uPassword, String uDspName, int uSex, String uPhone, String uEmail, int uVip, String uCreateTime, String uToken) {

        this.uId = uId;
        this.uName = uName;
        this.uPassword = uPassword;
        this.uDspName = uDspName;
        this.uSex = uSex;
        this.uPhone = uPhone;
        this.uEmail = uEmail;
        this.uVip = uVip;
        this.uCreateTime = uCreateTime;
        this.uToken = uToken;
    }

    public User(int uId, String uName, String uPassword, String uDspName, String uPhone, String uEmail, int uVip, String uCreateTime, String uToken) {
        this.uId = uId;
        this.uName = uName;
        this.uPassword = uPassword;
        this.uDspName = uDspName;
        this.uPhone = uPhone;
        this.uEmail = uEmail;
        this.uVip = uVip;
        this.uCreateTime = uCreateTime;
        this.uToken = uToken;
    }

    @Override
    public int hashCode() {

        return Objects.hash(uId, uName, uPassword, uDspName, uSex, uPhone, uEmail, uVip, uCreateTime, uToken);
    }
}
