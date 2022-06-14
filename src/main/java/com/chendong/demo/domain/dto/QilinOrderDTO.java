package com.chendong.demo.domain.dto;

import java.math.BigDecimal;
import java.util.Date;

public class QilinOrderDTO {

    private String orderId;

    private BigDecimal totalPrice;

    private Long num;

    private Long height;

    private Date dateTime;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public QilinOrderDTO() {}

    public QilinOrderDTO(String orderId, BigDecimal totalPrice, Long num, Long height, Date dateTime) {
        this.orderId = orderId;
        this.totalPrice = totalPrice;
        this.num = num;
        this.height = height;
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "QilinOrderDTO{" + "orderId='" + orderId + '\'' + ", totalPrice=" + totalPrice + ", num=" + num
            + ", height=" + height + ", dateTime=" + dateTime + '}';
    }
}
