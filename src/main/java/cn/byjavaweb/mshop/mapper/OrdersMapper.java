package cn.byjavaweb.mshop.mapper;

import cn.byjavaweb.mshop.dto.OrderAddDto;
import cn.byjavaweb.mshop.entity.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {

	@Select("SELECT * FROM `orders` WHERE `status`=${status} ORDER BY id DESC LIMIT #{start}, ${limit}")
	List<Orders> getListOfStatus(int statis, int start, int limit);

	@Select("select * from orders")
	List<Orders> getAll();

	@Update("UPDATE `orders` SET `status`=3 WHERE id=#{id}")
	void dispose(int id);

	@Update("UPDATE `orders` SET `status`=4 WHERE id=#{id}")
	void finish(int id);

	@Select("select * from orders where user_id=#{userid}")
	List<Orders> selectByUID(int userid);

	@Insert({
			"insert into orders(total, amount, status, paytype, name, phone, address, user_id) values(#{total}, #{amount}, 1, 1, #{name}, #{phone}, #{address}, #{userId})" })
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int add(OrderAddDto orderAddDto);

	@Select("SELECT LAST_INSERT_ID()")
	int getLastInsertId();
}
