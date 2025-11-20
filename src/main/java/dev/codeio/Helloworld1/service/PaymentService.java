package dev.codeio.Helloworld1.service;

import org.springframework.stereotype.Service;

import dev.codeio.Helloworld1.DTO.PaymentData;

@Service
public class PaymentService {
	public PaymentData getPayment() {
		PaymentData p1 = new PaymentData();
		p1.setPaymentMethod("UPI");
		p1.setAmount(824.0);
		p1.setStatus("SUCCESS");
		p1.setTransactionId("ID585672");
		return p1;
	}
}
