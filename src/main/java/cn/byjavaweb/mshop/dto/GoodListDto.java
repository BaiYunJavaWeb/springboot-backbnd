package cn.byjavaweb.mshop.dto;

import cn.byjavaweb.mshop.entity.Goods;


public record GoodListDto(
        int flag,
        int page,
        byte status,
        Goods[] goodList
) {

}
