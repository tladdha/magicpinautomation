Feature: MagicPinUsers

  Scenario: Users_TC_001_Verify user able to tap on all the subscription plan
    Given Launch the admin portal
    When Entering valid "tladdha@freshworks.io" and "Ssgmpr@tcs21" credentials
    And Tap on Login
    Then User should get logged in to the Admin portal "SYSTEM MANAGEMENT"
    And Click on all Subscription Plans

  Scenario: Users_TC_002_Verify user able to increase the board limit for the user
    When Tap on Main Users section
    And Tap on details section for the user
    And Tap on Add Boards link
    And Enter <"2"> Board and then tap on Add boards button
    And Tap on confirmation pop-up
    Then Verify Board Addition Confirmation "Board added Successfully!"

  Scenario: Users_TC_003 Verify deleting a user from admin portal
    When Tap on Main Users section
    And Shorting user by name as DESC
    And Tap on details section for the user
    And Tap on Delete user button
    Then Tap on confirmation pop-up
#    Then Verify Confirmation Text "User Deleted Successfully!"

  Scenario: Users_TC_004 Verify the conversion of the free user to 1 month trial user
    When Waiting for first row appears
    And Tap on Main Users section
    And Tap on Free user section
    And Tap on details section for the user
    And Tap on Change to Grandfather Button
    And Select Duration "1 Month"
#    Then Verify Confirmation Text "User Subscription Changed Successfully!"

  Scenario: Users_TC_005 Verify the conversion of the Trial user back to Free user
    When Waiting for first row appears
    And Tap on Main Users section
    And Tap on Trial user section
    And Tap on details section for the user
    And Tap on the change to Free button
    And Tap on confirmation pop-up
#    Then Verify Confirmation Text "User Subscription changed Successfully!"

  Scenario: Users_TC_006 Verify the conversion of the Free user to Grandfather user
    When Waiting for first row appears
    And Tap on Main Users section
    When Tap on Free user section
    And Tap on details section for the user
    And Tap on Change to Grandfather Button
    And Select Duration "Forever"
#    Then Verify Confirmation Text "User Subscription Changed Successfully!"

  Scenario: Users_TC_007 Verify the conversion of the Grandfather to Free user
    When Waiting for first row appears
    And Tap on Main Users section
    And Tap on Grandfather user section
    And Tap on details section for the user
    And Tap on the change to Free button
    And Tap on confirmation pop-up
#    Then Verify Confirmation Text "User Subscription changed Successfully!"

  Scenario: Users_TC_008 Verify the Search functionality working fine
    When Navigate to home page
    And Enter the search text and search result for "qaatfresh"
    Then Verify the searched text "qaatfresh" is present in the result