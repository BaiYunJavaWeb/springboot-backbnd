package cn.byjavaweb.mshop.controller;

import cn.byjavaweb.mshop.service.TypeService;
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
@RequestMapping("/type")
public class TypeController {
    private final TypeService typeService;

    public TypeController(TypeService typeService){
        this.typeService = typeService;
    }
    /**
     * 类目列表
     */
    @GetMapping("/typeList")
    public ResponseEntity<String> typeList() {
        Map<String, Object> msgMap = new HashMap<>();
        msgMap.put("typeList",typeService.getList());
        return new ResponseUtil().response(msgMap, HttpStatus.OK);
    }
//
//    /**
//     * 类目添加
//     *
//     * @return
//     */
//    @RequestMapping("/typeSave")
//    public String typeSave(Types type,
//                           @RequestParam(required=false, defaultValue="1") int page) {
//        typeService.add(type);
//        return "redirect:typeList?flag=4&page="+page;
//    }
//
//    /**
//     * 类目更新
//     *
//     * @return
//     */
//    @RequestMapping("/typeEdit")
//    public String typeUp(int id, HttpServletRequest request) {
//        request.setAttribute("flag", 4);
//        request.setAttribute("type", typeService.get(id));
//        return "/admin/type_edit.jsp";
//    }
//
//    /**
//     * 类目更新
//     *
//     * @return
//     */
//    @RequestMapping("/typeUpdate")
//    public String typeUpdate(Types type,
//                             @RequestParam(required=false, defaultValue="1") int page) {
//        typeService.update(type);
//        return "redirect:typeList?flag=4&page="+page;
//    }
//
//    /**
//     * 类目删除
//     *
//     * @return
//     */
//    @RequestMapping("/typeDelete")
//    public String typeDelete(Types type,
//                             @RequestParam(required=false, defaultValue="1") int page) {
//        typeService.delete(type);
//        return "redirect:typeList?flag=4&page="+page;
//    }
}
