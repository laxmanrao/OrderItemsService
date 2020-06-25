package com.capgemini.fs.dbs.orderItems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.fs.dbs.orderItems.dto.OrderItemCreatedResponse;
import com.capgemini.fs.dbs.orderItems.entity.OrderItem;
import com.capgemini.fs.dbs.orderItems.exceptions.UnableToCreateOrderItem;

@Service
public interface OrderItemsService {

	public OrderItemCreatedResponse createOrderItem(OrderItem orderItem) throws UnableToCreateOrderItem;

	public List<OrderItem> fetchOrderItems();

	public OrderItem fetchOrderItemByProductCode(String productCode);

	List<OrderItem> fetchOrderItemByOrderId(long orderId);
}
