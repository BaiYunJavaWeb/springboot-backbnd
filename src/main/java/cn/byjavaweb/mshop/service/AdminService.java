package cn.byjavaweb.mshop.service;

import cn.byjavaweb.mshop.entity.Admins;
import cn.byjavaweb.mshop.mapper.AdminsMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    //  由于触发循环依赖，故使用构造函数注入而不使用Autowired依赖注入
    private final AdminsMapper adminsMapper;

    public AdminService(AdminsMapper adminsMapper) {
        this.adminsMapper = adminsMapper;
    }

    /**
     * 检查密码
     * @param admins Admins实体
     * @return boolean 管理员不存在或密码错误
     */
    public boolean checkAdmin(Admins admins){
        QueryWrapper<Admins> wrapper = new QueryWrapper<>();
        wrapper.eq("username",admins.getUsername()).select("old_password");
        Admins adminsOne = adminsMapper.selectOne(wrapper);
        return adminsOne != null && adminsOne.getOldPassword().equals(admins.getPassword());
    }

    /**
     * 通过管理员名查询
     * @param username 用户名
     * @return Admins 管理员实体
     */
    public Admins getByUserName(String username){
        QueryWrapper<Admins> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        return adminsMapper.selectOne(wrapper);
    }

    /**
     * 分页查询
     * @param page 页数
     * @param rows  行数
     * @return List<Admins> 分页列表
     */
    public List<Admins> getList(int page,int rows){
        Page<Admins> pageObj = new Page<>(page, rows);
        LambdaQueryWrapper<Admins> queryWrapper = new LambdaQueryWrapper<>();
        // 设置查询条件
        // queryWrapper.eq("name", "admin");
        return adminsMapper.selectPage(pageObj, queryWrapper).getRecords();
    }

    /**
     * 返回总数
     * @return long 总数
     */
    public long getTotal(){
        return adminsMapper.selectCount();
    }

    /**
     * 返回Admin实体
     * @param id id
     * @return Admins 实体
     */
    public Admins get(int id){
        return adminsMapper.selectById(id);
    }

    /**
     * 新增管理员
     * @param admins 管理员实体
     * @return Integer affect rows
     */
    public Integer add(Admins admins){
        admins.setPassword(admins.getPassword());
        admins.setOldPassword(admins.getPassword());
        return adminsMapper.insert(admins);
    }

    /**
     * 更新管理员信息
     * @param admins 管理员实体
     * @return boolean 是否更新成功
     */
    public boolean update(Admins admins){
        admins.setPassword(admins.getPassword());
        admins.setOldPassword(admins.getPassword());
        return adminsMapper.updateById(admins) > 0;
    }

    /**
     * 删除管理员
     * @param admins 管理员实体(有id即可)
     * @return boolean 是否删除成功
     */
    public boolean delete(Admins admins){
        return adminsMapper.deleteById(admins.getId()) > 0;
    }
}
