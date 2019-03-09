package com.form3.payments.web;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import com.form3.payments.model.Payment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

  @RequestMapping(value = "/payment", method = {POST})
  @ResponseBody
  public ResponseEntity postPayment(@RequestBody Payment payment) {

    MultiValueMap<String, String> headersMap = new HttpHeaders();
    return new ResponseEntity<>(payment, headersMap, OK);
  }

  @RequestMapping(value = "/payments", method = {GET})
  @ResponseBody
  public ResponseEntity getAllPayments() {

    MultiValueMap<String, String> headersMap = new HttpHeaders();
    return new ResponseEntity<>(null, headersMap, OK);
  }

}
