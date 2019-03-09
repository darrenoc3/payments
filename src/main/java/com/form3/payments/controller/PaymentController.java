package com.form3.payments.controller;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import com.form3.payments.model.Payment;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

  @ApiOperation(value = "Add a payment resource")
  @RequestMapping(method = {POST})
  @ResponseBody
  public ResponseEntity postPayment(@RequestBody Payment payment) {

    MultiValueMap<String, String> headersMap = new HttpHeaders();
    return new ResponseEntity<>(payment, headersMap, OK);
  }

  @ApiOperation(value = "Delete a payment resource")
  @RequestMapping(method = {DELETE})
  @ResponseBody
  public Payment deletePaymentById(@PathVariable(value = "id") String id) {
    return new Payment();
  }

  @ApiOperation(value = "Fetch a payment resource by ID")
  @RequestMapping(value = "{id}", method = {GET})
  @ResponseBody
  public Payment getPaymentById(@PathVariable(value = "id") String id) {
    return new Payment();
  }


  @ApiOperation(value = "Fetch all payment resources")
  @RequestMapping(value = "all", method = {GET})
  @ResponseBody
  public List<Payment> getAllPayments() {

    MultiValueMap<String, String> headersMap = new HttpHeaders();
    return new ArrayList<Payment>();
  }

}
