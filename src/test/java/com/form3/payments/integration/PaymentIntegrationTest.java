package com.form3.payments.integration;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Configuration for Cucumber JUnit Runner. This is the class that actually loads the feature
 * file and executes the integration test
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/payment.feature",
    plugin = {"pretty", "html:target/cucumber"})
public class PaymentIntegrationTest {

}
