Feature: In the login function I want to create an account and register as a user in Mailchimp.


  Scenario: I enter information in login page to enter Mailchimp website.
    Given User is already on the login webpage.
    When title of the webpage is asserted and User accept cookies
    Then User enter no information on the email box.
    And User enter account name with more then one hundred 'characters'.
    Then User enter an already busy 'name'.
    Then User creates an account with no problems.

