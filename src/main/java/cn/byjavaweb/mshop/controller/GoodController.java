package cn.byjavaweb.mshop.controller;

import cn.byjavaweb.mshop.entity.Goods;
import cn.byjavaweb.mshop.service.GoodService;
import cn.byjavaweb.mshop.service.TopService;
import cn.byjavaweb.mshop.utils.ResponseUtil;
import cn.byjavaweb.mshop.utils.UploadUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/good")
public class GoodController {

    private static final int rows = 10; // 默认每页数量

    private final GoodService goodService;

    private final TopService topService;

    public GoodController(GoodService goodService,TopService topService){
        this.goodService = goodService;
        this.topService = topService;
    }

    /**
     * 产品列表 分页
     * @return msg:Goods[]
     */
    @GetMapping("/goodList/{id}/{page}")
    public ResponseEntity<String> goodList(@PathVariable(name = "id") int id, @PathVariable(name = "page") int page) {
        return new ResponseUtil().response(goodService.getList(id, page, rows), HttpStatus.OK);
    }

    /**
     * 产品列表 全部
     * @return msg:Goods[]
     */
    @GetMapping("/goodList")
    public ResponseEntity<String> allGoods(){
        Map<String, Object> msgMap = new HashMap<>();
        msgMap.put("all",goodService.getAll());
        msgMap.put("ibanner", topService.getAll(1));
        msgMap.put("ihot", topService.getAll(2));
        msgMap.put("inew", topService.getAll(3));
        return new ResponseUtil().response(msgMap,HttpStatus.OK);
    }

    /**
     *
     * @param goods 传入商品id即可
     * @return msg:{success: boolean}
     */
    @DeleteMapping("/goodDelete")
    public ResponseEntity<String> goodDelete(@RequestBody Goods goods){
        Map<String, Object> msgMap = new HashMap<>();
        msgMap.put("success",goodService.delete(goods.getId()));
        return new ResponseUtil().response(msgMap,HttpStatus.OK);
    }

    @PutMapping("/goodUpdate")
    public ResponseEntity<String> goodUpdate(@RequestBody Goods goods){
        Map<String, Object> msgMap = new HashMap<>();
        msgMap.put("success",goodService.update(goods));
        return new ResponseUtil().response(msgMap,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Goods goods){
        Map<String, Object> msgMap = new HashMap<>();
        msgMap.put("success",goodService.add(goods));
        return new ResponseUtil().response(msgMap,HttpStatus.OK);
    }

    @PostMapping("/fileUpload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) throws FileNotFoundException {
        return new ResponseUtil().response(new UploadUtil().saveFile(file),HttpStatus.OK);
    }
}
