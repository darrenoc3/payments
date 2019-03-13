package com.form3.payments.service;

import com.form3.payments.model.Payment;
import com.form3.payments.repository.PaymentRepository;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
/**
 * Service that acts as a pass-through to abstract the REST Controller from the data layer
 * The additional layer of abstraction could be considered overkill for a demo application,
 * but it's a good way to demonstrate extensibility and adherence to good design patterns.
 */
public class PaymentService {

  @Autowired
  private PaymentRepository repository;

  private final Logger log = LoggerFactory.getLogger(PaymentService.class);

  public Optional<Payment> get(String id) {
    log.trace("Entering get() with {}", id);
    return repository.read(id);
  }

  public List<Payment> findByOrganisationId(String organisationId) {
    log.trace("Entering findByOrganisationId() with {}", organisationId);
    return repository.readByOrganisationId(organisationId);
  }

  public Payment create(Payment payment) {
    log.trace("Entering create() with {}", payment);
    repository.save(payment);
    return payment;
  }

  public Optional<Payment> replace(Payment newPaymentData) {
    log.trace("Entering replace() with {}", newPaymentData);
    Optional<Payment> existingPayment = repository.read(newPaymentData.getId());
    if (!existingPayment.isPresent()) {
      log.warn("Payment {} not found", newPaymentData.getId());
      return Optional.empty();
    }
    repository.save(newPaymentData);
    return Optional.of(newPaymentData);
  }

  public boolean delete(String name) {
    log.trace("Entering delete() with {}", name);
    if (!repository.read(name).isPresent()) {
      log.warn("Payment {} not found", name);
      return false;
    }
    repository.delete(name);
    return true;
  }
}
