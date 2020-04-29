package org.zerock.domain;

public class MovieUserVO {

    private int pk;

    private String username;

    private String password;

    private String lastName;

    private String firstName;

    private String email;

    private String phoneNumber;

    private String ssn;

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    // Movieuser 모델 복사
    public void CopyData(MovieUserVO param)
    {
        this.pk = param.getPk();
        this.username = param.getUsername();
        this.password = param.getPassword();
        this.lastName = param.getLastName();
        this.firstName = param.getFirstName();
        this.email = param.getEmail();
        this.phoneNumber = param.getPhoneNumber();
        this.ssn = param.getSsn();
    }
}
