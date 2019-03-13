package com.form3.payments.integration;

import com.form3.payments.model.Payment;
import java.util.Optional;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * Helper base class that loads the SpringBoot context for use in Cucumber StepDefs tests
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Ignore
public abstract class SpringIntegrationTest {

  private static final Logger log = LoggerFactory.getLogger(SpringIntegrationTest.class);

  private final String SERVER_URL = "http://localhost";
  private final String PAYMENT_ENDPOINT = "/payment";

  private RestTemplate restTemplate;

  private Optional<ResponseEntity> latestResponse = Optional.empty();

  @LocalServerPort
  protected int port;

  SpringIntegrationTest() {
    restTemplate = new RestTemplate();
  }

  private String getPaymentEndpoint() {
    return SERVER_URL + ":" + port + PAYMENT_ENDPOINT;
  }

  Optional<ResponseEntity> getLatestResponse() {
    return latestResponse;
  }

  void setLatestResponse(Optional<ResponseEntity> response) {
    this.latestResponse = response;
  }

  Optional<ResponseEntity> get(String paymentId) {
    try {
      setLatestResponse(Optional.of(
          restTemplate.getForEntity(getPaymentEndpoint() + "/" + paymentId, Payment.class)));
    } catch (HttpClientErrorException e) {
      if (e.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
        // Catch and return 404 exceptions as our test scenarios generate them on purpose
        setLatestResponse(Optional.of(
            new ResponseEntity<>(new HttpHeaders(), HttpStatus.NOT_FOUND)));
      } else {
        throw e;
      }
    }
    return latestResponse;
  }

  Optional<ResponseEntity> post(Payment payment) {
    setLatestResponse(Optional.of(
        restTemplate.postForEntity(getPaymentEndpoint(), payment, Payment.class)));
    return latestResponse;
  }

  Optional<ResponseEntity> put(Payment payment) {
    // We have to create our own HttpEntity and use exchange() instead of RestTemplate.put()
    // as it is doesn't return a response and we need to capture the return code for testing
    HttpEntity<Payment> requestEntity = new HttpEntity<Payment>(payment, new HttpHeaders());
    try {
      setLatestResponse(Optional.of(
          restTemplate
              .exchange(getPaymentEndpoint(), HttpMethod.PUT, requestEntity, Payment.class)));
    } catch (HttpClientErrorException e) {
      if (e.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
        // Catch and return 404 exceptions as our test scenarios generate them on purpose
        setLatestResponse(Optional.of(
            new ResponseEntity<>(new HttpHeaders(), HttpStatus.NOT_FOUND)));
      } else {
        throw e;
      }
    }
    return latestResponse;
  }
}