Feature: MagicPinUsers
Background:
    Given Launch the admin portal
    When Entering valid "tladdha@freshworks.io" and "Ssgmpr@tcs21" credentials
    And Tap on Login
    Then User should get logged in to the Admin portal "SYSTEM MANAGEMENT"

  Scenario: TC_001_Verify user able to tap on all the subscription plan
    And Click on all Subscription Plans

  Scenario: TC_002_Verify user able to increase the board limit for the user
    When Tap on details section for the user
    And Tap on Add Boards link
    And Enter <"2"> Board and then tap on Add boards button
    And Tap on confirmation pop-up
    Then Verify Board Addition Confirmation "Board added Successfully!"

  Scenario: TC_003 Verify deleting a user from admin portal
    When Shorting user by name as DESC
    And Tap on details section for the user
    And Tap on Delete user button
    Then Tap on confirmation pop-up
#    Then Verify Confirmation Text "User Deleted Successfully!"

  Scenario: TC_004 Verify the conversion of the free user to 1 month trial user
    When Tap on Free user section
    And Tap on details section for the user
    And Tap on Change to Grandfather Button
    And Select Duration "1 Month"
#    Then Verify Confirmation Text "User Subscription Changed Successfully!"

  Scenario: TC_005 Verify the conversion of the Trial user back to Free user
    When Tap on Trial user section
    And Tap on details section for the user
    And Tap on the change to Free button
    And Tap on confirmation pop-up
#    Then Verify Confirmation Text "User Subscription changed Successfully!"

  Scenario: TC_006 Verify the conversion of the Free user to Grandfather user
    When Tap on Free user section
    And Tap on details section for the user
    And Tap on Change to Grandfather Button
    And Select Duration "Forever"
#    Then Verify Confirmation Text "User Subscription Changed Successfully!"

  Scenario: TC_007 Verify the conversion of the Grandfather to Free user
    When Tap on Grandfather user section
    And Tap on details section for the user
    And Tap on the change to Free button
    And Tap on confirmation pop-up
#    Then Verify Confirmation Text "User Subscription changed Successfully!"