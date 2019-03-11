package com.form3.payments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Payments REST API Demo implemented using Sprint Boot & DynamoDB.
 * Supports fetching, creation, updating and deletion of Payment JSON objects e.g:
 * http://mockbin.org/bin/41ca3269-d8c4-4063-9fd5-f306814ff03f
 *
 * @author  Darren O'Connor
 * @version 0.0.1
 * @since   2019-03-12
 */
@SpringBootApplication
public class PaymentsApplication {

  public static void main(String[] args) {
    SpringApplication.run(PaymentsApplication.class, args);
  }

}
