# Gherkin configuration for Payment BDD tests using Cucumber

Feature: Testing a Payment REST API
  Users should be able to fetch, create, update and delete JSON Payments objects through the API

  Scenario: Creating a payment
    When the client calls POST /payment
    Then the client receives status code of "201 CREATED"

  Scenario: Retrieving a payment that was created previously
    Given a payment was created previously
    When the client calls GET /payment
    Then the client receives status code of "200 OK"
    And the client receives a payment

  Scenario: Failing to retrieve a payment that doesn't exist
    When the client calls GET /payment
    Then the client receives status code of "404 NOT_FOUND"

  Scenario: Updating a payment that was created previously
    Given a payment was created previously
    When the client calls PUT /payment
    Then the client receives status code of "200 OK"

  Scenario: Failing to update a payment that doesn't exist
    When the client calls PUT /payment
    Then the client receives status code of "404 NOT_FOUND"