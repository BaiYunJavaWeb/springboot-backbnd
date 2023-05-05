package cn.byjavaweb.mshop.controller;

import cn.byjavaweb.mshop.entity.Types;
import cn.byjavaweb.mshop.service.TypeService;
import cn.byjavaweb.mshop.utils.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 类目添加
     */
    @PostMapping("/typeSave")
    public ResponseEntity<String> typeSave(@RequestBody Types types) {
        typeService.add(types);
        return new ResponseUtil().response("类目添加成功!", HttpStatus.OK);
    }

    /**
     * 类目更新
     */
    @PutMapping("/typeUpdate")
    public ResponseEntity<String> typeUpdate(@RequestBody Types types) {
        typeService.update(types);
        return new ResponseUtil().response("类目更新成功!", HttpStatus.OK);
    }

    /**
     * 类目删除
     */
    @DeleteMapping("/typeDelete")
    public ResponseEntity<String> typeDelete(@RequestBody Types types) {
        Map<String, Object> msgMap = new HashMap<>();
        msgMap.put("success",typeService.delete(types));
        return new ResponseUtil().response(msgMap,HttpStatus.OK);
    }
}
