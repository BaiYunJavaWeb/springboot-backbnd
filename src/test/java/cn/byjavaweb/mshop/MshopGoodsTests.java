package cn.byjavaweb.mshop;

import cn.byjavaweb.mshop.entity.Goods;
import cn.byjavaweb.mshop.mapper.GoodsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MshopGoodsTests {
    @Autowired
    private GoodsMapper goodsMapper;

    @Test
    void testSelectById(){
        Goods goods = goodsMapper.selectById(1);
        System.out.println(goods.getName());
    }
}
