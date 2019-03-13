package com.form3.payments.service;

import com.form3.payments.model.Payment;
import com.form3.payments.repository.PaymentRepository;
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

  public Optional<Payment> read(String id) {
    log.trace("Entering read() with {}", id);
    return repository.read(id);
  }

  public Optional<Payment> create(Payment payment) {
    log.trace("Entering create() with {}", payment);
    if (repository.read(payment.getId()).isPresent()) {
      log.warn("Payment with id={} exits already", payment.getId());
      return Optional.empty();
    }
    repository.save(payment);
    return Optional.of(payment);
  }
/*
  public Optional<Payment> replace(Payment newPaymentData) {
    log.trace("Entering replace() with {}", newPaymentData);
    Optional<Payment> opt = repository.read(newPaymentData.getId());
    if (!existingPayment.isPresent()) {
      log.warn("Payment {} not found", newPaymentData.getId());
      return Optional.empty();
    }
    Payment payment = opt.get();
    payment.setAddress(newPaymentData.getAddress());
    payment.setPhoneNumber(newPaymentData.getPhoneNumber());
    repository.save(payment);
    return Optional.of(payment);
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

  public List<Payment> list() {

    log.trace("Entering list()");
    return repository.readAll();
  }
*/

}
