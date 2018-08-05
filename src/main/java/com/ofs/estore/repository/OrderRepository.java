package com.ofs.estore.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ofs.estore.entity.Order;

@Repository
@Transactional
public interface OrderRepository extends JpaRepository<Order, Long> {

}
