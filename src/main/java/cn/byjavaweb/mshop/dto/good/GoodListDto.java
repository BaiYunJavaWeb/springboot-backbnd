package cn.byjavaweb.mshop.dto.good;

import cn.byjavaweb.mshop.entity.Goods;


public record GoodListDto(
        int flag,
        int page,
        byte status,
        java.util.List<Goods> goodList
) {

}
