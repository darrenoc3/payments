package com.form3.payments.integration;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Ignore;

/**
 * Step Definitions to run Cucumber BDD tests using Spring Boot Web Application context
 */
// Use @Ignore so IntellIJ doesn't think its's a test class - PaymentCucumberIntegrationTest is the
// actual class that runs the test
@Ignore
public class PaymentStepsDefinitions extends SpringBaseIntegrationTest {

  private Response response;

  @When("^the client calls /payment$")
  public void the_client_issues_GET_payment() {
    response = RestAssured
        .given()
        .header("Content-type", "application/json")
        .get(super.baseUrl + "/payment")
        .andReturn();
  }

  @Then("^the client receives status code of 200$")
  public void the_client_receives_status_code_of(int statusCode) {
  }
}