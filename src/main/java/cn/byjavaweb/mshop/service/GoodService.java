package cn.byjavaweb.mshop.service;

import cn.byjavaweb.mshop.entity.Goods;
import cn.byjavaweb.mshop.mapper.GoodsMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodService {
    private final GoodsMapper goodsMapper;
    public GoodService(GoodsMapper goodsMapper){
        this.goodsMapper = goodsMapper;
    }

    public Goods get(int id){
        return goodsMapper.selectById(id);
    }

    public List<Goods> getList(int type, int page, int size){
        return goodsMapper.getList(type, (page-1)*size, size);
    }

    public List<Goods> getAll(){
        return goodsMapper.getAll();
    }

    public boolean delete(int id){
        return goodsMapper.deleteById(id) > 0;
    }

    public boolean update(Goods goods){return  goodsMapper.updateById(goods) > 0;}

    public boolean add(Goods goods){return goodsMapper.insert(goods) >0 ;}
}
