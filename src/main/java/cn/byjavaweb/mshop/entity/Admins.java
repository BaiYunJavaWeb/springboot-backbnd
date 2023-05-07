package cn.byjavaweb.mshop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("admins")
public class Admins {
    private Integer id;
    private String username;
    private String password;
    private String oldPassword;
}