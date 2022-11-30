Feature: Advertisement section test cases
Background:
#  Given Launch the admin portal
#  When Entering valid "tladdha@freshworks.io" and "Ssgmpr@tcs21" credentials
#  And Tap on Login
#  Then User should get logged in to the Admin portal "SYSTEM MANAGEMENT"

  Scenario: Advertisement_TC_001 Verify the user is able to add new Advertisement
#    Given Launch the admin portal
#    When Entering valid "tladdha@freshworks.io" and "Ssgmpr@tcs21" credentials
#    And Tap on Login
#    Then User should get logged in to the Admin portal "SYSTEM MANAGEMENT"
    When Navigate to home page
    When User taps on Main Advertisement Section
    And Add new Advertisement "Test Add"
    And Tap on confirmation pop-up
    Then Verify Board Addition Confirmation "Option added Successfully!"

  Scenario: Advertisement_TC_002 Verify the user is able to edit the name of an advertisement
    When User taps on Main Advertisement Section
    And Rename Advertisement from "Test Add" to "Test Add 1"
    Then Verify the name changed to "Test Add 1"

  Scenario: Advertisement_TC_003 Verify the user able to Inactivate the active advertisement option
    When User taps on Main Advertisement Section
    And Tap on status button of add "Test Add 1"
    And Tap on confirmation pop-up
    Then Verify the "Test Add 1" Add becomes "Active"

  Scenario: Advertisement_TC_004 Verify the user is able to Activate the inactive advertisement option
    When User taps on Main Advertisement Section
    And Tap on status button of add "Test Add 1"
    And Tap on confirmation pop-up
    Then Verify the "Test Add 1" Add becomes "Inactive"

  Scenario: Advertisement_TC_005_Verify the user is able to delete the advertisement option only if it is Inactive
    When User taps on Main Advertisement Section
    And Tap on status button of add "Test Add 1"
    And Tap on confirmation pop-up
    Then Verify the "Test Add 1" Add becomes "Active"
    And Tap on the delete option of an inactive add "Test Add 1"
    And Tap on confirmation pop-up
    Then verify the add with name "Test Add 1" not present

