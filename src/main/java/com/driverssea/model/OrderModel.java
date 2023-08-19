package com.driverssea.model;

public class OrderModel {
    long ID = 0L;
    String orderNo = "";
    String productName = "";
    float price = 0;
    int quantity = 0;

    public OrderModel(long ID, String orderNo, String productName, float price, int quantity) {
        super();
        this.ID = ID;
        this.orderNo = orderNo;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderModel() {
    }

    @Override
    public String toString() {
        return "OrderModel{" +
                "ID=" + ID +
                ", orderNo='" + orderNo + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", quanity=" + quantity +
                '}';
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}