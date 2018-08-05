package com.ofs.estore.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ofs.estore.entity.Product;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByIdIn(List<Long> ids);
}
