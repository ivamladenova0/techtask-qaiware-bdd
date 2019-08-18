Feature: Create a new user by POST request to /users endpoint

   Scenario: Client calls webservice to create a new user
    Given  a webservice can receive user morpheus and job leader fields
    When  a client sends the user and job
    Then the status code is 201
    And response includes the following
      | name | morpheus |
      | job  | leader   |
