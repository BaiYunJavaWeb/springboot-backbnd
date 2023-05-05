package cn.byjavaweb.mshop.mapper;

import cn.byjavaweb.mshop.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UsersMapper extends BaseMapper<Users> {
    @Select("SELECT * FROM users WHERE username = #{username}")
    Users findByUsername(String username);

    @Select("select * from users")
    List<Users> getAll();
}
