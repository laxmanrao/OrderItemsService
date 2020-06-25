/**
 * 
 */
package com.capgemini.fs.dbs.orderItems.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.fs.dbs.orderItems.controller.OrderItemsController;
import com.capgemini.fs.dbs.orderItems.dto.OrderItemCreatedResponse;
import com.capgemini.fs.dbs.orderItems.entity.OrderItem;
import com.capgemini.fs.dbs.orderItems.exceptions.OrderItemNotFound;
import com.capgemini.fs.dbs.orderItems.exceptions.UnableToCreateOrderItem;
import com.capgemini.fs.dbs.orderItems.repository.OrderItemsServiceRepository;
import com.capgemini.fs.dbs.orderItems.service.OrderItemsService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author burli
 *
 */
@Service
@Slf4j
public class OrderItemsServiceImpl implements OrderItemsService {
	private static final Logger log= LoggerFactory.getLogger(OrderItemsController.class);

	@Autowired
	private OrderItemsServiceRepository orderItemsServiceRepository;

	@Override
	public OrderItemCreatedResponse createOrderItem(OrderItem orderItem) throws UnableToCreateOrderItem {
		OrderItemCreatedResponse orderItemCreatedResponse = new OrderItemCreatedResponse();
		
		try {
			orderItemsServiceRepository.save(orderItem);
			orderItemCreatedResponse.setMessage("Order Item Created Successfully!!!");
			orderItemCreatedResponse.setProductCode(orderItem.getProductCode());
		}catch(Exception e) {
			log.error("Error occur while create Order:::{}",e.getMessage());
			throw new UnableToCreateOrderItem(e.getMessage());
		}
		return orderItemCreatedResponse;
	}

	@Override
	public List<OrderItem> fetchOrderItems() {
		List<OrderItem> orderItems = orderItemsServiceRepository.findAll();
		log.info("orederItems:::{}",orderItems);
		if (orderItems.size() == 0) {
			throw new OrderItemNotFound("No items found.");
		}
		return orderItems;
	}

	@Override
	public OrderItem fetchOrderItemByProductCode(String productCode) {
		Optional<OrderItem> orderItem = orderItemsServiceRepository.findByProductCode(productCode);

		if (orderItem.isPresent()) {
			return orderItem.get();
		} else {
			throw new OrderItemNotFound("No items found.");
		}

	}
	
	@Override
	public List<OrderItem> fetchOrderItemByOrderId(long orderId) {
		List<OrderItem> orderItems = orderItemsServiceRepository.findByOrderId(orderId);
		log.info("orederItems:::{}",orderItems);
		if (orderItems.size() == 0) {
			throw new OrderItemNotFound("No items found.");
		}
		return orderItems;

	}

}
