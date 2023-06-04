package com.greenmart.common.entity;

import javax.persistence.*;

@Entity
@Table(name = "LOGIN_CUSTOMER")
public class LoginCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "login_customer_seq")
    @SequenceGenerator(name = "login_customer_seq",sequenceName = "LOGIN_CUSTOMER_ID_AUTO",allocationSize = 1)
    @Column(name = "USERLOGIN_ID",precision = 7)
    private Long id;
    @Column(name = "USERNAME")
    private String userName;
    @Column(name = "USERPASSWORD")
    private String password;
    @OneToOne(mappedBy = "loginCustomer")
    private Customer customer;

    public LoginCustomer() {
    }

    public LoginCustomer(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
