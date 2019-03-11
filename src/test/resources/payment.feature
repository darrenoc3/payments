# Gherkin configuration for Payment BDD tests using Cucumber

Feature: Testing a Payment REST API
  Users should be able to fetch, create, update and delete JSON Payments objects through the API

  Scenario: client makes call to GET /payment
    When the client calls /payment
    Then the client receives status code of 200