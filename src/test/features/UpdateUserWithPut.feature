Feature: Update user with PUT request to /users endpoint

  Scenario: User job and name can be updated
    Given a webservice can receive user Neo and job The Chosen One fields
    When the client updates the user with id with 2
    Then the status code is 200
    And response includes the following
      | name | Neo            |
      | job  | The Chosen One |