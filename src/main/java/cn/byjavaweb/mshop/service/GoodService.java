package cn.byjavaweb.mshop.service;

import cn.byjavaweb.mshop.entity.Goods;
import cn.byjavaweb.mshop.entity.Tops;
import cn.byjavaweb.mshop.mapper.GoodsMapper;
import cn.byjavaweb.mshop.mapper.TopsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodService {
    
    private final GoodsMapper goodsMapper;
    private final TopsMapper topsMapper;
    private final TypeService typeService;
    @Autowired
    public GoodService(
            GoodsMapper goodsMapper,
            TopsMapper topsMapper,
            TypeService typeService
    ) {
        this.goodsMapper = goodsMapper;
        this.topsMapper = topsMapper;
        this.typeService = typeService;
    }
    
    public Goods get(int id){
        return goodsMapper.selectById(id);
    }
    public List<Goods> getList(int status, int page, int size) {
        if (status == 0) {
            return goodsMapper.getList(size * (page-1), size);
        }
        List<Goods> topList = getTopList((byte)status, page, size);
        if(topList!=null && !topList.isEmpty()) {
            return topList;
        }
        return null;
    }
    
    public ArrayList<Goods> getTopList(int type, int page, int size){
        List<Tops> topList = topsMapper.getList(type, (page-1)*size, size);
        ArrayList<Goods> goods = new ArrayList<>();
        for (Tops top:topList) {
            goods.add(this.get(top.getGoodId()));
        }
        return goods;
    }}
