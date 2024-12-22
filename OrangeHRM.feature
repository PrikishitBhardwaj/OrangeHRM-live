Feature: OrangeHRM Application Testing

  @Login
  Scenario Outline: Verify login functionality with various credentials
    Given I open the browser and navigate to "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When I input Username "<username>" and Password "<password>"
    Then I click the login button
    Then I should see "<expectedMessage>"
    And I reset the login page

    Examples:
      | username  | password   | expectedMessage                        |
      | wrongUser | admin123   | Invalid credentials                    | # Invalid username
      | Admin     | wrongPass  | Invalid credentials                    | # Invalid password
      |           | admin123   | Username cannot be empty               | # Username empty
      | Admin     |            | Password cannot be empty               | # Password empty
      |           |            | Username and Password cannot be empty  | # Both fields empty
      | Admin     | admin123   | Dashboard                              | # Positive credentials

  @Dashboard
  Scenario: Validate OrangeHRM Dashboard elements after successful login
    Given I log in with valid credentials "Admin" and "admin123"
    Then I should be on the Dashboard page
    And I validate all buttons on the page
    And I validate all links on the page
    And I validate all input fields on the page
    And I validate all attributes on the page

  @SystemUsers
  Scenario: Search for an existing user in the System Users page
    Given I log in with valid credentials "Admin" and "admin123"
    And I navigate to the System Users page
    When I search for user "Admin"
    Then I should see at least one user in the results

  @LeaveList
  Scenario: Search leave requests by date range in the Leave List page
    Given I log in with valid credentials "Admin" and "admin123"
    And I navigate to the Leave List page
    When I search leave requests from "2023-01-01" to "2023-12-31"
    Then I should see at least one leave request in the results

  @EmployeeList
  Scenario: Search for an employee in the Employee List page
    Given I log in with valid credentials "Admin" and "admin123"
    And I navigate to the Employee List page
    When I search for employee "John Smith"
    Then I should see at least one employee in the results
