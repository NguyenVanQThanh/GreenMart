package com.greenmart.common.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "product_seq")
    @SequenceGenerator(name = "product_seq",sequenceName = "PRODUCT_ID_AUTO",allocationSize = 1)
    @Column(name = "PRODUCT_ID",precision = 7)
    private Long id;

    @Column(name = "PRODUCT_NAME",length = 50)
    private String name;

    @Column(name = "PRODUCT_TYPE",length = 50)
    private String type;

    @Column(name = "ORIGIN",length = 50)
    private String origin;

    @Column(name = "PRICE", precision = 11, scale = 2,nullable = false)
    private BigDecimal price;

    @Column(name = "UNIT",nullable = false,length = 50)
    private String unit;

    @Column(name = "QUANTITY",precision = 7,nullable = false)
    private Integer quantity;

    @Column(name = "LINK_PHOTO",length = 500)
    private String photoLink;

    @Column(name = "DESCRIPTION", length = 2000)
    private String description;

    @Column(name = "NUTRITION_VALUE",length = 2000)
    private String nutritionValue;

    @OneToMany(mappedBy = "product")
    private List<Cart> carts;
    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;

    public List<OrderDetail> getBillDetails() {
        return orderDetails;
    }

    public void setBillDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Product() {
    }

    public Product(String name, String type, String origin, BigDecimal price, String unit, Integer quantity, String photoLink, String description, String nutritionValue) {
        this.name = name;
        this.type = type;
        this.origin = origin;
        this.price = price;
        this.unit = unit;
        this.quantity = quantity;
        this.photoLink = photoLink;
        this.description = description;
        this.nutritionValue = nutritionValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNutritionValue() {
        return nutritionValue;
    }

    public void setNutritionValue(String nutritionValue) {
        this.nutritionValue = nutritionValue;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }
    @Transient
    public String getPhotosImagePath(){
        if (id == null || photoLink == null) return "/images/default-user.png";
        return "/product-photos/" + this.name + "/" + this.photoLink;
    }


}
