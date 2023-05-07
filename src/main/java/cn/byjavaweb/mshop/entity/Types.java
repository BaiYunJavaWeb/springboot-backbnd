package cn.byjavaweb.mshop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("types")
public class Types {
    private Integer id;
    private String name;
}