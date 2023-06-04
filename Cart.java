package com.greenmart.common.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CART")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cart_seq")
    @SequenceGenerator(name = "cart_seq",sequenceName = "CART_ID_AUTO",allocationSize = 1)
    @Column(name = "CART_ID",precision = 7)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @Column(name = "QUANTITY",precision = 7)
    private Integer quantity;


    public Cart() {
    }

    public Cart(Product product, Customer customer, Integer quantity) {
        this.product = product;
        this.customer = customer;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Cart other = (Cart) obj;
        return Objects.equals(this.id, other.id) &&
                Objects.equals(this.quantity, other.quantity) &&
                Objects.equals(this.customer, other.customer) &&
                Objects.equals(this.product, other.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, customer, product);
    }

}
