
package miniflipkart.application.entities.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "username")
    private String userName;

    @Column(name = "age")
    private int age;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "usertype")
    private String userType;

    @CreationTimestamp
    @Column(name = "createdat")
    private java.sql.Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updatedat")
    private java.sql.Timestamp updatedAt;

    @Column(name = "password")
    private String password;

    @Column(name = "gender")
    private String gender;


    // No Argument Constructor
    public User() {

    }

    // Parameterized Constructor
    public User(String firstName, String lastName, String userName, int age, String phoneNumber, String email,
                String userType, String password, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.userType = userType;
        this.password = password;
        this.gender = gender;
    }


    // return the id
    public int getId() {
        return id;
    }

    // return the firstName
    public String getFirstName() {
        return firstName;
    }

    // return the lastName
    public String getLastName() {
        return lastName;
    }

    // return the userName
    public String getUserName() {
        return userName;
    }

    // return the age
    public int getAge() {
        return age;
    }

    // return the phoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // return the email
    public String getEmail() {
        return email;
    }

    // return the userType
    public String getUserType() {
        return userType;
    }

    // return the createdAt timestamp
    public java.sql.Timestamp getCreatedAt() {
        return createdAt;
    }

    // return the updatedAt timestamp
    public java.sql.Timestamp getUpdatedAt() {
        return updatedAt;
    }

    // return the password
    public String getPassword() {
        return password;
    }

    // return the gender
    public String getGender() {
        return gender;
    }


    // set the id
    public void setId(int id) {
        this.id = id;
    }

    // set the firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // set the lastName
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // set the userName
    public void setUserName(String userName) {
        this.userName = userName;
    }

    // set the age
    public void setAge(int age) {
        this.age = age;
    }

    // set the phoneNumber
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // set the email
    public void setEmail(String email) {
        this.email = email;
    }

    // set the userType
    public void setUserType(String userType) {
        this.userType = userType;
    }

    // set the ceatedAt
    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    // set the updatedAt
    public void setUpdatedAt(java.sql.Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    // set the password
    public void setPassword(String password) {
        this.password = password;
    }

    // set the gender
    public void setGender(String gender) {
        this.gender = gender;
    }


    // print the user object to console
    @Override
    public String toString() {
        return String.format(
                "User [id=%s, firstName=%s, lastName=%s, userName=%s, age=%s, phoneNumber=%s, email=%s, userType=%s, createdAt=%s, updatedAt=%s, password=%s, gender=%s]",
                id, firstName, lastName, userName, age, phoneNumber, email, userType, createdAt, updatedAt, password,
                gender);
    }

}
