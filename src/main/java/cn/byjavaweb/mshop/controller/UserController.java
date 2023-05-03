package cn.byjavaweb.mshop.controller;

import cn.byjavaweb.mshop.entity.Users;
import cn.byjavaweb.mshop.service.UserService;
import cn.byjavaweb.mshop.utils.ResponseUtil;
import cn.byjavaweb.mshop.utils.SafeUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Users users) {
        Users users1 = userService.checkUser(users);
        if(users1==null){
            userService.add(users);
            return new ResponseUtil().response("注册成功!", HttpStatus.OK);
        }else{
            return new ResponseUtil().response("该用户名已存在!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Users users) {
        Users users1 = userService.checkUser(users);
        if(users1==null||!users1.getPassword().equals(users.getPassword())){
            return new ResponseUtil().response("账号或密码错误!", HttpStatus.UNAUTHORIZED);
        }else {
            return new ResponseUtil().response("登录成功!", HttpStatus.OK);
        }
    }
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
