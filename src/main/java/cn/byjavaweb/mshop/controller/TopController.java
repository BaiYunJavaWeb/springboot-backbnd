package cn.byjavaweb.mshop.controller;

import cn.byjavaweb.mshop.service.TopService;
import cn.byjavaweb.mshop.utils.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

//    /**
//     * 添加推荐
//     * @return
//     */
//    @RequestMapping("/topSave")
//    public @ResponseBody String topSave(Tops tops,
//                                        @RequestParam(required=false, defaultValue="0")byte status,
//                                        @RequestParam(required=false, defaultValue="1") int page) {
//        int id = topService.add(tops);
//        return id > 0 ? "ok" : null;
//    }
//
//    /**
//     * 删除推荐
//     * @return
//     */
//    @RequestMapping("/topDelete")
//    public @ResponseBody String topDelete(Tops tops,
//                                          @RequestParam(required=false, defaultValue="0")byte status,
//                                          @RequestParam(required=false, defaultValue="1") int page) {
//        boolean flag = topService.delete(tops);
//        return flag ? "ok" : null;
//    }
}
