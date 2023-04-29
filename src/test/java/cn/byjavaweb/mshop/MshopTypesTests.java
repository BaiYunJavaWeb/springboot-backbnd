package cn.byjavaweb.mshop;

import cn.byjavaweb.mshop.entity.Types;
import cn.byjavaweb.mshop.mapper.TypesMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MshopTypesTests {
    @Autowired
    private TypesMapper typesMapper;

    @Test
    void testSelectById(){
        Types types = typesMapper.selectById(1);
        System.out.println(types);
    }
}
