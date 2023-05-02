package cn.byjavaweb.mshop.mapper;

import cn.byjavaweb.mshop.entity.Admins;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminsMapper extends BaseMapper<Admins> {
    /**
     * 返回分页列表
     * @param page 页
     * @param rows 行
     * @return List<Admins>
     */
    List<Admins> selectByPage(@Param("page") int page, @Param("rows") int rows);

    /**
     * 统计总数
     * @return int
     */
    @Select("SELECT COUNT(*) FROM admins")
    int selectCount();
}
