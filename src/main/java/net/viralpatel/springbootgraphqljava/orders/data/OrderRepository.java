package net.viralpatel.springbootgraphqljava.orders.data;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<OrderModel, Long> {
    List<OrderModel> findByCustomerId(Long customerId);
}
