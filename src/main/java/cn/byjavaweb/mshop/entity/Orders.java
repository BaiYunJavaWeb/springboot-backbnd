package cn.byjavaweb.mshop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("orders")
public class Orders {
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
}