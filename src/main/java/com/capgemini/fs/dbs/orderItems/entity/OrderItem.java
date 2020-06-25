/**
 * 
 */
package com.capgemini.fs.dbs.orderItems.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * @author burli
 *
 */
@Entity
@Setter
@Getter
@ToString
public class OrderItem {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long itemID;
	
	@Column
	//@NotNull(message="customerId must not null")
	private long orderId;

	@Column
	@Pattern(regexp = "^[A-Za-z0-9_-]{1,20}$", message = "Invalid ProductCode,product code size should be size not graterthan 20 and contains only alphanumeric values.")
	private String productCode;

	@Column
	@Pattern(regexp = "^[A-Za-z0-9_-]{1,20}$",message = "Invalid ProductCode,product code size should be size not graterthan 20 and contains only alphanumeric values.")
	private String productName;

	@Max(value=20,message="quantity shoud't be graterthan 20")
	@Column
	private int quantity;

	
}
