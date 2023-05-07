package cn.byjavaweb.mshop.controller;

import cn.byjavaweb.mshop.service.TopService;
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
    private final TopService topService;

    public IndexController(TopService topService) {
        this.topService = topService;
    }

    /**
     * 首页推荐 banner 热销 新品
     */
    @GetMapping("/index")
    public ResponseEntity<String> index() {
        Map<String, Object> msgMap = new HashMap<>();
        msgMap.put("ibanner", topService.getList(1, 1, 1));
        msgMap.put("ihot", topService.getList(2, 1, 6));
        msgMap.put("inew", topService.getList(3, 1, 8));
        return new ResponseUtil().response(msgMap, HttpStatus.OK);
    }
}
