Feature: In the login function I want to create an account and register as a user in Mailchimp.

  @L
  Scenario Outline: I enter information in login page to enter Mailchimp website.
    Given User is already on the login webpage.
    When title of the webpage is asserted and User accept cookies
    Then User input the <email> in the box.
    And User enter <username>
    Then User inputs <password>.
    Then User click on Sign Up button.
    Then It will display a <message> for the user.

    Examples:
      | email                   | username       | password       | message                                     |
      | empty-email             | Valid_username | valid_password | Please enter a value                        |
      | hejsanhopss10@gmail.com | randomUsername | valid_password | Enter a value less than 100 characters long |



