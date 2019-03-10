package com.form3.payments;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PaymentStepsTest extends SpringIntegrationTest {

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