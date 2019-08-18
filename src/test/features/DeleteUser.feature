Feature: Delete users by DELETE request to /users endpoint

  Scenario: User is deleted by id
    Given a user exists with id 2
    When a client deletes the user
    Then the status code is 204