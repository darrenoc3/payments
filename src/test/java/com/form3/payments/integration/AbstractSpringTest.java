package com.form3.payments.integration;

import com.form3.payments.model.Payment;
import java.util.Optional;
import org.junit.Ignore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

/**
 * Helper base class that loads the SpringBoot context for use in Cucumber StepDefinition tests as
 * well as handling the logic for executing REST calls
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Ignore
public abstract class AbstractSpringTest {

  private static final Logger log = LoggerFactory.getLogger(AbstractSpringTest.class);

  private final String HOST = "http://localhost";
  private final String ENDPOINT = "/payment";

  private TestRestTemplate restTemplate;

  @LocalServerPort
  protected int port;

  private String getPaymentUrl() {
    return HOST + ":" + port + ENDPOINT;
  }

  private TestRestTemplate getRestTemplate() {
    return restTemplate != null ? restTemplate : new TestRestTemplate();
  }

  ResponseEntity<Payment> executeGet(String paymentId) {
    String urlWithId = getPaymentUrl() + "/" + paymentId;
    return executeRestCall(urlWithId, HttpMethod.GET, Optional.empty());
  }

  ResponseEntity<Payment> executePost(Payment payment) {
    return executeRestCall(getPaymentUrl(), HttpMethod.POST, Optional.of(payment));
  }

  ResponseEntity<Payment> executePut(Payment payment) {
    return executeRestCall(getPaymentUrl(), HttpMethod.PUT, Optional.of(payment));
  }

  ResponseEntity<Payment> executeDelete(String paymentId) {
    String urlWithId = getPaymentUrl() + "/" + paymentId;
    return executeRestCall(urlWithId, HttpMethod.DELETE, Optional.empty());
  }

  private ResponseEntity<Payment> executeRestCall(String url, HttpMethod method,
      Optional<Payment> payment) {
    HttpEntity requestEntity = null;
    if (payment.isPresent()) {
      // Set the Payment object in the request if one is provided
      requestEntity = new HttpEntity<Payment>(payment.get(), new HttpHeaders());
    }
    try {
      return getRestTemplate().exchange(url, method, requestEntity, Payment.class);
    } catch (HttpClientErrorException e) {
      if (e.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
        // Spring Rest Template throws exceptions for 404s instead of returning them, so we need to
        // catch and return them so we can properly test for failure cases
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.NOT_FOUND);
      } else {
        throw e;
      }
    }
  }
}
