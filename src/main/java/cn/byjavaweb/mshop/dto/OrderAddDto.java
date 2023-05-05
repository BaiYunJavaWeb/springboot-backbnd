package cn.byjavaweb.mshop.dto;

public class OrderAddDto {
    private Integer id;
    // 总价格
    private Integer total;
    // 总量
    private Integer amount;
    // 收货人
    private String name;
    // 联系方式
    private String phone;
    // 收货地址
    private String address;
    // 用户ID
    private Integer userId;
    // 商品ID
    private Integer goodId;

    public OrderAddDto(Integer id, Integer total, Integer amount, String name, String phone, String address,
            Integer userId, Integer goodId) {
        this.id = id;
        this.total = total;
        this.amount = amount;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.userId = userId;
        this.goodId = goodId;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

}
