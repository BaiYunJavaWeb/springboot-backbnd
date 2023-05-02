package cn.byjavaweb.mshop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/type")
public class TypeController {
//    /**
//     * 类目列表
//     *
//     * @return
//     */
//    @RequestMapping("/typeList")
//    public String typeList(HttpServletRequest request) {
//        request.setAttribute("flag", 4);
//        request.setAttribute("typeList", typeService.getList());
//        return "/admin/type_list.jsp";
//    }
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
