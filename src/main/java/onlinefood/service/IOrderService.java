package onlinefood.service;

import onlinefood.model.Order;

public interface IOrderService {
	public Order addOrder(Order order);
	public Order getOrder(long orderId);
//	public Order updateOrder(Order order);
	public Order deleteOrder(long orderId);
}
