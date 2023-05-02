package cn.byjavaweb.mshop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/user")
public class UserController {

//    /**
//     * 顾客管理
//     *
//     * @return
//     */
//    @RequestMapping("/userList")
//    public String userList(HttpServletRequest request,
//                           @RequestParam(required=false, defaultValue="1") int page) {
//        request.setAttribute("flag", 2);
//        request.setAttribute("userList", userService.getList(page, rows));
//        request.setAttribute("pageTool", PageUtil.getPageTool(request, userService.getTotal(), page, rows));
//        return "/admin/user_list.jsp";
//    }
//
//    /**
//     * 顾客添加
//     *
//     * @return
//     */
//    @RequestMapping("/userAdd")
//    public String userAdd(HttpServletRequest request) {
//        request.setAttribute("flag", 2);
//        return "/admin/user_add.jsp";
//    }
//
//    /**
//     * 顾客添加
//     *
//     * @return
//     */
//    @RequestMapping("/userSave")
//    public String userSave(Users user, HttpServletRequest request,
//                           @RequestParam(required=false, defaultValue="1") int page) {
//        if (userService.isExist(user.getUsername())) {
//            request.setAttribute("msg", "用户名已存在!");
//            return "/admin/user_add.jsp";
//        }
//        userService.add(user);
//        return "redirect:userList?flag=2&page="+page;
//    }
//
//    /**
//     * 顾客密码重置页面
//     *
//     * @return
//     */
//    @RequestMapping("/userRe")
//    public String userRe(int id, HttpServletRequest request) {
//        request.setAttribute("flag", 2);
//        request.setAttribute("user", userService.get(id));
//        return "/admin/user_reset.jsp";
//    }
//
//    /**
//     * 顾客密码重置
//     *
//     * @return
//     */
//    @RequestMapping("/userReset")
//    public String userReset(Users user,
//                            @RequestParam(required=false, defaultValue="1") int page) {
//        String password = SafeUtil.encode(user.getPassword());
//        user = userService.get(user.getId());
//        user.setPassword(password);
//        userService.update(user);
//        return "redirect:userList?flag=2&page="+page;
//    }
//
//    /**
//     * 顾客更新
//     *
//     * @return
//     */
//    @RequestMapping("/userEdit")
//    public String userEdit(int id, HttpServletRequest request) {
//        request.setAttribute("flag", 2);
//        request.setAttribute("user", userService.get(id));
//        return "/admin/user_edit.jsp";
//    }
//
//    /**
//     * 顾客更新
//     *
//     * @return
//     */
//    @RequestMapping("/userUpdate")
//    public String userUpdate(Users user,
//                             @RequestParam(required=false, defaultValue="1") int page) {
//        userService.update(user);
//        return "redirect:userList?flag=2&page="+page;
//    }
//
//    /**
//     * 顾客删除
//     *
//     * @return
//     */
//    @RequestMapping("/userDelete")
//    public String userDelete(Users user,
//                             @RequestParam(required=false, defaultValue="1") int page) {
//        userService.delete(user);
//        return "redirect:userList?flag=2&page="+page;
//    }
}
