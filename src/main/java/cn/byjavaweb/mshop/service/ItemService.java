package cn.byjavaweb.mshop.service;

import cn.byjavaweb.mshop.entity.Items;
import cn.byjavaweb.mshop.mapper.ItemsMapper;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final ItemsMapper itemsMapper;
    public ItemService(ItemsMapper itemsMapper){
        this.itemsMapper = itemsMapper;
    }

    public Items getByOrderID(int orderId){
        return itemsMapper.getByOrderID(orderId);
    }
}
