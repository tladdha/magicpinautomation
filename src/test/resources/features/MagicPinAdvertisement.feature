Feature: Advertisement section test cases
Background:
  Given Launch the admin portal
  When Entering valid "tladdha@freshworks.io" and "Ssgmpr@tcs21" credentials
  And Tap on Login
  Then User should get logged in to the Admin portal "SYSTEM MANAGEMENT"

  Scenario: Advertisement_TC_001 Verify the user is able to add new Advertisement
    When User taps on Main Advertisement Section
    And Add new Advertisement "Test Add"
    And Tap on confirmation pop-up
    Then Verify Board Addition Confirmation "Option added Successfully!"

  Scenario: Advertisement_TC_002 Verify the user is able to edit the name of an advertisement
    When User taps on Main Advertisement Section
    And Rename Advertisement from "Test Add" to "Test Add 1"
    Then Verify the name changed to "Test Add 1"