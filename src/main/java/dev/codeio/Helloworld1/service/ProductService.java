package dev.codeio.Helloworld1.service;

import org.springframework.stereotype.Service;

import dev.codeio.Helloworld1.DTO.ProductData;
@Service
public class ProductService {
	public ProductData getProduct() {
		ProductData p1 = new ProductData();
		p1.setProductName("AC");
		p1.setDescription("LG 1ton with stazbler");
		p1.setCustomerReviews("Good");
		p1.setPrices(30000);
		p1.setImages("IMg.png");
		p1.setSpecification("1ton");
		return p1;
		
	}
}
