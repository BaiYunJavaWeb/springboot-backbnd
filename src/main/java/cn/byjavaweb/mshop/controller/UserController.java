package cn.byjavaweb.mshop.controller;

import cn.byjavaweb.mshop.entity.Users;
import cn.byjavaweb.mshop.service.UserService;
import cn.byjavaweb.mshop.utils.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    @GetMapping("/userList")
    public ResponseEntity<String> all(){
        return new ResponseUtil().response(userService.all(),HttpStatus.OK);
    }

    @DeleteMapping("/userDelete")
    public ResponseEntity<String> goodDelete(@RequestBody Users users){
        Map<String, Object> msgMap = new HashMap<>();
        msgMap.put("success",userService.delete(users.getId()));
        return new ResponseUtil().response(msgMap,HttpStatus.OK);
    }

    @PutMapping("/userUpdate")
    public ResponseEntity<String> userUpdate(@RequestBody Users users){
        Map<String, Object> msgMap = new HashMap<>();
        msgMap.put("success",userService.update(users));
        return new ResponseUtil().response(msgMap,HttpStatus.OK);
    }

    @PostMapping("/reset")
    public ResponseEntity<String> userReset(@RequestBody Users users){
        Map<String, Object> msgMap = new HashMap<>();
        msgMap.put("success",userService.resetPsw(users));
        return new ResponseUtil().response(msgMap,HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<String> findUser(@PathVariable(name = "name") String name){
        Map<String, Object> msgMap = new HashMap<>();
        Users users = userService.findUserByName(name);
        msgMap.put("id",users.getId());
        msgMap.put("username",users.getUsername());
        msgMap.put("name",users.getName());
        msgMap.put("phone",users.getPhone());
        msgMap.put("address",users.getAddress());
        return new ResponseUtil().response(msgMap,HttpStatus.OK);
    }

    @PutMapping("/updateInfo")
    public ResponseEntity<String> updateInfo(@RequestBody Users users){
        Map<String, Object> msgMap = new HashMap<>();
        Users users1 = userService.findUserById(users);
        users1.setName(users.getName());
        users1.setPhone(users.getPhone());
        users1.setAddress(users.getAddress());
        userService.update(users1);
        msgMap.put("success",true);
        return new ResponseUtil().response(msgMap,HttpStatus.OK);
    }

    @PutMapping("/updatePsw")
    public ResponseEntity<String> updatePsw(@RequestBody Users users){
        Map<String, Object> msgMap = new HashMap<>();
        Users users1 = userService.findUserById(users);
        // 此处username为用户原始密码
        if(users1.getPassword().equals(users.getUsername())){
            users1.setPassword(users.getPassword());
            userService.update(users1);
            msgMap.put("success",true);
            return new ResponseUtil().response(msgMap,HttpStatus.OK);
        }else{
            msgMap.put("success",false);
            return new ResponseUtil().response(msgMap,HttpStatus.BAD_REQUEST);
        }
    }
}
