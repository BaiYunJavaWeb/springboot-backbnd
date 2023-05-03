package cn.byjavaweb.mshop.controller;

import cn.byjavaweb.mshop.service.GoodService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/top")
public class TopController {

    private final GoodService svc;
    
    public TopController(GoodService svc) {
        this.svc = svc;
    }
//    /**
//     * 添加推荐(后台)
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
//     * 删除推荐（后台）
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
