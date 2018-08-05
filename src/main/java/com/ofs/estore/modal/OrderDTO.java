package com.ofs.estore.modal;

import java.util.List;

public class OrderDTO {

	private long userId;
	private List<OrderItemDTO> orderItemDTOs;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public List<OrderItemDTO> getOrderItemDTOs() {
		return orderItemDTOs;
	}

	public void setOrderItemDTOs(List<OrderItemDTO> orderItemDTOs) {
		this.orderItemDTOs = orderItemDTOs;
	}
}
