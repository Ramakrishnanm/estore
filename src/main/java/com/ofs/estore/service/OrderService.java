package com.ofs.estore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofs.estore.entity.Product;
import com.ofs.estore.entity.User;
import com.ofs.estore.modal.OrderDTO;
import com.ofs.estore.modal.OrderItemDTO;
import com.ofs.estore.repository.ProductRepository;
import com.ofs.estore.repository.UserRepository;

@Service
public class OrderService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UserRepository userRepository;

	public double getOrderAmount(OrderDTO orderDTO) {

		boolean isDiscountApplied = false;
		
		List<OrderItemDTO> orderItemDTOs = orderDTO.getOrderItemDTOs();
		List<Long> ids = new ArrayList<Long>();
		orderItemDTOs.forEach((e) -> ids.add(e.getProductId()));

		List<Product> products = productRepository.findByIdIn(ids);
		 
		 Map<Object, Object> productMap = products.stream().collect(
	                Collectors.toMap(x -> x.getId(), x -> x));
		 
		User user = userRepository.getOne(orderDTO.getUserId());
		
		for (OrderItemDTO item: orderItemDTOs) {
			Product prod = (Product) productMap.get(item.getProductId());
			if (prod.getProductCategory().isDiscountApplicable()) {					
				item.setTotalAmount(prod.getUnitPrice() * item.getQuantity() * user.getUserType().getDiscountPercentage());
			} else {
				item.setTotalAmount(prod.getUnitPrice() * item.getQuantity());
			}
		}
		isDiscountApplied = true;
		
		
		if(!isDiscountApplied) {
			//TODO
		}
		return 0;
	}
}
