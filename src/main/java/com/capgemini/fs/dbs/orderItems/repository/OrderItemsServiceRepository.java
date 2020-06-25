/**
 * 
 */
package com.capgemini.fs.dbs.orderItems.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.fs.dbs.orderItems.entity.OrderItem;

/**
 * @author burli
 *
 */
@Repository
public interface OrderItemsServiceRepository  extends CrudRepository<OrderItem,Long>{

	OrderItem findByItemID(long itemID);
	List<OrderItem> findByOrderId(long orderId);
	List<OrderItem> findAll();
	Optional<OrderItem> findByProductCode(String productCode);
	
}
