Feature: Get users page by GET request to /users endpoint

  Scenario: Client calls webservice to get page of users
    Given a page exists with id 2
    When a client retrieves the page
    Then the status code is 200
    And response includes the following
      | total              | 12                 |
      | per_page           | 3                  |
      | total_pages        | 4                  |
      | data[0].id         | 4                  |
      | data[0].email      | eve.holt@reqres.in |
      | data[0].first_name | Eve                |