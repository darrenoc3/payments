package com.form3.payments;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
/**
 * Base class which gets extended by Test classes to load Spring Boot Web Application context
 */
public abstract class SpringBaseIntegrationTest {
  String baseUrl = "http://localhost:8080";
}