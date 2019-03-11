package com.form3.payments;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/payment.feature",
    plugin = {"pretty", "html:target/cucumber"})
/**
 * Configuration for Cucumber JUnit Runner
 */
public class PaymentCucumberIntegrationTest {
  String baseUrl = "http://localhost:8080";
}
