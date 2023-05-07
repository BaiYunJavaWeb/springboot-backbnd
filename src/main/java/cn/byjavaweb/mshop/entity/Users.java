package cn.byjavaweb.mshop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("users")
public class Users {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String address;
}