package cn.byjavaweb.mshop.controller;

import cn.byjavaweb.mshop.entity.Admins;
import cn.byjavaweb.mshop.service.AdminService;
import cn.byjavaweb.mshop.utils.ResponseUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

    // 管理员列表, 10行
    private static final int rows = 10;

    private final AdminService adminService;

    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    /**
     * 管理员登录
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Admins admin, HttpSession session) {
        if(adminService.checkAdmin(admin)){
            session.setAttribute("username", admin.getUsername());
            // 登录成功
            // return "redirect:index";
            return new ResponseUtil().response("登录成功!",HttpStatus.OK);
        }
        // 登录失败
        // return "/admin/login.jsp";
        return new ResponseUtil().response("用户名或密码错误!",HttpStatus.UNAUTHORIZED);
    }

    /**
     * 退出
     */
    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.removeAttribute("admin");
        // 退出登录
        // return "/admin/login.jsp";
        return new ResponseUtil().response("退出成功",HttpStatus.OK);
    }

    /**
     * 管理员列表
     */
    @GetMapping("/admins/{page}")
    public ResponseEntity<String> getAdminList(@PathVariable(name = "page") int page) {
        Map<String, Object> msgMap = new HashMap<>();
        msgMap.put("adminList",adminService.getList(page, rows));
        // 返回管理员列表
        // return "/admin/admin_list.jsp";
        return new ResponseUtil().response(msgMap,HttpStatus.OK);
    }

    /**
     * 管理员修改自己密码
     */
    @PutMapping("/adminReset")
    public ResponseEntity<String> adminReset(@RequestBody Admins admin) {
        Map<String, Object> msgMap = new HashMap<>();
        // 前端加密密码后传输比对
        // 原始密码检查
        if(adminService.checkAdmin(admin)){
            // 设置新密码
            admin.setPassword(admin.getPassword());
            adminService.update(admin);
            msgMap.put("admin",admin);
            msgMap.put("status","修改成功!");
        }else {
            msgMap.put("status","原密码错误!");
        }
        // 返回管理员重置
        // return "/admin/admin_reset.jsp";
        return new ResponseUtil().response(msgMap,HttpStatus.OK);
    }

    /**
     * 管理员添加
     */
    @RequestMapping("/adminSave")
    public ResponseEntity<String> adminSave(Admins admin) {
        Map<String, Object> msgMap = new HashMap<>();
        if (adminService.getByUserName(admin.getUsername())!=null) {
            msgMap.put("status","用户名已存在!");
            // 返回新增
            // return "/admin/admin_add.jsp";
            return new ResponseUtil().response(msgMap,HttpStatus.BAD_REQUEST);
        }
        adminService.add(admin);
        msgMap.put("status","添加成功!");
        // 返回管理员页
        // return "redirect:adminList?flag=5&page="+page;
        return new ResponseUtil().response(msgMap,HttpStatus.OK);
    }

    /**
     * 管理员修改
     */
    @RequestMapping("/adminEdit")
    public ResponseEntity<String> adminEdit(int id) {
        Map<String, Object> msgMap = new HashMap<>();
        msgMap.put("admin",adminService.get(id));
        // 返回 管理员修改
        // return "/admin/admin_edit.jsp";
        return new ResponseUtil().response(msgMap,HttpStatus.OK);
    }

    /**
     * 管理员更新
     */
    @RequestMapping("/adminUpdate")
    public ResponseEntity<String> adminUpdate(Admins admin) {
        Map<String, Object> msgMap = new HashMap<>();
        admin.setPassword(admin.getPassword());
        adminService.update(admin);
        msgMap.put("flag","更新成功");
        // return "redirect:adminList?flag=5&page="+page;
        return new ResponseUtil().response(msgMap,HttpStatus.OK);
    }

    /**
     * 管理员删除
     */
    @RequestMapping("/adminDelete")
    public ResponseEntity<String> adminDelete(Admins admin, @RequestParam(required=false, defaultValue="1") int page) {
        Map<String, Object> responseMap = new HashMap<>();
        Map<String, Object> msgMap = new HashMap<>();
        adminService.delete(admin);
        msgMap.put("flag","删除成功!");
        // 刷新页面
        // return "redirect:adminList?flag=5&page="+page;
        return new ResponseUtil().response(msgMap,HttpStatus.OK);
    }
}
