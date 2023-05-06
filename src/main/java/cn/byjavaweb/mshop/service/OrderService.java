package cn.byjavaweb.mshop.service;

import cn.byjavaweb.mshop.dto.OrderAddDto;
import cn.byjavaweb.mshop.entity.Orders;
import cn.byjavaweb.mshop.mapper.OrdersMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
	public OrderService(OrdersMapper mapper) {
		this.mapper = mapper;
	}

	private final OrdersMapper mapper;

	public List<Orders> getListOfStatus(int status, int start, int limit) {
		return mapper.getListOfStatus(status, start, limit);
	}

	public List<Orders> getAll() {
		return mapper.getAll();
	}

	public void dispose(int id) {
		mapper.dispose(id);
	}

	public void finish(int id) {
		mapper.finish(id);
	}

	public boolean delete(int id) {
		return mapper.deleteById(id) > 0;
	}

	public List<Orders> findOrdersByUID(int userid) {
		return mapper.selectByUID(userid);
	}

	public boolean update(Orders orders) {
		return mapper.updateById(orders) > 0;
	}

	public Orders getByID(Orders orders) {
		return mapper.selectById(orders.getId());
	}

	public int add(OrderAddDto orderAddDto) {
		mapper.add(orderAddDto);
		return mapper.getLastInsertId();
	}
}
