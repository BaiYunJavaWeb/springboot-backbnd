package cn.byjavaweb.mshop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("items")
public class Items {
    private Integer id;
    private Integer price;
    private Integer amount;
    private Integer orderId;
    private Integer goodId;
}