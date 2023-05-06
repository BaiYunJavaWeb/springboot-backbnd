package cn.byjavaweb.mshop.controller;

import cn.byjavaweb.mshop.dto.OrderAddDto;
import cn.byjavaweb.mshop.dto.OrderMergeDto;
import cn.byjavaweb.mshop.entity.Goods;
import cn.byjavaweb.mshop.entity.Items;
import cn.byjavaweb.mshop.entity.Orders;
import cn.byjavaweb.mshop.entity.Users;
import cn.byjavaweb.mshop.service.GoodService;
import cn.byjavaweb.mshop.service.ItemService;
import cn.byjavaweb.mshop.service.OrderService;
import cn.byjavaweb.mshop.utils.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController()
@CrossOrigin
@RequestMapping("/order")
public class OrderController {
	private static final int RowsPerPage = 10;
	private final OrderService service;
	private final ItemService itemService;
	private final GoodService goodService;

	/** 订单状态 - 未付款 */
	public static final byte STATUS_UNPAY = 1;
	/** 订单状态 - 已付款 */
	public static final byte STATUS_PAYED = 2;
	/** 订单状态 - 配送中 */
	public static final byte STATUS_SEND = 3;
	/** 订单状态 - 已完成 */
	public static final byte STATUS_FINISH = 4;

	public OrderController(OrderService service, ItemService itemService, GoodService goodService) {
		this.service = service;
		this.itemService = itemService;
		this.goodService = goodService;
	}

	/**
	 * 查询订单列表
	 * 
	 * @param page   页码
	 * @param status 1：未付款 2：已付款 3：配送中 4：已完成
	 * @return Orders[]
	 */
	@GetMapping("/orderList/{status}/{page}")
	public ResponseEntity<String> orderList(
			@PathVariable(name = "page", required = false) int page,
			@PathVariable(name = "status") int status) {
		return new ResponseUtil().response(
				service.getListOfStatus(
						status,
						(page - 1) * RowsPerPage,
						RowsPerPage),
				HttpStatus.OK);
	}

	@GetMapping("/orderList")
	public ResponseEntity<String> orderList() {
		List<Orders> ordersList = service.getAll();
		List<OrderMergeDto> orderDtos = ordersList.stream()
				.map(order -> {
					Items items = itemService.getByOrderID(order.getId());
					Goods goods = goodService.get(items.getGoodId());
					return new OrderMergeDto(
							order.getId(),
							order.getTotal(),
							order.getAmount(),
							order.getStatus(),
							order.getPaytype(),
							order.getName(),
							order.getPhone(),
							order.getAddress(),
							order.getSystime(),
							order.getUserId(),
							goods.getName());
				})
				.collect(Collectors.toList());
		return new ResponseUtil().response(orderDtos, HttpStatus.OK);
	}

	/**
	 * 订单状态修改
	 * 
	 * @return {success: boolean}
	 */
	@PutMapping("/orderStatus")
	public ResponseEntity<String> orderStatus(@RequestBody Orders orders) {
		Orders orders1 = service.getByID(orders);
		orders1.setStatus(orders.getStatus());
		var rsp = new HashMap<String, Object>();
		rsp.put("success", service.update(orders1));
		return new ResponseUtil().response(rsp, HttpStatus.OK);
	}

	/**
	 * 删除订单
	 * 
	 * @param id 订单id
	 * @return {success: true}
	 */
	@DeleteMapping("/orderDelete")
	public ResponseEntity<String> orderDelete(@RequestBody Orders order) {
		var rsp = new HashMap<String, Object>();
		rsp.put("success", service.delete(order.getId()));
		return new ResponseUtil().response(rsp, HttpStatus.OK);
	}

	@PostMapping("/orders")
	public ResponseEntity<String> getUserOrder(@RequestBody Users users) {
		List<Orders> ordersList = service.findOrdersByUID(users.getId());
		List<OrderMergeDto> orderDtos = ordersList.stream()
				.map(order -> {
					Items items = itemService.getByOrderID(order.getId());
					Goods goods = goodService.get(items.getGoodId());
					return new OrderMergeDto(
							order.getId(),
							order.getTotal(),
							order.getAmount(),
							order.getStatus(),
							order.getPaytype(),
							order.getName(),
							order.getPhone(),
							order.getAddress(),
							order.getSystime(),
							order.getUserId(),
							goods.getName());
				})
				.collect(Collectors.toList());
		return new ResponseUtil().response(orderDtos, HttpStatus.OK);
	}

	@PostMapping("/pay")
	public ResponseEntity<String> userPay(@RequestBody Orders orders) {
		Map<String, Object> msgMap = new HashMap<>();
		Orders orders1 = service.getByID(orders);
		// 1: 支付宝 2: 微信 3: 货到付款
		orders1.setPaytype(orders.getPaytype());
		orders1.setStatus(STATUS_PAYED);
		msgMap.put("success", service.update(orders1));
		return new ResponseUtil().response(msgMap, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<String> orderAdd(@RequestBody List<OrderAddDto> orderList) {
		for (OrderAddDto orderAddDto : orderList) {
			int order_id = service.add(orderAddDto);
			Items items = new Items();
			items.setAmount(orderAddDto.getAmount());
			items.setGoodId(orderAddDto.getGoodId());
			items.setOrderId(order_id);
			items.setPrice(orderAddDto.getTotal());
			itemService.addItem(items);
		}
		var rsp = new HashMap<String, Object>();
		rsp.put("success", true);
		return new ResponseUtil().response(rsp, HttpStatus.OK);
	}
}
