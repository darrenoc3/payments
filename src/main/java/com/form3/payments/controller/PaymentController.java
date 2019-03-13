package com.form3.payments.controller;

import com.form3.payments.model.Payment;
import com.form3.payments.repository.PaymentRepository;
import com.form3.payments.service.PaymentService;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Loggable
@RequestMapping(value = "/payment")
/**
 * REST API Controller that provides the capability to fetch, create, update and delete JSON Payment
 * objects
 */
public class PaymentController {

  @Autowired
  private PaymentService service;

  private final Logger log = LoggerFactory.getLogger(PaymentController.class);

  @ApiOperation(value = "Create a payment resource")
  @PostMapping
  @ResponseBody
  public ResponseEntity createPayment(@RequestBody Payment payment) {
    log.trace("Entering createPayment() with {}", payment);
    return service.create(payment)
        .map(newPayment -> new ResponseEntity<>(newPayment, HttpStatus.CREATED))
        .orElse(new ResponseEntity<>(HttpStatus.CONFLICT));
  }

  @ApiOperation(value = "Update a payment resource")
  @PutMapping
  @ResponseBody
  public ResponseEntity updatePayment(@RequestBody Payment payment) {
    /*
    Payment updatePayment = service.read(payment.getId());
    if (updatePayment == null) {
      return new ResponseEntity<>("Payment " + payment.getId() + " not found",
          new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
    // TODO: replaced updated payment in repository
    return new ResponseEntity<>(updatePayment, new HttpHeaders(), HttpStatus.OK); */
    return null;
  }

  @ApiOperation(value = "Delete a payment resource")
  @DeleteMapping(value = "{id}")
  @ResponseBody
  public ResponseEntity deletePaymentById(@PathVariable(value = "id") String id) {
    /*
    Payment deletePayment = getPaymentById(id);
    if (deletePayment == null) {
      return new ResponseEntity<>("Payment " + id + " not found", new HttpHeaders(),
          HttpStatus.NOT_FOUND);
    }
    // TODO: delete payment from repository
    return new ResponseEntity<>(deletePayment, new HttpHeaders(), HttpStatus.OK); */
    return null;
  }

  @ApiOperation(value = "Fetch a payment resource by ID")
  @GetMapping(value = "{id}")
  @ResponseBody
  public ResponseEntity<Payment> getPayment(@PathVariable String id) {
    return service.read(id)
        .map(payment -> new ResponseEntity<>(payment, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @ApiOperation(value = "Fetch all payment resources")
  @GetMapping(value = "all")
  @ResponseBody
  public ResponseEntity getAllPayments() {
    // TODO: get all payments from repository
    List<Payment> payments = new ArrayList<>();
    return new ResponseEntity<>(payments, new HttpHeaders(), HttpStatus.OK);
  }
}