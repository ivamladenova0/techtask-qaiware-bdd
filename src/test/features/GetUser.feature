Feature: Get user by id

  Scenario: Get existing user
    Given a user exists with id 2
    When client retrieves the user
    Then the status code is 200
    And response includes the following
      | data.id         | 2                                                                  |
      | data.email      | janet.weaver@reqres.in                                             |
      | data.first_name | Janet                                                              |
      | data.last_name  | Weaver                                                             |
      | data.avatar     | https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg |

  Scenario: Get non-existing user
    Given a user exists with id 23
    When client retrieves the user
    Then the status code is 404