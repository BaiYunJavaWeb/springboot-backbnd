package cn.byjavaweb.mshop;

import cn.byjavaweb.mshop.entity.Admins;
import cn.byjavaweb.mshop.mapper.AdminsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MshopAdminsTests {
    @Autowired
    private AdminsMapper adminsMapper;

    @Test
    void testSelectById(){
        Admins admins = adminsMapper.selectById(1);
        System.out.println(admins.getUsername());
    }
}
