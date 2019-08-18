Feature: Register new user with POST request to /register endpoint

  Scenario: User registered a valid email and password
    Given a user with valid email eve.holt@reqres.in and password pistol exists
    When the client registers the user
    Then the status code is 200
    And response includes the following
      | id    | 4                 |
      | token | QpwL5tke4Pnpja7X4 |

  Scenario: User registeres with invalid email and valid password
    Given a user with valid email eve.holt@reqres.in1 and password pistol exists
    When the client registers the user
    Then the status code is 400
    And response includes the following
      | error | Note: Only defined users succeed registration |