package com.greenmart.common.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ORDER_DETAIL")
public class OrderDetail {
    @EmbeddedId
    private OrderDetailsId id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID", insertable = false, updatable = false)
    @MapsId("orderId")
    private Order order;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PRODUCT_ID", insertable = false, updatable = false)
    @MapsId("productId")
    private Product product;


    @Column(name = "QUANTITY",precision = 7)
    private Integer quantity;

    public OrderDetail() {
    }

    public OrderDetail(OrderDetailsId id, Integer quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public OrderDetailsId getId() {
        return id;
    }

    public void setId(OrderDetailsId id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
        if (order != null) {
            this.id.setOrderId(order.getOrderId());
        }
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        if (product != null) {
            this.id.setProductId(product.getId());
        }
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public boolean checkIdBill(Long id_Bill){
        return Objects.equals(this.id.getOrderId(), id_Bill);
    }

}
