package cn.byjavaweb.mshop.controller;

import cn.byjavaweb.mshop.service.GoodService;
import cn.byjavaweb.mshop.utils.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/good")
public class GoodController {

    private static final int rows = 10; // 默认每页数量

    private final GoodService goodService;

    public GoodController(GoodService goodService){
        this.goodService = goodService;
    }

//    /**
//     * 产品列表
//     *
//     * @return
//     */
    @GetMapping("/goodList/{id}/{page}")
    public ResponseEntity<String> goodList(@PathVariable(name = "id") int id, @PathVariable(name = "page") int page) {
        return new ResponseUtil().response(goodService.getList(id, page, rows), HttpStatus.OK);
    }
//
//    /**
//     * 产品添加
//     *
//     * @return
//     */
//    @RequestMapping("/goodAdd")
//    public String goodAdd(HttpServletRequest request) {
//        request.setAttribute("flag", 3);
//        request.setAttribute("typeList", typeService.getList());
//        return "/admin/good_add.jsp";
//    }
//
//    /**
//     * 产品添加
//     *
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping("/goodSave")
//    public String goodSave(String name, int price, String intro, int stock, int typeId,
//                           MultipartFile cover, MultipartFile image1, MultipartFile image2,
//                           @RequestParam(required=false, defaultValue="1") int page) throws Exception {
//        Goods good = new Goods();
//        good.setName(name);
//        good.setPrice(price);
//        good.setIntro(intro);
//        good.setStock(stock);
//        good.setTypeId(typeId);
//        good.setCover(UploadUtil.fileUpload(cover));
//        good.setImage1(UploadUtil.fileUpload(image1));
//        good.setImage2(UploadUtil.fileUpload(image2));
//        goodService.add(good);
//        return "redirect:goodList?flag=3&page="+page;
//    }
//
//    /**
//     * 产品更新
//     *
//     * @return
//     */
//    @RequestMapping("/goodEdit")
//    public String goodEdit(int id, HttpServletRequest request) {
//        request.setAttribute("flag", 3);
//        request.setAttribute("typeList", typeService.getList());
//        request.setAttribute("good", goodService.get(id));
//        return "/admin/good_edit.jsp";
//    }
//
//    /**
//     * 产品更新
//     *
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping("/goodUpdate")
//    public String goodUpdate(int id, String name, int price, String intro, int stock, int typeId,
//                             MultipartFile cover, MultipartFile image1, MultipartFile image2,
//                             @RequestParam(required=false, defaultValue="1") int page) throws Exception {
//        Goods good = goodService.get(id);
//        good.setName(name);
//        good.setPrice(price);
//        good.setIntro(intro);
//        good.setStock(stock);
//        good.setTypeId(typeId);
//        if (Objects.nonNull(cover) && !cover.isEmpty()) {
//            good.setCover(UploadUtil.fileUpload(cover));
//        }
//        if (Objects.nonNull(image1) && !image1.isEmpty()) {
//            good.setImage1(UploadUtil.fileUpload(image1));
//        }
//        if (Objects.nonNull(image2) && !image2.isEmpty()) {
//            good.setImage2(UploadUtil.fileUpload(image2));
//        }
//        goodService.update(good);
//        return "redirect:goodList?flag=3&page="+page;
//    }
//
//    /**
//     * 产品删除
//     *
//     * @return
//     */
//    @RequestMapping("/goodDelete")
//    public String goodDelete(int id,
//                             @RequestParam(required=false, defaultValue="1") int page) {
//        goodService.delete(id);
//        return "redirect:goodList?flag=3&page="+page;
//    }

}
