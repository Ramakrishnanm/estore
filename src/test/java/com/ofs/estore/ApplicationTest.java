package com.ofs.estore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ofs.estore.service.OrderServiceTest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
	
	@Autowired
	private OrderServiceTest orderServiceTest;

	@Test
	public void contextLoads() throws Exception {
		orderServiceTest.testGetOrderAmount();
	}
}
