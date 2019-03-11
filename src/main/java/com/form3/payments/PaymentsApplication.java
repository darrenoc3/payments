package com.form3.payments;

import com.form3.payments.config.DynamoConfig;
import com.form3.payments.repository.PaymentRepository;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

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
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, // No JPA
    DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableDynamoDBRepositories("com.form3.payments.repository")
@Configuration
@Import({DynamoConfig.class})
public class PaymentsApplication {

  public static void main(String[] args) {
    SpringApplication.run(PaymentsApplication.class, args);
  }

}
