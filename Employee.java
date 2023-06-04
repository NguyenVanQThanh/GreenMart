package com.greenmart.common.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.hibernate.annotations.Check;


@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "employee_seq")
    @SequenceGenerator(name = "employee_seq",sequenceName = "EMPLOYEE_ID_AUTO",allocationSize = 1)
    @Column(name = "EMPLOYEE_ID",precision = 7)
    private Long id;

    @Column(name = "FULLNAME", length = 50)
    private String fullName;

    @Column(name = "ADDRESS", length = 400)
    private String address;

    @Column(name = "PHONE", length = 25)
    private String phone;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "BIRTHDAY", nullable = false)
    private LocalDate birthday;
    @Column(name = "MAIL",nullable = false,unique = true,length = 100)
    @Check(constraints = "MAIL LIKE '%@%'")
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "START_DATE",nullable = false)
    private LocalDate startDate;

    @Column(name = "BASE_SALARY",precision = 11,scale = 2)
    private BigDecimal baseSalary;
    @Column(name = "USERPOSITION",length = 50)
    @Check(constraints = "USERPOSITION IN ('MANAGE', 'EMPLOYEE')")
    private String position;

    @OneToOne
    @JoinColumn(name = "USERLOGIN_ID")
    private LoginEmployee loginEmployee;

    @ManyToOne
    @JoinColumn(name = "MANAGER_ID")
    private Employee manager;

    public Employee() {
    }

    public Employee(String fullName, String address, String phone, String email, LocalDate birthday, LocalDate startDate, BigDecimal baseSalary) {
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
        this.startDate = startDate;
        this.baseSalary = baseSalary;
    }

    // Constructor, getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(BigDecimal baseSalary) {
        this.baseSalary = baseSalary;
    }

    public LoginEmployee getLoginEmployee() {
        return loginEmployee;
    }

    public void setLoginEmployee(LoginEmployee loginEmployee) {
        this.loginEmployee = loginEmployee;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }
}
