package com.greenmart.common.entity;

import org.hibernate.annotations.Check;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {
    public enum OrderStatus {
        ORDERED("ORDERED"),
        PREPARING("PREPARING"),
        SHIPPING("SHIPPING"),
        COMPLETELY("COMPLETELY");

        private final String value;

        OrderStatus(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "order_seq")
    @SequenceGenerator(name = "order_seq",sequenceName = "ORDERS_ID_AUTO",allocationSize = 1)
    @Column(name = "ORDER_ID",length = 7)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID",nullable = false)
    private Customer customer;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "ORDER_DATE", nullable = false)
    private LocalDate billDate;

    @Column(name = "TOTAL_MONEY", precision = 11, scale = 2)
    private BigDecimal totalMoney;

    @Column(name = "STATUS",length = 50)
    @Check(constraints = "STATUS IN ('ORDERED', 'PREPARING', 'SHIPPING', 'COMPLETELY')")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "ADDRESS_DELIVERY", length = 100)
    private String addressDelivery;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;


    public List<OrderDetail> getBillDetails() {
        return orderDetails;
    }

    public void setBillDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
        for (OrderDetail bd : orderDetails) {
            bd.setOrder(this);
        }
    }

    public Order(LocalDate billDate, BigDecimal totalMoney, OrderStatus status, String addressDelivery) {
//        this.customer = customer;
        this.billDate = billDate;
        this.totalMoney = totalMoney;
        this.status = status;
        this.addressDelivery = addressDelivery;
    }

    public Order() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getBillDate() {
        return billDate;
    }

    public void setBillDate(LocalDate billDate) {
        this.billDate = billDate;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getAddressDelivery() {
        return addressDelivery;
    }

    public void setAddressDelivery(String addressDelivery) {
        this.addressDelivery = addressDelivery;
    }
}
