package dev.codeio.Helloworld1.DTO;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class ProductData {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column
	private String productName;
	@Column
	String Description;
	@Column
	String prices;
	@Column
	String Images;
	@Column
	String CustomerReviews;
	@Column
	String Specification;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getPrices() {
		return prices;
	}
	public void setPrices(String prices) {
		this.prices = prices;
	}
	public String getImages() {
		return Images;
	}
	public void setImages(String images) {
		Images = images;
	}
	public String getCustomerReviews() {
		return CustomerReviews;
	}
	public void setCustomerReviews(String customerReviews) {
		CustomerReviews = customerReviews;
	}
	public String getSpecification() {
		return Specification;
	}
	public void setSpecification(String specification) {
		Specification = specification;
	}
}