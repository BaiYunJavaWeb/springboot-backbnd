package cn.byjavaweb.mshop;

import cn.byjavaweb.mshop.entity.Tops;
import cn.byjavaweb.mshop.mapper.TopsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MshopTopsTests {
    @Autowired
    private TopsMapper topsMapper;

    @Test
    void testSelectById(){
        Tops tops = topsMapper.selectById(1);
        System.out.println(tops);
    }

}
