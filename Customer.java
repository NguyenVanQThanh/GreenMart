package com.greenmart.common.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.hibernate.annotations.Check;


@Entity
@Table(name = "CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "customer_seq")
    @SequenceGenerator(name = "customer_seq",sequenceName = "CUSTOMER_ID_AUTO",allocationSize = 1)
    @Column(name = "CUSTOMER_ID",precision = 7)
    private Long id;
    @Column(name = "FULLNAME",length = 50)
    private String fullName;
    @Column(name = "ADDRESS",length = 400)
    private String address;
    @Column(name = "PHONE",length = 25)
    private String phone;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "BIRTHDAY",nullable = false)
    private LocalDate birthday;
    @Column(name = "MAIL",nullable = false,unique = true,length = 100)
    @Check(constraints = "MAIL LIKE '%@%'")
    private String email;
    @Column(name = "TOTAL_PURCHASE_AMOUNT",precision = 11,scale = 2,columnDefinition = "NUMBER(11,2) DEFAULT 0")
    private BigDecimal total;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "USERLOGIN_ID")
    private LoginCustomer loginCustomer;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Cart> carts;
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order){
        this.orders.add(order);
    }
    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }


    public Customer() {
    }

    public Customer(String fullName, String address, String phone, LocalDate birthday, String email) {
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.birthday = birthday;
        this.email = email;
        this.total= BigDecimal.valueOf(0);
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public LoginCustomer getLoginCustomer() {
        return loginCustomer;
    }

    public void setLoginCustomer(LoginCustomer loginCustomer) {
        this.loginCustomer = loginCustomer;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", total=" + total +
//                ", loginCustomer=" + loginCustomer +
//                ", carts=" + carts +
//                ", orders=" + orders +
                '}';
    }
}
