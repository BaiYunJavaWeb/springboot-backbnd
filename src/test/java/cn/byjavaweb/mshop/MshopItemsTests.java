package cn.byjavaweb.mshop;

import cn.byjavaweb.mshop.entity.Items;
import cn.byjavaweb.mshop.mapper.ItemsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MshopItemsTests {
    @Autowired
    private ItemsMapper itemsMapper;

    @Test
    void testSelectById(){
        Items items = itemsMapper.selectById(1);
        System.out.println(items);
    }
}
