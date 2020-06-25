package com.capgemini.fs.dbs.orderItems.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.fs.dbs.orderItems.dto.OrderItemCreatedResponse;
import com.capgemini.fs.dbs.orderItems.entity.OrderItem;
import com.capgemini.fs.dbs.orderItems.exceptions.UnableToCreateOrderItem;
import com.capgemini.fs.dbs.orderItems.service.OrderItemsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class OrderItemsController {

	private static final Logger log = LoggerFactory.getLogger(OrderItemsController.class);
	@Autowired
	OrderItemsService orderItemsService;

	@PostMapping(value = "/createOrderItem")
	public ResponseEntity<?> createOrderItem(@RequestBody @Valid OrderItem orderItem) throws UnableToCreateOrderItem {
		log.info("Calling createOrderItem service!!!");
		log.info("Request:::{}", orderItem);
		OrderItemCreatedResponse response = orderItemsService.createOrderItem(orderItem);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/*@GetMapping(value = "/getOrderItems/{productCode}")
	public ResponseEntity<?> getOrderItemByProductCode(@PathVariable String productCode) {
		log.info("productCode::::{}", productCode);
		OrderItem orderItem = orderItemsService.fetchOrderItemByProductCode(productCode);
		return new ResponseEntity<>(orderItem, HttpStatus.OK);
	}*/

	@GetMapping(value = "/getOrderItem/{orderId}")
	public ResponseEntity<?> getOrderItemsByorderId(@PathVariable long orderId) {
		log.info("Calling getOrderItemsByorderId API!!!!");
		log.info("orderId::::{}", orderId);
		List<OrderItem> orderItem = orderItemsService.fetchOrderItemByOrderId(orderId);
		return new ResponseEntity<>(orderItem, HttpStatus.OK);
	}

	@GetMapping(value = "/getOrderItems")
	public ResponseEntity<?> getOrderItems(@PathVariable String productCode) {
		List<OrderItem> orderItems = orderItemsService.fetchOrderItems();
		return new ResponseEntity<>(orderItems, HttpStatus.OK);
	}
}
