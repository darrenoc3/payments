Feature: a payment can be retrieved
  Scenario: client makes call to GET /payment
    When the client calls /payment
    Then the client receives status code of 200