package com.ofs.estore.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ofs.estore.modal.OrderDTO;
import com.ofs.estore.modal.OrderItemDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {

	@Autowired
	private OrderService orderService;

	@Test
	public void testGetOrderAmount() {

		List<OrderItemDTO> orderItemDTOs = new ArrayList<>();
		orderItemDTOs.add(new OrderItemDTO(1, 2));
		orderItemDTOs.add(new OrderItemDTO(2, 10));
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setUserId(1);
		orderDTO.setOrderItemDTOs(orderItemDTOs);

		double amount = orderService.getOrderAmount(orderDTO);
		Assert.assertNotNull(amount);
	}
}
