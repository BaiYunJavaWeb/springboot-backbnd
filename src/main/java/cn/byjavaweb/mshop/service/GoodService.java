package cn.byjavaweb.mshop.service;

import cn.byjavaweb.mshop.entity.Goods;
import cn.byjavaweb.mshop.entity.Tops;
import cn.byjavaweb.mshop.mapper.GoodsMapper;
import cn.byjavaweb.mshop.mapper.TopsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class GoodService {
    
    private final GoodsMapper goodsMapper;
    private final TopsMapper topsMapper;
    private final TypeService typeService;
    private final Logger logger = LoggerFactory.getLogger(getClass());
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
    
//    public Goods get(int id){
//        return goodsMapper.selectById(id);
//    }
    public List<Goods> getList(int status, int page, int size) {
        if (status == 0) {
            return goodsMapper.getList(size * (page-1), size);
        }
        List<Tops> topList = getTopList((byte)status, page, size);
        if(topList!=null && !topList.isEmpty()) {
            return topList.stream()
                           .map(top -> goodsMapper.selectById(top.getGoodId()))
                           .toList();
        }
        logger.warn("奇怪的条件");
        return null;
    }
    
    public ArrayList<Goods> getTopList(int type, int page, int size){
        List<Tops> topList = topsMapper.getList(type, (page-1)*size, size);
        ArrayList<Goods> goods = new ArrayList<>();
        for (Tops top:topList) {
            goods.add(this.get(top.getGoodId()));
        }
        return goods;
    }
    
    public long getTotal(int status){
        if (status == 0) {
            return goodsMapper.getTotal();
        }
        return getTopTotal((byte)status);
    }
    
    /**
     * 通过名称获取产品列表
     * @param page
     * @param size
     * @return
     */
    public List<Goods> getListByName(String name, int page, int size){
        return goodsMapper.getListByName(name, size * (page-1), size);
    }
    
    /**
     * 通过名称获取产品总数
     * @return
     */
    public long getTotalByName(String name){
        return goodsMapper.getTotalByName(name);
    }
    
    /**
     * 通过分类搜索
     * @param typeid
     * @param page
     * @param size
     * @return
     */
    public List<Goods> getListByType(int typeid, int page, int size) {
        return typeid > 0 ? goodsMapper.getListByType(typeid, size * (page-1), size) : goodsMapper.getList(size * (page-1), size);
    }
    
    /**
     * 获取数量
     * @param typeid
     * @return
     */
    public long getTotalByType(int typeid){
        return typeid > 0 ? goodsMapper.getTotalByType(typeid) : goodsMapper.getTotal();
    }
    
    /**
     * 通过id获取
     * @return
     */
    public Goods get(int id) {
        return goodsMapper.selectById(id);
    }
    
    /**
     * 添加
     */
    public Integer add(Goods good) {
        return goodsMapper.insert(good);
    }
    
    /**
     * 修改
     * @return ?
     */
    public boolean update(Goods good) {
        return goodsMapper.updateById(good) > 0;
    }
    
    /**
     * 删除商品
     * 先删除此商品的推荐信息
     * @param goodid ?
     */
    public boolean delete(int goodid) {
        deleteTopByGoodid(goodid);
        return goodsMapper.deleteById(goodid) > 0;
    }
    
    
    /**
     * 封装商品推荐信息
     * @param list
     * @return
     */
    private List<Goods> packTopList(List<Goods> list) {
        for(Goods good : list) {
            good.setTypeId(typeService.get(good.getTypeId()).getId());
            good = packTop(good);
        }
        return list;
    }
    
    /**
     * 封装商品推荐信息
     * @param good
     * @return
     */
    private Goods packTop(Goods good) {
        return good;
    }
    
    /**
     * 获取列表
     * @return
     */
    public List<Tops> getTopList(byte type, int page, int size){
        return topsMapper.getList(type, (page - 1) * size, size);
    }
    
    /**
     * 获取总数
     * @param type
     * @return
     */
    public long getTopTotal(byte type) {
        return topsMapper.getTotal(type);
    }
    
    /**
     * 获取列表
     * @return
     */
    public List<Tops> getTopListByGoodid(int goodid){
        return topsMapper.getListByGoodid(goodid);
    }
    
    /**
     * 通过id查询
     * @param id
     * @return
     */
    public Tops getTop(int id) {
        return topsMapper.selectById(id);
    }
    
    /**
     * 添加
     * @param top
     * @return
     */
    public Integer addTop(Tops top) {
        return topsMapper.insert(top);
    }
    
    /**
     * 更新
     * @param top
     */
    public boolean updateTop(Tops top) {
        return topsMapper.updateById(top) > 0;
    }
    
    /**
     * 删除
     * @param top
     */
    public boolean deleteTop(Tops top) {
        return (Objects.nonNull(top.getId())) ? (topsMapper.deleteById(top.getId()) > 0) :
               topsMapper.deleteByGoodidAndType(top.getGoodId(), top.getType());
    }
    
    /**
     * 按商品删除
     * @param goodid
     * @return
     */
    public boolean deleteTopByGoodid(int goodid) {
        return topsMapper.deleteByGoodid(goodid);
    }
    
    
}
