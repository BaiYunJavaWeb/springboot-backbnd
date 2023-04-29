package cn.byjavaweb.mshop;

import cn.byjavaweb.mshop.entity.Orders;
import cn.byjavaweb.mshop.mapper.OrdersMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MshopOrdersTests {
    @Autowired
    private OrdersMapper ordersMapper;

    @Test
    void testSelectById(){
        Orders orders = ordersMapper.selectById(1);
        System.out.println(orders);
    }
}
