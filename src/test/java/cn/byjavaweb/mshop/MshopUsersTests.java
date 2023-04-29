package cn.byjavaweb.mshop;

import cn.byjavaweb.mshop.entity.Users;
import cn.byjavaweb.mshop.mapper.UsersMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MshopUsersTests {
    @Autowired
    private UsersMapper usersMapper;

    @Test
    void testSelectById(){
        Users users = usersMapper.selectById(1);
        System.out.println(users);
    }
}
