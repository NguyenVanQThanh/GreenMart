package com.greenmart.common.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderDetailsId implements Serializable {
    @Column(name = "ORDER_ID")
    private Long orderId;
    @Column(name = "PRODUCT_ID")
    private Long productId;

    public OrderDetailsId() {
    }

    public OrderDetailsId(Long orderId, Long productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        OrderDetailsId that = (OrderDetailsId) o;
//        return Objects.equals(orderId, that.orderId) &&
//                Objects.equals(productId, that.productId);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(orderId, productId);
//    }

}
