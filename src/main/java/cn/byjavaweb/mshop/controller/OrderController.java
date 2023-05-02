package cn.byjavaweb.mshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/order")
public class OrderController {
//    /**
//     * 订单列表
//     *
//     * @return
//     */
//    @RequestMapping("/orderList")
//    public String orderList(@RequestParam(required=false, defaultValue="0")byte status, HttpServletRequest request,
//                            @RequestParam(required=false, defaultValue="1") int page) {
//        request.setAttribute("flag", 1);
//        request.setAttribute("status", status);
//        request.setAttribute("orderList", orderService.getList(status, page, rows));
//        request.setAttribute("pageTool", PageUtil.getPageTool(request, orderService.getTotal(status), page, rows));
//        return "/admin/order_list.jsp";
//    }
//
//    /**
//     * 订单发货
//     *
//     * @return
//     */
//    @RequestMapping("/orderDispose")
//    public String orderDispose(int id, byte status,
//                               @RequestParam(required=false, defaultValue="1") int page) {
//        orderService.dispose(id);
//        return "redirect:orderList?flag=1&status="+status+"&page="+page;
//    }
//
//    /**
//     * 订单完成
//     *
//     * @return
//     */
//    @RequestMapping("/orderFinish")
//    public String orderFinish(int id, byte status,
//                              @RequestParam(required=false, defaultValue="1") int page) {
//        orderService.finish(id);
//        return "redirect:orderList?flag=1&status="+status+"&page="+page;
//    }
//
//    /**
//     * 订单删除
//     *
//     * @return
//     */
//    @RequestMapping("/orderDelete")
//    public String orderDelete(int id, byte status,
//                              @RequestParam(required=false, defaultValue="1") int page) {
//        orderService.delete(id);
//        return "redirect:orderList?flag=1&status="+status+"&page="+page;
//    }
}
