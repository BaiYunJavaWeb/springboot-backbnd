package cn.byjavaweb.mshop.service;

import cn.byjavaweb.mshop.entity.Goods;
import cn.byjavaweb.mshop.entity.Tops;
import cn.byjavaweb.mshop.mapper.TopsMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopService {
    private final TopsMapper topsMapper;
    private final GoodService goodService;

    public TopService(TopsMapper topsMapper,GoodService goodService){
        this.topsMapper = topsMapper;
        this.goodService = goodService;
    }

    /**
     * 获取推荐列表
     */
    public ArrayList<Goods> getList(int type, int page, int size){
        List<Tops> topList = topsMapper.getList(type, (page-1)*size, size);
        ArrayList<Goods> goods = new ArrayList<>();
        for (Tops top:topList) {
            goods.add(goodService.get(top.getGoodId()));
        }
        return goods;
    }
}
