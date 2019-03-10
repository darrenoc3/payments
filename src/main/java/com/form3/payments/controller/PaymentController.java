package com.form3.payments.controller;

import static org.springframework.http.HttpStatus.OK;

import com.form3.payments.model.Payment;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpHeaders;
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

    MultiValueMap<String, String> headersMap = new HttpHeaders();
    return new ResponseEntity<>(payment, headersMap, OK);
  }

  @ApiOperation(value = "Update a payment resource")
  @PutMapping
  @ResponseBody
  public ResponseEntity updatePayment(@RequestBody Payment payment) {
    Payment updatedPayment = new Payment();
    MultiValueMap<String, String> headersMap = new HttpHeaders();
    return new ResponseEntity<>(updatedPayment, headersMap, OK);
  }

  @ApiOperation(value = "Delete a payment resource")
  @DeleteMapping(value = "{id}")
  @ResponseBody
  public Payment deletePaymentById(@PathVariable(value = "id") String id) {
    return new Payment();
  }

  @ApiOperation(value = "Fetch a payment resource by ID")
  @GetMapping(value = "{id}")
  @ResponseBody
  public Payment getPaymentById(@PathVariable(value = "id") String id) {
    return new Payment();
  }

  @ApiOperation(value = "Fetch all payment resources")
  @GetMapping(value = "all")
  @ResponseBody
  public List<Payment> getAllPayments() {
    MultiValueMap<String, String> headersMap = new HttpHeaders();
    return new ArrayList<>();
  }

}
