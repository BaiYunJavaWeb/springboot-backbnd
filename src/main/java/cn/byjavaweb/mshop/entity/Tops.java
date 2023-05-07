package cn.byjavaweb.mshop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tops")
public class Tops {
    private Integer id;
    private Byte type;
    private Integer goodId;
}