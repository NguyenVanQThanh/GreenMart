package com.greenmart.common.entity;

import javax.persistence.*;

@Entity
@Table(name = "LOGIN_EMPLOYEE")
public class LoginEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "login_employee_seq")
    @SequenceGenerator(name = "login_employee_seq",sequenceName = "LOGIN_EMPLOYEE_ID_AUTO",allocationSize = 1)
    @Column(name = "USERLOGIN_ID",precision = 7)
    private Long id;

    @Column(name = "USERNAME", unique = true)
    private String username;

    @Column(name = "USERPASSWORD")
    private String password;

    @OneToOne(mappedBy = "loginEmployee")
    private Employee employee;

    public LoginEmployee() {
    }

    public LoginEmployee(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    // Constructor, getters and setters

}
