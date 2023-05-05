package cn.byjavaweb.mshop.dto;

import java.util.Date;

public class OrderMergeDto {
    private Integer id;
    private Integer total;
    private Integer amount;
    private Byte status;
    private Byte paytype;
    private String name;
    private String phone;
    private String address;
    private Date systime;
    private Integer userId;
    private String goodName;

    public OrderMergeDto(Integer id, Integer total, Integer amount, Byte status, Byte paytype, String name,
            String phone, String address, Date systime, Integer userId, String goodName) {
        this.id = id;
        this.total = total;
        this.amount = amount;
        this.status = status;
        this.paytype = paytype;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.systime = systime;
        this.userId = userId;
        this.goodName = goodName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getPaytype() {
        return paytype;
    }

    public void setPaytype(Byte paytype) {
        this.paytype = paytype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getSystime() {
        return systime;
    }

    public void setSystime(Date systime) {
        this.systime = systime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }
}
