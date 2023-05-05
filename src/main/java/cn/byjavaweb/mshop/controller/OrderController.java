package cn.byjavaweb.mshop.controller;

import cn.byjavaweb.mshop.service.OrderService;
import cn.byjavaweb.mshop.utils.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController()
@CrossOrigin
@RequestMapping("/order")
public class OrderController {
	private static final int RowsPerPage = 10;
	private final OrderService service;
	
	public OrderController(OrderService service)
	{
		this.service = service;
	}
	
	/**
	 * 查询订单列表
	 * @param page 页码
	 * @param status 1：未付款 2：已付款 3：配送中 4：已完成
	 * @return Orders[]
	 */
	@GetMapping("/orderList/{status}/{page}")
	public ResponseEntity<String> orderList(
			@PathVariable(name = "page", required = false) int page,
			@PathVariable(name = "status") int status
	) {
		return new ResponseUtil().response(
				service.getListOfStatus(
					status,
					(page - 1) * RowsPerPage,
					RowsPerPage),
				HttpStatus.OK);
	}
	
	/**
	 * 订单发货
	 * @param id 订单id
	 * @return {success: true}
	 */
	@PostMapping("/orderDispose/{id}")
	public ResponseEntity<String> orderDispose(
			@PathVariable(name = "id") int id
	) {
		service.dispose(id);
		var rsp = new HashMap<String, Object>();
		rsp.put("success", true);
		return new ResponseUtil().response(rsp, HttpStatus.OK);
	}
	
	/**
	 * 订单完成
	 * @param id 订单id
	 * @return {success: true}
	 */
	@PostMapping("/orderFinish/{id}")
	public ResponseEntity<String> orderFinish(
			@PathVariable(name = "id") int id
	) {
		service.finish(id);
		var rsp = new HashMap<String, Object>();
		rsp.put("success", true);
		return new ResponseUtil().response(rsp, HttpStatus.OK);
	}
	
	/**
	 * 删除订单
	 * @param id 订单id
	 * @return {success: true}
	 */
	@PostMapping("/orderDelete/{id}")
	public ResponseEntity<String> orderDelete(
			@PathVariable(name = "id") int id
	) {
		service.delete(id);
		var rsp = new HashMap<String, Object>();
		rsp.put("success", true);
		return new ResponseUtil().response(rsp, HttpStatus.OK);
	}
}
