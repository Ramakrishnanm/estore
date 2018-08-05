package com.ofs.estore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ofs.estore.entity.Product;
import com.ofs.estore.entity.ProductCategory;
import com.ofs.estore.entity.User;
import com.ofs.estore.entity.UserType;
import com.ofs.estore.repository.ProductCategoryRepository;
import com.ofs.estore.repository.ProductRepository;
import com.ofs.estore.repository.UserRepository;
import com.ofs.estore.repository.UserTypeRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private UserTypeRepository userTypeRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		List<UserType> userTypes = insertUserTypes();
		insertUsers(userTypes);
		List<ProductCategory> productCategories = insertProductCategories();
		insertProducts(productCategories);
	}

	private List<UserType> insertUserTypes() {

		List<UserType> userTypes = Arrays.asList(
				new UserType(UserType.TYPES.EMPLOYEE.getValue(), .30),
				new UserType(UserType.TYPES.AFFLIATE.getValue(), .10));

		userTypes.forEach(userType -> userTypeRepository.save(userType));

		return userTypes;
	}

	private List<User> insertUsers(List<UserType> userTypes) {

		List<User> users = new ArrayList<User>(3);

		User user = new User();
		user.setUsername("steve");
		user.setCreatedAt(new Date());
		user.setUserType(userTypes.get(0));
		user = userRepository.save(user);
		users.add(user);

		return users;
	}

	private List<ProductCategory> insertProductCategories() {

		List<ProductCategory> productCategories = Arrays.asList(
				new ProductCategory("Electronics", true),
				new ProductCategory("Groceries", false));

		productCategories.forEach(category -> productCategoryRepository.save(category));

		return productCategories;
	}

	private void insertProducts(List<ProductCategory> productCategories) {

		List<Product> products = Arrays.asList(
				new Product("iPhone", 1000, productCategories.get(0), 10),
				new Product("Cooking Oil", 5, productCategories.get(1), 25));

		products.forEach(product -> productRepository.save(product));
	}
}