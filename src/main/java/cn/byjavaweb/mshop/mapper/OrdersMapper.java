package cn.byjavaweb.mshop.mapper;

import cn.byjavaweb.mshop.entity.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {
	
	@Select("SELECT * FROM `orders` WHERE `status`=${status} ORDER BY id DESC LIMIT #{start}, ${limit}")
	List<Orders> getListOfStatus(int statis, int start, int limit);
	
	@Update("UPDATE `orders` SET `status`=3 WHERE id=#{id}")
	void dispose(int id);
	
	@Update("UPDATE `orders` SET `status`=4 WHERE id=#{id}")
	void finish(int id);
}
