package cn.byjavaweb.mshop.mapper;

import cn.byjavaweb.mshop.entity.Tops;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TopsMapper  extends BaseMapper<Tops> {
    int deleteById(Integer id);
    
    int insert(Tops record);
    
    int insertSelective(Tops record);
    
    Tops selectById(Integer id);
    
    int updateByIdSelective(Tops record);
    
    int updateById(Tops record);
    
    
    @Select("select * from tops where type=#{type} order by id desc limit #{begin}, #{size}")
    List<Tops> getList(@Param("type")int type, @Param("begin")int begin, @Param("size")int size);
    
    @Select("select count(*) from tops where type=#{type}")
    public long getTotal(byte type);
    
    /**
     * 通过商品id获取
     * @param goodid
     * @return
     */
    @Select("select * from tops where good_id=#{goodid}")
    public List<Tops> getListByGoodid(int goodid);
    
    /**
     * 通过商品id和类型删除
     * @param goodid
     * @param type
     * @return
     */
    @Delete("delete from tops where good_id=#{goodid} and type=#{type}")
    public boolean deleteByGoodidAndType(@Param("goodid")int goodid, @Param("type")byte type);
    
    /**
     * 通过goodid删除
     * @param goodid
     * @return
     */
    @Delete("delete from tops where good_id=#{goodid}")
    public boolean deleteByGoodid(@Param("goodid")int goodid);
    
}
