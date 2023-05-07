package cn.byjavaweb.mshop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("goods")
public class Goods {
    private Integer id;
    private String name;
    private String cover;
    private String image1;
    private String image2;
    private Integer price;
    private String intro;
    private Integer stock;
    private Integer typeId;
}