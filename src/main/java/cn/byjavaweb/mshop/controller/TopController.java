package cn.byjavaweb.mshop.controller;

import cn.byjavaweb.mshop.entity.Tops;
import cn.byjavaweb.mshop.service.TopService;
import cn.byjavaweb.mshop.utils.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/top")
public class TopController {
    private static final int rows = 10; // 默认每页数量

    private final TopService topService;

    public TopController(TopService topService){
        this.topService = topService;
    }
    @GetMapping("/topList/{id}/{page}")
    public ResponseEntity<String> goodList(@PathVariable(name = "id") int id, @PathVariable(name = "page") int page) {
        return new ResponseUtil().response(topService.getList(id, page, rows), HttpStatus.OK);
    }

    /**
     * 添加推荐
     */
    @PostMapping("/topSave")
    public ResponseEntity<String> topSave(@RequestBody Tops tops) {
        if(tops.getType()==1){
         topService.cleanBanner();
        }
        Map<String, Object> msgMap = new HashMap<>();
        msgMap.put("success",topService.add(tops));
        return new ResponseUtil().response(msgMap,HttpStatus.OK);
    }

    /**
     * 删除推荐
     */
    @DeleteMapping("/topDelete")
    public ResponseEntity<String> topDelete(@RequestBody Tops tops) {
        Map<String, Object> msgMap = new HashMap<>();
        msgMap.put("success",topService.delete(tops));
        return new ResponseUtil().response(msgMap,HttpStatus.OK);
    }


    /**
     * 添加推荐
     */
    @PostMapping("/hotSave")
    public ResponseEntity<String> hotSave(@RequestBody Tops tops) {
        Map<String, Object> msgMap = new HashMap<>();
        msgMap.put("success",topService.add(tops));
        return new ResponseUtil().response(msgMap,HttpStatus.OK);
    }

    /**
     * 删除推荐
     */
    @DeleteMapping("/hotDelete")
    public ResponseEntity<String> hotDelete(@RequestBody Tops tops) {
        Map<String, Object> msgMap = new HashMap<>();
        msgMap.put("success",topService.delete(tops));
        return new ResponseUtil().response(msgMap,HttpStatus.OK);
    }
}
