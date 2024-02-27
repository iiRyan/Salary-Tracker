package com.rayan.salarytracker.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    /* Begin fields */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Basic
    @Column(name = "user_name", nullable = false, length = 45)
    private String userName;

    @Basic
    @Column(name = "user_email", nullable = false, length = 45, unique = true)
    private String userEmail;

    @Basic
    @Column(name = "password", nullable = false, length = 60)
    private String userPassword;
    /* Ends fields */

    /* Begin Relationships */
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Salary> salaryList;
    /* Ends Relationships */

    public User() {
    }

    public User(String userName, String userEmail, String userPassword) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + "]";
    }

    public List<Salary> getSalaryList() {
        return salaryList;
    }

    public void setSalaryList(List<Salary> salaryList) {
        this.salaryList = salaryList;
    }

    public void add(Salary tempSalary) {
        if (salaryList == null) {
            salaryList = new ArrayList<>();
        }
        salaryList.add(tempSalary);
        tempSalary.setUser(this);
    }
}
