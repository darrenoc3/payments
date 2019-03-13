package com.form3.payments.controller;

import com.form3.payments.model.Payment;
import com.form3.payments.service.PaymentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;
import java.util.ArrayList;
import java.util.List;
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

  @ApiOperation(value = "Create a new payment")
  @PostMapping
  @ResponseBody
  public ResponseEntity create(@RequestBody Payment payment) {
    if (payment.hasId()) {
      return new ResponseEntity<>(
          "Create payment request cannot contain 'id', this field is autogenerated", new HttpHeaders(),
          HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(service.create(payment), HttpStatus.CREATED);
  }

  @ApiOperation(value = "Find a payment by ID")
  @GetMapping(value = "{id}")
  @ResponseBody
  public ResponseEntity<Payment> get(@PathVariable String id) {
    return service.get(id)
        .map(payment -> new ResponseEntity<>(payment, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @ApiOperation(value = "Find payments by Organisation ID")
  @GetMapping(value = "/findByOrganisation")
  @ResponseBody
  public ResponseEntity findByOrganisationId(@ApiParam String organisationId) {
    List<Payment> payments = service.findByOrganisationId(organisationId);
    if(payments.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(payments, HttpStatus.OK);
  }


  @ApiOperation(value = "Update an existing payment")
  @PutMapping
  @ResponseBody
  public ResponseEntity replace(@RequestBody Payment payment) {
    return service.replace(payment)
        .map(newPaymentData -> new ResponseEntity<>(newPaymentData, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @ApiOperation(value = "Delete a payment")
  @DeleteMapping(value = "{id}")
  @ResponseBody
  public ResponseEntity delete(@PathVariable(value = "id") String id) {
    return service.delete(id) ?
        new ResponseEntity<>(HttpStatus.NO_CONTENT) :
        new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}