package cn.byjavaweb.mshop.mapper;

import cn.byjavaweb.mshop.entity.Tops;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TopsMapper  extends BaseMapper<Tops> {
    @Select("select * from tops where type=#{type} order by id desc limit #{begin}, #{size}")
    List<Tops> getList(@Param("type")int type, @Param("begin")int begin, @Param("size")int size);
}
