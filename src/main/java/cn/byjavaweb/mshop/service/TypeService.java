package cn.byjavaweb.mshop.service;

import cn.byjavaweb.mshop.entity.Types;
import cn.byjavaweb.mshop.mapper.TypesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {

    @Autowired
    private TypesMapper typesMapper;


    /**
     * 获取列表
     */
    public List<Types> getList(){
        return typesMapper.getList();
    }

    /**
     * 通过id查询
     */
    public Types get(int id) {
        return typesMapper.selectById(id);
    }

    /**
     * 添加
     */
    public Integer add(Types type) {
        return typesMapper.insert(type);
    }

    /**
     * 更新
     */
    public boolean update(Types type) {
        return typesMapper.updateById(type) > 0;
    }

    /**
     * 删除
     */
    public boolean delete(Types type) {
        return typesMapper.deleteById(type.getId()) > 0;
    }
}
