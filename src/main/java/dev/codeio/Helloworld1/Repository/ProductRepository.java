package dev.codeio.Helloworld1.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.codeio.Helloworld1.DTO.ProductData;
import jakarta.transaction.Transactional;

@Repository
public interface ProductRepository extends JpaRepository<ProductData, Long>{
	
	List<ProductData> findByProductName(String product_name);
	
	
	@Modifying
	@Transactional
	@Query("UPDATE ProductData p SET p.productName = :name WHERE p.id = :id")
	void updateName(@Param("id") long id, @Param("name") String name);
	
}
