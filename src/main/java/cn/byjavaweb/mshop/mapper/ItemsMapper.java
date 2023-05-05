package cn.byjavaweb.mshop.mapper;

import cn.byjavaweb.mshop.entity.Items;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ItemsMapper extends BaseMapper<Items> {
    @Select("select * from items where order_id=#{orderId}")
    public Items getByOrderID(int orderId);
}
