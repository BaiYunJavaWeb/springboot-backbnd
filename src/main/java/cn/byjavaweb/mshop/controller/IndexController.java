package cn.byjavaweb.mshop.controller;

import cn.byjavaweb.mshop.service.GoodService;
import cn.byjavaweb.mshop.utils.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/index")
public class IndexController {
    private static final int rows = 16; // 默认每页数量
    
    public IndexController(GoodService goodService) {
        this.goodService = goodService;
    }
    
    private final GoodService goodService;
    

    /**
     * 首页推荐 banner 热销 新品
     */
    @GetMapping("/index")
    public ResponseEntity<String> index(){
        Map<String, Object> msgMap = new HashMap<>();
        msgMap.put("ibanner", goodService.getTopList(1, 1, 1));
        msgMap.put("ihot", goodService.getTopList(2, 1, 6));
        msgMap.put("inew", goodService.getTopList(3, 1, 8));
        return new ResponseUtil().response(msgMap, HttpStatus.OK);
    }
}
