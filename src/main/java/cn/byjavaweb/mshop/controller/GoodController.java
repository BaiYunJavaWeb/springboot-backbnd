package cn.byjavaweb.mshop.controller;

import cn.byjavaweb.mshop.dto.good.GoodAddDto;
import cn.byjavaweb.mshop.dto.good.GoodListDto;
import cn.byjavaweb.mshop.dto.BoolSucceedDto;
import cn.byjavaweb.mshop.entity.Goods;
import cn.byjavaweb.mshop.service.GoodService;
import cn.byjavaweb.mshop.utils.ResponseUtil;
import cn.byjavaweb.mshop.utils.UploadUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static java.util.Objects.*;

@RestController()
@RequestMapping("/good")
public class GoodController {
    private static final int RowsInPage = 10;
    private final GoodService goodService;
    
    public GoodController(GoodService goodService) {
        this.goodService = goodService;
    }
    
    /**
     *
     * @param status 0查询全部，其它查询推荐列表
     * @param page 一页10条
     * @return type GoodListDto = { flag:number, page: number, status: number, goodList: Goods[]}
     */
    @RequestMapping("/goodList")
    public ResponseEntity<String> goodList(
            @RequestParam(required = false, defaultValue = "0") byte status,
            @RequestParam(required = false, defaultValue = "1") int page
    ) {
        return ResponseUtil.makeResponse(
            new GoodListDto(
                    3, page, status,
                    goodService.getList(status, page, RowsInPage)
                    ),
            HttpStatus.OK);
    }
    
    /**
     *
     * @return type GoodAddResult = { id: number }
     */
    @RequestMapping(value = "/goodSave", method = RequestMethod.POST)
    public ResponseEntity<String> goodAddRecord(
            String name, int price, String intro, int stock, int typeId,
            MultipartFile cover, MultipartFile image1, MultipartFile image2
    ) throws Exception {
        Goods good = new Goods();
        setGoodBasics(name, price, intro, stock, typeId, good);
    
        good.setCover(UploadUtil.fileUpload(cover));
        good.setImage1(UploadUtil.fileUpload(image1));
        good.setImage2(UploadUtil.fileUpload(image2));
    
        return ResponseUtil.makeResponse(new GoodAddDto(goodService.add(good)), HttpStatus.OK);
    }
    
    private void setGoodBasics(String name, int price, String intro, int stock, int typeId, Goods good) {
        good.setTypeId(typeId);
        good.setIntro(intro);
        good.setName(name);
        good.setPrice(price);
        good.setStock(stock);
    }

    /**
     * 产品更新
     *
     * @return type BoolSucceedDto = { success: boolean }
     */
    @RequestMapping("/goodUpdate")
    public ResponseEntity<String> goodUpdate(int id, String name, int price, String intro, int stock, int typeId,
                             MultipartFile cover, MultipartFile image1, MultipartFile image2,
                             @RequestParam(required=false, defaultValue="1") int page) throws Exception {
        Goods good = goodService.get(id);
        setGoodBasics(name, price, intro, stock, typeId, good);
    
        if (nonNull(cover) && !cover.isEmpty()) {
            good.setCover(UploadUtil.fileUpload(cover));
        }
        if (nonNull(image1) && !image1.isEmpty()) {
            good.setImage1(UploadUtil.fileUpload(image1));
        }
        if (nonNull(image2) && !image2.isEmpty()) {
            good.setImage2(UploadUtil.fileUpload(image2));
        }
        return ResponseUtil.makeResponse(
                new BoolSucceedDto(goodService.update(good)),
                HttpStatus.OK);
    }
//
//    /**
//     * 产品删除
//     *
//     * @return type BoolSucceedDto = { success: boolean }
//     */
    @RequestMapping("/goodDelete")
    public ResponseEntity<String> goodDelete(int id,
                             @RequestParam(required=false, defaultValue="1") int page) {
        return ResponseUtil.makeResponse(
                new BoolSucceedDto(goodService.delete(id)),
                HttpStatus.OK);
    }

}
