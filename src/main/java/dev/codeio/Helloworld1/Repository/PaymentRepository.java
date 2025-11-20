package dev.codeio.Helloworld1.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dev.codeio.Helloworld1.DTO.PaymentData;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentData, Long> {
	List<PaymentData> findByStatus(String status);
}
