package com.form3.payments.repository;

import com.form3.payments.model.Payment;
import java.util.List;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

/**
 * Spring Data repository for storing Payment JSON objects keyed by Payment ID
 */
@EnableScan
public interface PaymentRepository extends CrudRepository<Payment, String> {
}