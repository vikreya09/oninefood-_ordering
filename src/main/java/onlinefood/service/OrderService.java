package onlinefood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import onlinefood.dao.OrderDao;
import onlinefood.exception.EmptyInputException;
import onlinefood.model.Order;

@Service
public class OrderService implements IOrderService {
	@Autowired
	private OrderDao dao;

	@Override
	public Order addOrder(Order order) {
//		if (order.getOrderFoodName().isEmpty() || order.getOrderFoodName().length() == 0) {
//			throw new EmptyInputException("515", "Input Fields Can't be Empty");
//		}
		return dao.save(order);
	}

	@Override
	public Order getOrder(long orderId) {
		if (orderId != 0) {
			return dao.findByOrderId(orderId);
		} else {
			return new Order();
		}
	}

//	@Override
//	public Order updateOrder(Order order) {
//		Order od = dao.findByOrderId(order.getOrderId());
//		od.setOrderFoodPrice(order.getOrderFoodPrice());
//		od.setOrderFoodType(order.getOrderFoodType());
//		return dao.save(od);
//	}

	@Override
	public Order deleteOrder(long orderId) {
		Order od = dao.findByOrderId(orderId);
		dao.delete(od);
		if (od != null) {
			return od;
		} else {
			return null;
		}
	}

}
