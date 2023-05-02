package cn.byjavaweb.mshop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/good")
public class GoodController {

//    /**
//     * 产品列表
//     *
//     * @return
//     */
//    @RequestMapping("/goodList")
//    public String goodList(@RequestParam(required=false, defaultValue="0")byte status, HttpServletRequest request,
//                           @RequestParam(required=false, defaultValue="1") int page) {
//        request.setAttribute("flag", 3);
//        request.setAttribute("page", page);
//        request.setAttribute("status", status);
//        request.setAttribute("goodList", goodService.getList(status, page, rows));
//        request.setAttribute("pageTool", PageUtil.getPageTool(request, goodService.getTotal(status), page, rows));
//        return "/admin/good_list.jsp";
//    }
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
