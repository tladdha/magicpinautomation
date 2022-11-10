Feature: Magic Pin Login

  Scenario Outline: TC_001 Verify the error for password miss-match while entering invalid credentials
    Given Launch the admin portal
    When Entering valid "<userName>" and "<Passwords>" credentials
    And Tap on Login
    Then Verify the error message "<errorMessage>"
    Examples:
      | userName              | Passwords      | errorMessage      |
      | tladdha@freshworks.io | Ssgmpr@tcs2112 | Password mismatch |

  Scenario Outline: TC_002 Verify the validations to email and password fields
    Given Launch the admin portal
    When Entering valid "<userName>" and "<Passwords>" credentials
    And Tap on Login
    Then Verify the email and password validations "<errorEmail>" "<errorPassword>"
    Examples:
      | userName | Passwords | errorEmail                       | errorPassword                           |
      |          |           | Email is required                | Password is required                    |
      | dadasdas | sasa      | Please use a valid email address | Password must be 8 characters in length |

  Scenario Outline: TC_003 Verify Forgot Password flow email validations
    Given Launch the admin portal
    When Tap on forgot password hyperlink
    And Entering email id "<emails>"
    And Tap on Reset Password Button
    Then Validate the email validation Error message "<errorMessage>"
    Examples:
      | emails | errorMessage      |
      |        | Email is required |
      | ashghg | Please use a valid email address |

  Scenario Outline: TC_004 Verify Forgot Password flow - Invalid user
    Given Launch the admin portal
    When Tap on forgot password hyperlink
    And Entering email id "<emails>"
    And Tap on Reset Password Button
    Then Verify the error message "<errorMessage>"
    Examples:
      | emails                 | errorMessage   |
      | tladdha1@freshworks.io | User not found |

  Scenario Outline: TC_005 Verify Forgot Password flow - Valid user
    Given Launch the admin portal
    When Tap on forgot password hyperlink
    And Entering email id "<emails>"
    And Tap on Reset Password Button
    Then Validate the success message for Reset Email "<confirmationMessage>" "<successMessage>"
    Examples:
      | emails                 | confirmationMessage                                    | successMessage           |
      | henrique@freshworks.io | An email is sent with the steps to reset your password | Email sent successfully. |

  Scenario Outline: TC_006 Verify Successful Login Magic pin admin portal
    Given Launch the admin portal
    When Entering valid "<userName>" and "<Passwords>" credentials
    And Tap on Login
    Then User should get logged in to the Admin portal "<LoggedInText>"
    And Validate the page should be users page
    Examples:
      | userName              | Passwords    | LoggedInText      |
      | tladdha@freshworks.io | Ssgmpr@tcs21 | SYSTEM MANAGEMENT |