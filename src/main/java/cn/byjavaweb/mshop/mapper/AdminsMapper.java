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
    
    int deleteById(Integer id);
    
    int insert(Admins record);
    
    int insertSelective(Admins record);
    
    Admins selectById(Integer id);
    
    int updateByIdSelective(Admins record);
    
    int updateById(Admins record);
    
    
    
    // 以上为mybatis generator自动生成接口, 具体实现在mapper.xml中
    
    // ------------------------------------------------------------
    
    // 以下方法使用mybatis注解实现
    
    
    /**
     * 通过用户名查找
     * @param username
     * @return
     */
    @Select("select * from admins where username=#{username}")
    public Admins getByUsername(String username);
    
    /**
     * 通过用户名和密码查找
     * @param username
     * @param password
     * @return 无记录返回null
     */
    @Select("select * from admins where username=#{username} and password=#{password}")
    public Admins getByUsernameAndPassword(@Param("username")String username, @Param("password")String password);
    
    /**
     * 获取列表
     * @param page
     * @param rows
     * @return 无记录返回空集合
     */
    @Select("select * from admins order by id desc limit #{begin}, #{size}")
    public List<Admins> getList(@Param("begin")int begin, @Param("size")int size);
    
    /**
     * 总数
     * @return
     */
    @Select("select count(*) from admins")
    public long getTotal();
}
