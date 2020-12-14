package SpringBoot.MiniFlipkart.application.qdos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// utility class for singnup body
@JsonIgnoreProperties(ignoreUnknown = true)
public class SignupQdo {

    private String firstname;
    private String lastname;
    private String username;
    private int age;
    private String phonenumber;
    private String email;
    private String password;
    private String usertype;
    private String gender;
    private String housenumber;
    private String locality;
    private String state;
    private String country;
    private String pincode;

    public SignupQdo() {

    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsertype() {
        return usertype;
    }

    public String getGender() {
        return gender;
    }

    public String getHousenumber() {
        return housenumber;
    }

    public String getLocality() {
        return locality;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getPincode() {
        return pincode;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}

