package cn.byjavaweb.mshop.service;

import cn.byjavaweb.mshop.entity.Goods;
import cn.byjavaweb.mshop.entity.Tops;
import cn.byjavaweb.mshop.mapper.TopsMapper;
import net.sf.jsqlparser.statement.select.Top;
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

    public ArrayList<Goods> getAll(int type){
        List<Tops> topsList = topsMapper.getAll(type);
        ArrayList<Goods> goods = new ArrayList<>();
        for (Tops top:topsList) {
            goods.add(goodService.get(top.getGoodId()));
        }
        return goods;
    }

    public boolean add(Tops tops){
        return topsMapper.insert(tops) > 0;
    }

    public boolean delete(Tops tops){
        List<Tops> tops1 = topsMapper.getAll(tops.getType());
        Integer currentId = null;
        for (Tops tops2:tops1) {
            if(tops2.getGoodId().equals(tops.getGoodId())){
                currentId = tops2.getId();
            }
        }
        return topsMapper.deleteById(currentId) > 0;
    }
}
