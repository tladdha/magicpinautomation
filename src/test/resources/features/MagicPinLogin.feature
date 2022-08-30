Feature: Magic Pin Login

  Scenario Outline: Login Magic pin admin portal
    Given Launch the admin portal
    When Entering valid "<userName>" and "<Passwords>" credentials
    And Tap on Login
    Then User should get logged in to the Admin portal
    And Validate the page should be users page
    Examples:
      | userName              | Passwords    |
      | tladdha@freshworks.io | Ssgmpr@tcs21 |


