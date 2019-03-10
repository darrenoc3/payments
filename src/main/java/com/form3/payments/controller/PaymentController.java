package com.form3.payments.controller;

import com.form3.payments.model.Payment;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
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
@RequestMapping(value = "/payment")
public class PaymentController {

  @ApiOperation(value = "Create a payment resource")
  @PostMapping
  @ResponseBody
  public ResponseEntity createPayment(@RequestBody Payment payment) {
    // TODO: save payment to repository
    return new ResponseEntity<>(payment, new HttpHeaders(), HttpStatus.OK);
  }

  @ApiOperation(value = "Update a payment resource")
  @PutMapping
  @ResponseBody
  public ResponseEntity updatePayment(@RequestBody Payment payment) {
    Payment updatePayment = getPaymentById(payment.getId());
    if (updatePayment == null) {
      return new ResponseEntity<>("Payment " + payment.getId() + " not found",
          new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
    // TODO: replaced updated payment in repository
    return new ResponseEntity<>(updatePayment, new HttpHeaders(), HttpStatus.OK);
  }

  @ApiOperation(value = "Delete a payment resource")
  @DeleteMapping(value = "{id}")
  @ResponseBody
  public ResponseEntity deletePaymentById(@PathVariable(value = "id") String id) {
    Payment deletePayment = getPaymentById(id);
    if (deletePayment == null) {
      return new ResponseEntity<>("Payment " + id + " not found", new HttpHeaders(),
          HttpStatus.NOT_FOUND);
    }
    // TODO: delete payment from repository
    return new ResponseEntity<>(deletePayment, new HttpHeaders(), HttpStatus.OK);
  }

  @ApiOperation(value = "Fetch a payment resource by ID")
  @GetMapping(value = "{id}")
  @ResponseBody
  public ResponseEntity getPayment(@PathVariable(value = "id") String id) {
    Payment payment = getPaymentById(id);
    if (payment == null) {
      return new ResponseEntity<>("Payment " + id + " not found", new HttpHeaders(),
          HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(payment, new HttpHeaders(), HttpStatus.OK);
  }

  @ApiOperation(value = "Fetch all payment resources")
  @GetMapping(value = "all")
  @ResponseBody
  public ResponseEntity getAllPayments() {
    // TODO: get all payments from repository
    List<Payment> payments = new ArrayList<>();
    return new ResponseEntity<>(payments, new HttpHeaders(), HttpStatus.OK);
  }

  // Avoid code duplication for Get/Update/Delete
  private Payment getPaymentById(String id) {
    // TODO: lookup payment in repository
    return null;
  }
}