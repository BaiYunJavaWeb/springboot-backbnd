package cn.byjavaweb.mshop.mapper;

import cn.byjavaweb.mshop.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
    @Select("select * from goods order by id desc limit #{begin}, #{size}")
    List<Goods> getList(@Param("begin")int begin, @Param("size")int size);
    
}
