package onlinefood.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import onlinefood.model.Order;

public interface OrderDao extends JpaRepository<Order, Long> {
	public Order findByOrderId(long orderId);

	public void save(List<Order> order);

}
