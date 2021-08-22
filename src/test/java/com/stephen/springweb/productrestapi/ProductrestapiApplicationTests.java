package com.stephen.springweb.productrestapi;

import static org.junit.jupiter.api.Assertions.*;

import com.stephen.springweb.productrestapi.entities.Product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class ProductrestapiApplicationTests {
	RestTemplate restTemplate = new RestTemplate();

	@Value("${productrestapi.services.url}")
	private String BASE_URL = "http://localhost:8081/products/";
	
	@Test
	public void testGetProduct() {
		Product product = restTemplate.getForObject(BASE_URL + "1", Product.class);
		assertNotNull(product);
		assertEquals("iphone", product.getName());
	}

	@Test
	public void testCreateProduct() {
		System.out.println(BASE_URL);
		Product product = new Product();
		product.setPrice(200);
		product.setName("Samsung phone");
		product.setDescription("A samsung phone");
		Product response = restTemplate.postForObject(BASE_URL, product, Product.class);

		assertNotNull(response);
		assertNotNull(response.getId());
		assertEquals("Samsung phone", response.getName());
	}

	@Test
	public void testUpdateProduct() {
		Product product = restTemplate.getForObject(BASE_URL +"4", Product.class);
		product.setPrice(1500);
		restTemplate.put(BASE_URL, product);
	}

	@Test
	public void testDeleteProduct() {
		Product product = restTemplate.getForObject(BASE_URL + "3", Product.class);
		restTemplate.delete(BASE_URL + "3", product);
	}
	void contextLoads() {
	}

}
