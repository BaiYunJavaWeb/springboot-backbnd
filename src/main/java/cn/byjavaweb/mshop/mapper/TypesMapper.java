package cn.byjavaweb.mshop.mapper;

import cn.byjavaweb.mshop.entity.Types;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TypesMapper  extends BaseMapper<Types> {
    @Select("select * from types")
    List<Types> getList();
}
