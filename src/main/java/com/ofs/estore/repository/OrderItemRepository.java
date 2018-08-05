package com.ofs.estore.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ofs.estore.entity.OrderItem;

@Repository
@Transactional
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
